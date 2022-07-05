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


"""template of a DAO class


package DataAccess.DAOs;
import DataAccess.DTOs.<class_name>DTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.<class_name>;
import java.util.List;

public class <class_name>DAO extends DAO<PK, <class_name>DTO, <class_name>> {

    assume this class has the following fields:
    private <field_type1> <field_name1>;
    private <field_type2> <field_name2>;
    private <field_type3> <field_name3>;
    ...
    private <field_typeN> <field_nameN>;
    
    public <class_name>DAO() {
        super(<class_name>DTO.class, IM.getInstance().getIdentityMap(<class_name>.class));
    }
    
    @Override
    protected <class_name> convertDtoToBusiness(<class_name>DTO dto) {
        return new <class_name>((<field_type1>) dto.get<field_name1>(), (<field_type2>) dto.get<field_name2>(), (<field_type3>) dto.get<field_name3>(), ..., (<field_typeN>) dto.get<field_nameN>());
    }
    
    @Override
    protected <class_name>DTO convertBusinessToDto(<class_name> business) {
        return new <class_name>DTO(business.get<field_name1>(), business.get<field_name2>(), business.get<field_name3>(), ..., business.get<field_nameN>());
    }
    
    @Override
    protected <class_name>DTO createDTO(List<Object> listFields) {
        return new <class_name>DTO((<field_type1>) listFields.get(0), (<field_type2>) listFields.get(1), (<field_type3>) listFields.get(2), ..., (<field_typeN>) listFields.get(N));
    }

}"""


def generate_dao_class_given_class_name_and_class_fields(class_name, class_fields, fk_class_fields=""):
    """
        Generates a DAO class given a class name and a list of fields.
        :param class_name: name of the class
        :param class_fields: class fields
        :param fk_class_fields: foreign key fields
        :return: DAO class
        """
    # packages and imports for the DAO class.
    packages = define_dao_imports(class_name, class_fields)
    # class header. (extends DAO<PK, <class_name>DTO, <class_name>>) and class name.
    dao_class = "public class " + class_name + "DAO extends DAO<PK, " + class_name + "DTO, " + class_name + "> {\n"
    # class fields.
    dao_class += gg.define_class_fields(class_name, class_fields)
    # class constructor.
    dao_class += define_dao_constructor(class_name, class_fields)
    # convertDtoToBusiness method. (override)
    dao_class += define_dao_convert_dto_to_business(class_name, class_fields)
    # convertBusinessToDto method. (override)
    dao_class += define_dao_convert_business_to_dto(class_name, class_fields)
    # createDTO method. (override)
    dao_class += define_dao_create_dto(class_name, class_fields)
    # special methods. for dao classes. for all fields[type, name]
    # public List<name> getAll<name>s(<fk_field_type1> <fk_field_name1>, ..., <fk_field_typeN> <fk_field_nameN>){
    #     return {daoName}.selectAllUnderConditionToBusiness("{tblField} = " + {fkField.replace('"', "")});
    # }
    dao_class += define_dao_special_methods(class_name, class_fields, fk_class_fields)
    # class footer.
    dao_class += "}\n"
    return packages + "\n\n" + dao_class


