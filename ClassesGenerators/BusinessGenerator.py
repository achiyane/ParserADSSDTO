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


'''
template for the Business class:

public class <class_name> {
    private <class_name>DAO <dao_name>;

    private <field_type1> <field_name1>;
    private <field_type2> <field_name2>;
    private <field_type3> <field_name3>;
    ...
    private <field_typeN> <field_nameN>;

    public <class_name>(<field_type1> <field_name1>, <field_type2> <field_name2>, <field_type3> <field_name3>, ..., <field_typeN> <field_nameN>) {
        this.<field_name1> = <field_name1>;
        this.<field_name2> = <field_name2>;
        this.<field_name3> = <field_name3>;
        ...
        this.<field_nameN> = <field_nameN>;
        this.<dao_name> = new <class_name>DAO();
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
        this.<dao_name>.update(this);
    }
    public void set<field_name2>(<field_type2> <field_name2>) {
        this.<field_name2> = <field_name2>;
        this.<dao_name>.update(this);
    }
    public void set<field_name3>(<field_type3> <field_name3>) {
        this.<field_name3> = <field_name3>;
        this.<dao_name>.update(this);
    }
    ...
    public void set<field_nameN>(<field_typeN> <field_nameN>) {
        this.<field_nameN> = <field_nameN>;
        this.<dao_name>.update(this);
    }

    @Override
    public String toString(){
        return "<class_name>{" +
                "<field_name1> = [" + this.<field_name1> + "], " +
                "<field_name2> = [" + this.<field_name2> + "], " +
                "<field_name3> = [" + this.<field_name3> + "], " +
                ...
                "<field_nameN> = [" + this.<field_nameN> + "]" +
            "}";
    }
'''


def generate_business_class_given_class_name_and_class_fields(class_name, class_fields):
    """
        Generates a Business class given a class name and a list of fields.
        :param class_name: name of the class
        :param class_fields: class fields
        :return: Business class
        """
    # packages and imports are added to the Business class
    packages = """package Logic;
    import DataAccess.DAOs.<class_name>DAO;
    import DataAccess.DTOs.<class_name>DTO;\n\n""".replace("<class_name>", class_name)
    extended_class_fields = class_fields.copy()
    extended_class_fields.append((class_name + "DAO", p.de_capitalize_first_letter(class_name) + "DAO"))
    business_class = ""
    # business class header is added to the Business class
    business_class += "public class " + class_name + " {\n"
    # business class fields is added to the Business class
    business_class += gg.define_class_fields(class_name, extended_class_fields)
    # business class constructor is added to the Business class
    business_class += gg.define_class_constructor(class_name, extended_class_fields)
    # business class getters and setters are added to the Business class
    business_class += gg.define_class_getters_setters(class_name, class_fields,
                                                      added_code_to_setters=lambda x: added_to_setters(class_name, x))
    # business class toString is added to the Business class
    business_class += gg.define_class_toString(class_name, class_fields) + "\n"
    # business class equals is added to the Business class
    business_class += gg.define_class_equals(class_name, class_fields) + "\n"
    # business class hashCode is added to the Business class
    business_class += gg.define_class_hashCode(class_name, class_fields) + "\n"
    # business class footer is added to the Business class
    business_class += "}\n"
    # return the Business class code with the packages and imports, and indent it
    return IndentJavaFile.indentJavaFile(packages + business_class)


def added_to_setters(class_name, class_field):
    return "        this." + p.de_capitalize_first_letter(class_name) + "DAO.update(this);\n"


def create_business_classes(field_dict):
    fD = modify_field_dict_according_to_dict_type_conversion(field_dict)
    ap = os.getcwd() + "\\BusinessFiles" if p.pathToSrc == "default path" else p.path_to_src_components[p.LOGIC]
    p.createDirectoryIfNotExist(ap)
    for class_name in fD.keys():
        fin = generate_business_class_given_class_name_and_class_fields(class_name, fD[class_name])
        open(f'{ap}\\{class_name}.java', "w").write(IndentJavaFile.indentJavaFile(fin))


def modify_field_dict_according_to_dict_type_conversion(field_dict):
    new_field_dict = {}
    for key in field_dict.keys():
        new_field_dict[key] = []
        for i in range(len(field_dict[key])):
            field_type, field_name = field_dict[key][i]
            new_field_dict[key].append([identityFunctionIfNotInDict(field_type), field_name])
    return new_field_dict
