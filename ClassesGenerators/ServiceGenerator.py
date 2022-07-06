import os

from FilesHandlers import IndentJavaFile
import Parser as p
from ClassesGenerators import GenericGenerator as gg

dictForTypesConversion = {'long': 'int'}


def identityFunctionIfNotInDict(x):
    if x in dictForTypesConversion.keys():
        return dictForTypesConversion[x]
    else:
        return x


"""this is the template for the Service class
public class S<class_name> {
    private <field_type1> <field_name1>;
    private <field_type2> <field_name2>;
    private <field_type3> <field_name3>;
    ...
    private <field_typeN> <field_nameN>;
    
    public S<class_name>(<field_type1> <field_name1>, <field_type2> <field_name2>, <field_type3> <field_name3>, ..., <field_typeN> <field_nameN>) {
        this.<field_name1> = <field_name1>;
        this.<field_name2> = <field_name2>;
        this.<field_name3> = <field_name3>;
        ...
        this.<field_nameN> = <field_nameN>;
    }
    
    public <field_type1> get<field_name1>() {
        return this.<field_name1>;
    }
    public <field_type2> get<field_name2>() {
        return this.<field_name2>;
    }
    public <field_type3> get<field_name3>() {
        return this.<field_name3>;
    }
    ...
    public <field_typeN> get<field_nameN>() {
        return this.<field_nameN>;
    }
    public void set<field_name1>(<field_type1> <field_name1>) {
        this.<field_name1> = <field_name1>;
    }
    public void set<field_name2>(<field_type2> <field_name2>) {
        this.<field_name2> = <field_name2>;
    }
    public void set<field_name3>(<field_type3> <field_name3>) {
        this.<field_name3> = <field_name3>;
    }
    ...
    public void set<field_nameN>(<field_typeN> <field_nameN>) {
        this.<field_nameN> = <field_nameN>;
    }
    
    @Override
    public String toString(){
        return "<class_name>{" +
                "<field_name1> = [" + this.<field_name1> + "], " +
                "<field_name2> = [" + this.<field_name2> + "], " +
                "<field_name3> = [" + this.<field_name3> + "], " +
                ...
                "<field_nameN> = [" + this.<field_nameN> + "], " +
                "}";
    }
}
    """


def generate_service_class_given_class_name_and_class_fields(class_name, class_fields):
    service_class_name = "S" + class_name
    # service class header.
    service_class_str = "public class S" + class_name + " {\n"
    # service class fields.
    service_class_str += gg.define_class_fields(service_class_name, class_fields)
    # service class first constructor.
    service_class_str += gg.define_class_constructor(service_class_name, class_fields)
    service_class_str += "\n"
    # service class second constructor.
    service_class_str += define_service_second_constructor(class_name, class_fields) + "\n"
    # service class getters and setters.
    service_class_str += gg.define_class_getters_setters(service_class_name, class_fields)
    service_class_str += "\n"
    # service class toString.
    # service_class_str += define_service_to_string(class_name, class_fields)
    service_class_str += gg.define_class_toString(class_name, class_fields)
    # service class equals.
    service_class_str += gg.define_class_equals(service_class_name, class_fields)
    # service class hashCode.
    service_class_str += gg.define_class_hashCode(service_class_name, class_fields)
    # service class footer.
    service_class_str += "}\n"
    return IndentJavaFile.indentJavaFile("package Service.Objects;\n\n" + service_class_str)


def define_service_to_string(class_name, service_fields):
    service_str = "public String toString(){\n"
    service_str += "return \"" + class_name + '{" + \n'
    for i in range(len(service_fields)):
        service_str += '"' + service_fields[i][1] + ' = [" + ' + "this." + service_fields[i][1] + ' + "], " + \n'
    service_str = service_str[:-2] + '\n "}\";\n'
    service_str += "}\n"
    return service_str


"""service class second constructor template
    public S<class_name>(<class_name> business) {
        this.<field_name1> = business.get<field_name1>();
        this.<field_name2> = business.get<field_name2>();
        this.<field_name3> = business.get<field_name3>();
        ...
        this.<field_nameN> = business.get<field_nameN>();
    }

    """


def define_service_second_constructor(class_name, service_fields):
    service_str = "public S" + class_name + "(" + class_name + " business) {\n"
    service_str += "this." + service_fields[0][1] + " = business.get" + p.capitalize_first_letter(
        service_fields[0][1]) + "();\n"
    for i in range(1, len(service_fields)):
        service_str += "this." + service_fields[i][1] + " = business.get" + p.capitalize_first_letter(
            service_fields[i][1]) + "();\n"
    service_str += "}\n"
    return service_str


def create_service_classes(field_dict):
    fD = modify_field_dict_according_to_dict_type_conversion(field_dict)
    ap = os.getcwd() + "\\ServiceFiles" if p.pathToSrc == "default path" else p.path_to_src_components[
        p.SERVICE_OBJECTS]
    p.createDirectoryIfNotExist(ap)
    for class_name in fD.keys():
        fin = generate_service_class_given_class_name_and_class_fields(class_name, fD[class_name])
        open(f'{ap}\\S{class_name}.java', "w").write(IndentJavaFile.indentJavaFile(fin))


def modify_field_dict_according_to_dict_type_conversion(field_dict):
    new_field_dict = {}
    for key in field_dict.keys():
        new_field_dict[key] = []
        for i in range(len(field_dict[key])):
            field_type, field_name = field_dict[key][i]
            new_field_dict[key].append([identityFunctionIfNotInDict(field_type), field_name])
    return new_field_dict


if __name__ == '__main__':
    class_name = "User"
    dto_fields = [["String", "username"], ["String", "password"], ["String", "email"], ["String", "firstName"],
                  ["String", "lastName"], ["String", "phone"], ["String", "address"], ["String", "city"],
                  ["String", "state"], ["String", "zip"], ["String", "country"], ["String", "birthday"]]
    print(generate_service_class_given_class_name_and_class_fields(class_name, dto_fields))