def define_dao_special_methods(class_name, class_fields, fk_class_fields):
    """
        Generates a DAO special methods given a class name and a list of fields.
        :param class_name: name of the class
        :param class_fields: class fields
        :param fk_class_fields: foreign key fields
        :return: DAO special methods
        """
    # fields in fk_class_fields are like this, [fieldType ,tblName, tblField, fkField]
    # special methods. for dao classes. for all fields[type, name]
    # public List<name> getAll<name>s(<fk_field_type1> <fk_field_name1>, ..., <fk_field_typeN> <fk_field_nameN>){
    #     return {daoName}.selectAllUnderConditionToBusiness("{tblField} = " + {fkField.replace('"', "")});
    # }
    special_methods = ""
    for field in fk_class_fields:
        special_methods += "public List<" + field + "> getAll" + field + "s("
        for field_type, fk_field, tbl_name, tbl_field in fk_class_fields[field]:
            special_methods += identityFunctionIfNotInDict(field_type) + " " + fk_field + ", "
        special_methods = special_methods[:-2] + "){\n"
        special_methods += "    return " + tbl_name + "DAO.selectAllUnderConditionToBusiness("
        for field_type, fk_field, tbl_name, tbl_field in fk_class_fields[field]:
            if field_type == "String":
                special_methods += '"' + tbl_field + ' = "' + " + '" + fk_field + "' + " + '" AND " + '
            else:
                special_methods += '"' + tbl_field + ' = "' + " + " + fk_field + " + " + '" AND " + '
        special_methods = special_methods[:-13] + ");\n\n"
        special_methods += "}\n"
    return special_methods


def define_dao_imports(class_name, class_fields):
    """
        Generates a DAO imports given a class name and a list of fields.
        :param class_name: name of the class
        :param class_fields: class fields
        :return: DAO imports
        """
    # imports.
    imports = "import DataAccess.DTOs." + class_name + "DTO;\n"
    imports += "import DataAccess.IdentityMap.IM;\n"
    imports += "import DataAccess.PrimaryKeys.PK;\n"
    imports += "import Logic." + class_name + ";\n"
    imports += "import java.util.List;\n"
    for field in class_fields:
        imports += "import DataAccess.DAOs." + field[0] + ";\n"
    return imports


def define_dao_create_dto(class_name, class_fields):
    """
        Generates a DAO createDTO method given a class name and a list of fields.
        :param class_name: name of the class
        :param class_fields: class fields
        :return: DAO createDTO method
        """
    # createDTO method. (override)
    create_dto = "\t@Override\n"
    # createDTO method body.
    create_dto += "\tprotected " + class_name + "DTO createDTO(List<Object> listFields) {\n"
    create_dto += "\t\treturn new " + class_name + "DTO("
    for field in class_fields:
        create_dto += "(" + field[0] + ") listFields.get(" + str(class_fields.index(field)) + "), "
    create_dto = create_dto[:-2] + ");\n"
    create_dto += "\t}\n"
    return create_dto


def define_dao_convert_business_to_dto(class_name, class_fields):
    """
        Generates a DAO convertBusinessToDto method given a class name and a list of fields.
        :param class_name: name of the class
        :param class_fields: class fields
        :return: DAO convertBusinessToDto method
        """
    # convertBusinessToDto method.
    convert_business_to_dto = "\t@Override\n"
    # convertBusinessToDto method body.
    convert_business_to_dto += "\tprotected " + class_name + "DTO convertBusinessToDto(" + class_name + " business) {\n"
    convert_business_to_dto += "\t\treturn new " + class_name + "DTO("
    for field in class_fields:
        convert_business_to_dto += "business.get" + p.a_capitalize(field[1]) + "(), "
    convert_business_to_dto = convert_business_to_dto[:-2] + ");\n"
    convert_business_to_dto += "\t}\n"
    return convert_business_to_dto


def define_dao_convert_dto_to_business(class_name, class_fields):
    """
        Defines the convertDtoToBusiness method.
    :param class_name: string, name of the class
    :param class_fields: List of tuples, class fields
    :return: the convertDtoToBusiness method
    """
    dao_convert_dto_to_business = "\t@Override\n"
    dao_convert_dto_to_business += "\tprotected " + class_name + " convertDtoToBusiness(" + class_name + "DTO dto) {\n"
    dao_convert_dto_to_business += "\t\treturn new " + class_name + "("
    for field in class_fields:
        dao_convert_dto_to_business += "(" + identityFunctionIfNotInDict(field[0]) + ") dto.get" + p.a_capitalize(
            field[1]) + "(), "
    dao_convert_dto_to_business = dao_convert_dto_to_business[:-2] + ");\n"
    dao_convert_dto_to_business += "\t}\n"
    return dao_convert_dto_to_business


