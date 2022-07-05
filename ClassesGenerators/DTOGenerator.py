import os

from FilesHandlers import IndentJavaFile
import Parser as p
from ClassesGenerators import GenericGenerator as gg

'''template of a DTO class:
    
    
    
public class <class_name>DTO extends DTO<PK> {

    private <pk_field_type1> <pk_field_name1>;
    private <pk_field_type2> <pk_field_name2>;
    private <pk_field_type3> <pk_field_name3>;
    ...
    private <pk_field_typeM> <pk_field_nameM>;

    private <field_type1> <field_name1>;
    private <field_type2> <field_name2>;
    private <field_type3> <field_name3>;
    ...
    private <field_typeN> <field_nameN>;
    
    
    public <class_name>DTO(<field_type1> <field_name1>, <field_type2> <field_name2>, <field_type3> <field_name3>, ..., <field_typeN> <field_nameN>) {
        super(new PK(getFields(), <pk_field_name1>, <pk_field_name2>, <pk_field_name3>, ..., <pk_field_nameM>));
        this.<field_name1> = <field_name1>;
        this.<field_name2> = <field_name2>;
        this.<field_name3> = <field_name3>;
        ...
        this.<field_nameN> = <field_nameN>;
    }
    
    public static Field[] getFields(){ 
        return getFields(new String[]{"<pk_field_name1>", "<pk_field_name2>", "<pk_field_name3>", ..., <pk_field_nameM>}, <class_name>DTO.class);
    }
    
    public static PK getPK(<pk_field_type1> <pk_field_name1>, <pk_field_type2> <pk_field_name2>, <pk_field_type3> <pk_field_name3>, ..., <pk_field_typeM> <pk_field_nameM>) { 
        return new PK(getFields(), <pk_field_name1>, <pk_field_name2>, <pk_field_name3>, ..., <pk_field_nameM>);
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
                "<field_nameN> = [" + this.<field_nameN> + "]" +
            "}";
    }
    
    @Override
    public Object[] getValues() {
        return new Object[]{this.<field_name1>, this.<field_name2>, this.<field_name3>, ..., this.<field_nameN>};
    }
}
'''


def generate_dto_by_class_name_fields_and_pk_fields(class_name, dto_fields, dto_pk_fields):
    """dto_fields has a list of lists. [type, name]
    dto_pk_fields has a list of lists. [type, name]"""
    packages = """package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;\n\n"""
    dto_class_name = class_name + "DTO"
    dto_fields_str = gg.define_class_fields(dto_class_name, dto_fields)
    '''for field in dto_fields:
        dto_fields_str += "private " + field[0] + " " + field[1] + ";\n"
    dto_fields_str = dto_fields_str[:-1]'''
    # add the class header and the fields
    dto_str = "public class " + class_name + "DTO extends DTO<PK> {\n"
    dto_str += dto_fields_str + "\n"
    # constructor DTO(field1, field2, ..., fieldN)
    dto_str_pk = "super(new PK(getFields(), "
    # pk_field1, pk_field2, ..., pk_fieldM
    for i in range(len(dto_pk_fields)):
        dto_str_pk += dto_pk_fields[i][1] + ", "
    dto_str_pk = dto_str_pk[:-2] + "));\n"
    dto_str += gg.define_class_constructor(dto_class_name, dto_fields, added_super_constructor_code=dto_str_pk)
    # getFields() method for dto class
    dto_str += define_dto_get_fields(class_name, dto_pk_fields)
    # getPK(pk_field1, pk_field2, ..., pk_fieldM) method for dto class
    dto_str += define_dto_get_pk(class_name, dto_pk_fields)
    # get<field_name>() method for dto class
    # set<field_name>(<field_type> <field_name>) method for dto class
    dto_str += gg.define_class_getters_setters(dto_class_name, dto_fields)
    # toString() method for dto class
    # dto_str += define_dto_to_string(class_name, dto_fields)
    dto_str += gg.define_class_toString(class_name, dto_fields)
    # getValues() method for dto class
    dto_str += define_dto_get_values(class_name, dto_fields)
    # dto class equals method
    dto_str += gg.define_class_equals(dto_class_name, dto_fields)
    # dto class hashCode method
    dto_str += gg.define_class_hashCode(dto_class_name, dto_fields)
    # add class footer
    dto_str += "}\n"
    # return class content as string with package and imports and indentation.
    return IndentJavaFile.indentJavaFile(packages + dto_str)


