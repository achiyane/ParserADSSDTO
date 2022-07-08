import os

from ClassesGenerators import GenericGenerator as gg
import Parser as p
from FilesHandlers import IndentJavaFile

"""given a file of facade/service class, generate a CLI for it

template for the facade/service class:
imports...

public class <class_name> {

    private <controller_type> <controller_name>;
    public <class_name>() {
        // constructor body
    }

    public <return_type1> <method_name1>(<parameter_type1> <parameter_name1>, <parameter_type2> <parameter_name2>, ..., <parameter_typeN> <parameter_nameN>) {
        return <controller_name>.<method_name1>(<parameter_name1>, <parameter_name2>, ..., <parameter_nameN>);
    }

    public <return_type2> <method_name2>(<parameter_type1> <parameter_name1>, <parameter_type2> <parameter_name2>, ..., <parameter_typeN> <parameter_nameN>) {
        return <controller_name>.<method_name2>(<parameter_name1>, <parameter_name2>, ..., <parameter_nameN>);
    }

    ...

    public <return_typeN> <method_nameN>(<parameter_type1> <parameter_name1>, <parameter_type2> <parameter_name2>, ..., <parameter_typeN> <parameter_nameN>) {
        return <controller_name>.<method_nameN>(<parameter_name1>, <parameter_name2>, ..., <parameter_nameN>);
    }


}


the method should return a dictionary of the following format:
{ <method_name>: [[type1, name1], [type2, name2], ..., [typeN, nameN]] }
{ <method_name>: return_type }

"""


def generate_from_facade_class(file_path):
    """generate a CLI for the given file"""
    file_code = open(file_path).read()
    method_dict = {}
    type_dict = {}
    class_name = ""
    for line in file_code.split("\n"):
        if "public" in line and "(" in line and ")" in line and ("Result" in line or "Response" in line):
            parts_list, parameter_list = line.split("(")
            public_stat, method_return_type, method_name = parts_list.strip().split(" ")
            parameter_list = split_by_comma_ignore_if_written_template(parameter_list.split(")")[0].strip())
            # parameter_list = list(filter(lambda x: len(x) > 1,[parameter.strip().split(" ") for parameter in parameter_list]))
            method_dict[method_name] = parameter_list
            type_dict[method_name] = method_return_type
        elif "public" in line and "class" in line:
            class_name = line.split(" ")[2].strip()
    return method_dict, type_dict, class_name


"""template for ignore:
List<Pair<<Type1>, <Type2>>>"""


def split_by_comma_ignore_if_written_template(string):
    """split a string by comma, ignoring if the string is written in the template
    i.e. if the string is "List<Pair<<Type1>, <Type2>>>", it will return ["List<Pair<<Type1>, <Type2>>>"]"""
    list_of_split = string.replace(', ', ",").split(" ")
    normal_list = []
    for split in list_of_split:
        count = 0
        if "<" in split and ">" in split:
            for char in split:
                if char == "<":
                    count += 1
                elif char == ">":
                    count -= 1
                elif char == ",":
                    if count == 0:
                        get = split.split(",")[0]
                        another_get = split[len(get) + 1:]
                        normal_list.extend([get, another_get])
        elif "," in split:
            normal_list.extend(split.split(","))
        elif "" != split:
            normal_list.append(split)
    final_list = []
    i = 0
    while i < len(normal_list):
        final_list.append([normal_list[i], normal_list[i + 1]])
        i += 2
    return final_list