"""this method generates a DAO constructor given a class name and a list of fields."""


def define_dao_constructor(class_name, class_fields):
    """
        Generates a DAO constructor given a class name and a list of fields.
        :param class_name: name of the class
        :param class_fields: class fields
        :return: DAO constructor
        """
    # constructor.
    add_to_constructor = "\t\tsuper(" + class_name + "DTO.class, IM.getInstance().getIdentityMap(" + class_name + ".class));\n"
    return gg.define_class_constructor(class_name + "DAO", class_fields,
                                       added_super_constructor_code=add_to_constructor)


"""fields in the class looks like this, private <final>(optional) <type> <name>; the last one is the field name
we want to get the name of the field, and his type, return it in [type, name], name should be without ;
check to see if the line end in (){, if so, it's a constructor or a method, so we don't want it"""


def get_class_fields(class_code, class_name):
    fields = []
    # Get the fields of the class.
    for line in class_code:
        if line.endswith(";") and line.strip().startswith("private"):
            field_name = line.split(";")[0]
            field_name = field_name.split(" ")[-1]
            field_type = line.split(" ")[-2]
            fields.append([field_type, field_name])
    return fields


def generate_new_fk_dict(fD, fkD):
    new_fk_dict = {}
    new_f_dict = {}
    for key in fkD:
        new_f_dict[key] = []
        new_fk_dict[key] = {}
        for tbl_name, tbl_field, fk_field in fkD[key]:
            if tbl_name not in new_fk_dict[key].keys():
                new_fk_dict[key][tbl_name] = []
            new_fk_dict[key][tbl_name].append(
                [p.getFieldInTableType(tbl_field, fD, tbl_name), fk_field.replace('"', ''), tbl_name, tbl_field])
            tbl_name_dao, tbl_name_dao_capitalized = tbl_name + "DAO", p.a_capitalize(tbl_name) + "DAO"
            if [tbl_name_dao, tbl_name_dao_capitalized] not in new_f_dict[key]:
                new_f_dict[key].append([tbl_name_dao, tbl_name_dao_capitalized])
    return new_f_dict, new_fk_dict


"""nD = fkDict[name]
    args1 = ""
    addedFields = {}
    addedMethods = {}
    for tblName, tblField, fkField in nD:
        daoName = f"{a_de_capitalize(tblName)}DAO"
        args1 += f'    private {tblName}DAO {daoName};\n\n'
        addedFields[f'{tblName}DAO'] = daoName
        addedMethods[
            f'{tblName}DAO'] = f'''    public List<{tblName}> getMatching{tblName}({getFieldInTableType(tblField, fDict, tblName)} {fkField.replace('"', "")}){clo}
        return {daoName}.selectAllUnderConditionToBusiness("{tblField} = " + {fkField.replace('"', "")});
    {clc}\n\n'''
    return [args1, addedFields, addedMethods]"""


def create_dao_classes(fD, fkD=""):
    """
        Generates the DAO classes.
    :param fD: dictionary of fields, key is the class name, value is a list of fields
    :param fkD: dictionary of foreign keys, key is the class name, value is a list of foreign keys
    :return: save the generated classes to a file
    """
    # fields in fkDict are like this, [fieldType ,tblName, tblField, fkField]
    new_f_dict, new_fk_dict = generate_new_fk_dict(fD, fkD)
    ap = os.getcwd() + "\\DAOFiles" if p.pathToDal == "1" else p.pathToDal + "\\DAOs"
    p.createDirectoryIfNotExist(ap)
    for class_name in fD.keys():
        fin = generate_dao_class_given_class_name_and_class_fields(class_name, new_f_dict[class_name],
                                                                   new_fk_dict[class_name])
        open(f'{ap}\\{class_name + "DAO.java"}', "w").write(IndentJavaFile.indentJavaFile(fin))
