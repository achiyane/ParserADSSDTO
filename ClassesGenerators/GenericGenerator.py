import Parser as p


def define_class_fields(class_name, class_fields):
    """
    this method is to generate fields for a class given the class name and the fields
    :param class_name: string, name of the class
    :param class_fields: List of tuples, fields of the class, each tuple is a field, [type, name].
    :return: class fields
    """
    fields = ""
    for field in class_fields:
        fields += "private " + field[0] + " " + field[1] + ";\n"
    return fields


def define_class_constructor(class_name, class_fields, added_super_constructor_code=""):
    """
    this method is to generate constructor for a class given the class name and the fields, fields are given as a list of tuples [type, name]
    if a field type is not primitive which is not in [int, float, boolean, String, char, byte, short, long, double]
    , it will be generated as new <field_type>(), and it will not be in the constructor signature.
    :param class_name: string, name of the class
    :param class_fields: List of tuples, fields of the class, each tuple is a field, [type, name].
    :param added_super_constructor_code: string, code to add to the super constructor
    :return: the constructor of the class
    """
    primitive_types = ["int", "float", "boolean", "String", "char", "byte", "short", "long", "double"]
    constructor = "public " + class_name + "("
    for field in class_fields:
        if field[0].strip() in primitive_types:
            constructor += field[0] + " " + field[1] + ", "
    constructor = constructor[:-2]
    constructor += ") {\n" + added_super_constructor_code + "\n"
    for field in class_fields:
        if field[0].strip() in primitive_types:
            constructor += "        this." + field[1] + " = " + field[1] + ";\n"
        else:
            constructor += "        this." + field[1] + " = new " + field[0] + "();\n"
    constructor += "    }\n"
    return constructor


def function_that_return_empty_string(string):
    """
    this method is to return an empty string
    :return: an empty string
    """
    return ""


def define_class_getters_setters(class_name, class_fields, added_code_to_getters=function_that_return_empty_string,
                                 added_code_to_setters=function_that_return_empty_string):
    """
    this method is to generate getters and setters for a class given the class name and the fields, fields are given as a list of tuples [type, name]
    :param class_name: string, name of the class
    :param class_fields: List of tuples, fields of the class, each tuple is a field, [type, name].
    :param added_code_to_getters: str -> str, code to add to the getters
    :param added_code_to_setters: str -> str, code to add to the setters
    :return: the getters and setters of the class
    """
    getters_setters = ""
    for field in class_fields:
        getters_setters += "public " + field[0] + " get" + capitalize_first_letter(field[1]) + "() {\n"
        getters_setters += "        return " + field[1] + ";\n" + added_code_to_getters(field[1])
        getters_setters += "    }\n"
        getters_setters += "    public void set" + capitalize_first_letter(field[1]) + "(" + field[0] + " " + field[
            1] + ") {\n"
        getters_setters += "        this." + field[1] + " = " + field[1] + ";\n" + added_code_to_setters(field[1])
        getters_setters += "    }\n"
    return getters_setters


def define_class_equals(class_name, class_fields):
    """
    equals method template:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof <class_name>)) return false;
        <class_name> that = (<class_name>) o;
        return Object.equals(get<field_name1>(), (that.get<field_name1>())) && Object.equals(get<field_name2>(), (that.get<field_name2>())) && Object.equals(get<field_name3>(), (that.get<field_name3>())) &&  ... && Object.equals(get<field_nameN>(), (that.get<field_nameN>()));
    }
    this method is to generate equals method for a class given the class name and the fields, fields are given as a list of tuples [type, name]
    :param class_name: string, name of the class
    :param class_fields: List of tuples, fields of the class, each tuple is a field, [type, name].
    :return: the equals method of the class
    """
    equals = "    @Override\n    public boolean equals(Object o) {\n        if (this == o) return true;\n        if (!(o instanceof " + class_name + ")) return false;\n        " + class_name + " that = (" + class_name + ") o;\n return "
    for field in class_fields:
        equals += "Object.equals(get" + capitalize_first_letter(field[1]) + "(), (that.get" + capitalize_first_letter(
            field[1]) + "())) && "
    equals = equals[:-4] + ";\n    }\n"
    return equals


"""hashCode method template:
    @Override
    public int hashCode() {
        return Objects.hash(get<field_name1>(), get<field_name2>(), get<field_name3>(), ..., get<field_nameN>());
    }"""


def define_class_hashCode(class_name, class_fields):
    """
    this method is to generate hashCode method for a class given the class name and the fields, fields are given as a list of tuples [type, name]
    :param class_name: string, name of the class
    :param class_fields: List of tuples, fields of the class, each tuple is a field, [type, name].
    :return: the hashCode method of the class
    """
    hashCode = "    @Override\n    public int hashCode() {\n        return Objects.hash("
    for field in class_fields:
        hashCode += "get" + capitalize_first_letter(field[1]) + "(), "
    hashCode = hashCode[:-2] + ");\n    }\n"
    return hashCode


def define_class_toString(class_name, class_fields):
    """
    this method is to generate toString method for a class given the class name and the fields, fields are given as a list of tuples [type, name]
    :param class_name: string, name of the class
    :param class_fields: List of tuples, fields of the class, each tuple is a field, [type, name].
    :return: the toString method of the class
    """
    toString = "    @Override\n    public String toString() {\n        return \"" + class_name + "{"
    for field in class_fields:
        toString += field[1] + ' = [" + ' + "this." + field[1] + '"], " + \n"'
    toString = toString[:-6] + ' " + \n"}";\n'
    toString += "}\n"
    return toString


def capitalize_first_letter(string):
    """
    this method is to capitalize the first letter of a string
    :param string: string, the string to capitalize the first letter
    :return: the string with the first letter capitalized
    """
    if len(string) > 0:
        return string[0].upper() + string[1:]
    return string