def define_dto_get_fields(class_name, dto_pk_fields):
    """
    this method is user to generate DTO static method getFields()
    :param class_name: string, class name
    :param dto_pk_fields: List of lists. [type, name]
    :return: the string of the method content
    """
    dto_str = "public static Field[] getFields(){\n"
    # return getFields(new String[]{"pk_field1", "pk_field2", ..., pk_fieldM}, class_nameDTO.class)
    dto_str += "return getFields(new String[]{"
    # pk_field1, pk_field2, ..., pk_fieldM
    for field in dto_pk_fields:
        dto_str += "\"" + field[1] + "\", "
    dto_str = dto_str[:-2] + "}, " + class_name + "DTO.class);\n"
    dto_str += "}\n"
    return dto_str


def define_dto_get_pk(class_name, dto_pk_fields):
    """
    this method is user to generate DTO static method getPK()
    :param class_name: string, the class name
    :param dto_pk_fields: List of lists. [type, name]
    :return: the string with the method content
    """
    dto_str = "public static PK getPK("
    # pk_field1, pk_field2, ..., pk_fieldM
    for field in dto_pk_fields:
        dto_str += field[0] + " " + field[1] + ", "
    dto_str = dto_str[:-2] + ") {\n"
    # return new PK(getFields(), pk_field1, pk_field2, ..., pk_fieldM)
    dto_str += "return new PK(getFields(), "
    # pk_field1, pk_field2, ..., pk_fieldM
    for field in dto_pk_fields:
        dto_str += field[1] + ", "
    dto_str = dto_str[:-2] + ");\n"
    dto_str += "}\n"
    return dto_str


"""
this is how the toString method is defined
    @Override
    public String toString(){
        return "<class_name>{" +
                "<field_name1> = [" + this.<field_name1> + "], " +
                "<field_name2> = [" + this.<field_name2> + "], " +
                "<field_name3> = [" + this.<field_name3> + "], " +
                ...
                "<field_nameN> = [" + this.<field_nameN> + "]" +
            "}";
    }"""


def define_dto_to_string(class_name, dto_fields):
    dto_str = "public String toString(){\n"
    dto_str += "return \"" + class_name + '{" + \n'
    for i in range(len(dto_fields)):
        dto_str += '"' + dto_fields[i][1] + ' = [" + ' + "this." + dto_fields[i][1] + '"], " + '
    dto_str = dto_str[:-6] + ' " + "}";\n'
    dto_str += "}\n"
    return dto_str


def define_dto_get_values(class_name, dto_fields):
    dto_str = "public Object[] getValues(){\n"
    dto_str += "return new Object[]{"
    for i in range(len(dto_fields)):
        dto_str += "this." + dto_fields[i][1] + ", "
    dto_str = dto_str[:-2] + "};\n"
    dto_str += "}\n"
    return dto_str


def create_dto_classes(fD, pkD):
    ap = os.getcwd() + "\\DTOFiles" if p.pathToDal == "1" else p.pathToDal + "\\DTOs"
    p.createDirectoryIfNotExist(ap)
    for class_name in fD.keys():
        fin = generate_dto_by_class_name_fields_and_pk_fields(class_name, fD[class_name], pkD[class_name])
        open(f'{ap}\\{class_name + "DTO.java"}', "w").write(IndentJavaFile.indentJavaFile(fin))


if __name__ == '__main__':
    class_name = "User"
    dto_fields = [["String", "username"], ["String", "password"], ["String", "email"], ["String", "firstName"],
                  ["String", "lastName"], ["String", "phone"], ["String", "address"], ["String", "city"],
                  ["String", "state"], ["String", "zip"], ["String", "country"], ["String", "birthday"]]
    dto_pk_fields = [["String", "username"], ["String", "password"], ["String", "email"]]
    print(generate_dto_by_class_name_fields_and_pk_fields(class_name, dto_fields, dto_pk_fields))