def generate_cli_class(method_dict, type_dict, class_name):
    '''generate a CLI class for the given method_dict
    lets define for each typeI: typeI_convert =
    if typeI is a primitive type, then typeI_convert = makeSupplier(next<typeI>("<parameter_nameI>"))
    if typeI is not a primitive type, then typeI_convert = makeSupplier(chooseFromList("insert list of values here"))
    each method should look like this:
    if return_type is Result<List<type>> then:
        Parser.handleServiceListTRequest("",
                args -> <controller_name>.<method_name>((type1) args[0], (type2) args[1], ..., (typeN) args[N-1]),
                Parser.getUserInputParams(<type1_convert>, <type2_convert>, ..., <typeN_convert>));
    else if return_type is Result then:
        Parser.handleServiceRequest("",
                args -> <controller_name>.<method_name>((type1) args[0], (type2) args[1], ..., (typeN) args[N-1]),
                Parser.getUserInputParams(<type1_convert>, <type2_convert>, ..., <typeN_convert>));
    else if return_type is Result<type> then:
        public void <method_name>() {
            Parser.handleServiceValueRequest("",
                args -> <controller_name>.<method_name>((type1) args[0], (type2) args[1], ..., (typeN) args[N-1]),
                Parser.getUserInputParams(<type1_convert>, <type2_convert>, ..., <typeN_convert>));

    '''
    cli_class_name = class_name + "CLI"
    cli_class_code = "public class " + cli_class_name + " {\n"
    fields = [[class_name, p.de_capitalize_first_letter(class_name)]]
    # generate the fields
    cli_class_code += gg.define_class_fields(cli_class_name, fields)
    # generate the constructor
    cli_class_code += gg.define_class_constructor(cli_class_name, fields)
    # generate the methods
    for method_name in method_dict:
        method_parameter_list = method_dict[method_name]
        method_return_type = type_dict[method_name]
        if "Result<List<" in method_return_type or "Response<List<" in method_return_type:
            cli_class_code += define_class_method_with_handle_service_request(class_name, method_name,
                                                                              method_parameter_list, "ListT")
        elif method_return_type == "Result" or "Response" == method_return_type:
            cli_class_code += define_class_method_with_handle_service_request(class_name, method_name,
                                                                              method_parameter_list)
        elif "Result<" in method_return_type or "Response<" in method_return_type:
            cli_class_code += define_class_method_with_handle_service_request(class_name, method_name,
                                                                              method_parameter_list, "Value")
    cli_class_code += "}"

    return cli_class_code


def define_class_method_with_handle_service_request(cli_class_name, method_name, method_parameter_list, added_code=""):
    """define a method with a void return type"""
    method_code = ""
    method_code += "public void " + method_name + "() {\n"
    method_code += "    Parser.handleService" + added_code + "Request(\"\",\n"
    method_code += "        args -> " + p.de_capitalize_first_letter(cli_class_name) + "." + method_name + "(\n"
    i = 0
    for parameter in method_parameter_list:
        method_code += "            (" + parameter[0] + ") args[" + str(i) + "],\n"
        i += 1
    method_code = method_code[:-2] + "),\n"
    method_code += "        Parser.getUserInputParams("
    new_code = ""
    for parameter in method_parameter_list:
        if "List<" in parameter[0]:
            new_code += "makeSupplier(ScannerStream::getListInput(\"insert your supplier here\")),\n"
        else:
            new_code += "makeSupplier(ScannerStream::next" + p.capitalize_first_letter(parameter[0]) + "(\"" + \
                        parameter[1] + "\")),\n"
    if new_code != "":
        new_code = new_code[:-2] + "));\n"
    else:
        new_code = "));\n"
    method_code += new_code
    method_code += "}\n"
    return method_code


def create_cli_class(pathToFacade):
    ap = os.getcwd() + "\\PresentationFiles" if p.pathToSrc == "default path" else p.path_to_src_components[
        p.PRESENTATION]
    method_dict, type_dict, class_name = generate_from_facade_class(pathToFacade)
    cli_class_code = generate_cli_class(method_dict, type_dict, class_name)
    cli_class_file_name = class_name + "CLI.java"
    p.createDirectoryIfNotExist(ap)
    open(f'{ap}\\{cli_class_file_name}', "w").write(IndentJavaFile.indentJavaFile(cli_class_code))
    print("CLI class created successfully")
