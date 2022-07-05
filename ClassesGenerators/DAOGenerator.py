import os

from FilesHandlers import IndentJavaFile
import Parser as p

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


def generate_dao_class_given_class_name_and_class_fields(class_name, class_fields):
    """
        Generates a DAO class given a class name and a list of fields.
        :param class_name: name of the class
        :param class_fields: class fields
        :return: DAO class
        """
    # packages and imports for the DAO class.
    packages = """package DataAccess.DAOs;
import DataAccess.DTOs.<class_name>DTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.<class_name>;
import java.util.List;""".replace("<class_name>", class_name)
    # class header. (extends DAO<PK, <class_name>DTO, <class_name>>) and class name.
    dao_class = "public class " + class_name + "DAO extends DAO<PK, " + class_name + "DTO, " + class_name + "> {\n"
    # constructor.
    dao_class += "\tpublic " + class_name + "DAO() {\n"
    # constructor body. (super(<class_name>DTO.class, IM.getInstance().getIdentityMap(<class_name>.class));)
    dao_class += "\t\tsuper(" + class_name + "DTO.class, IM.getInstance().getIdentityMap(" + class_name + ".class));\n"
    dao_class += "\t}\n"
    # convertDtoToBusiness method.
    dao_class += "\t@Override\n"
    # convertDtoToBusiness method body.
    dao_class += "\tprotected " + class_name + " convertDtoToBusiness(" + class_name + "DTO dto) {\n"
    dao_class += "\t\treturn new " + class_name + "("
    for field in class_fields:
        dao_class += "(" + identityFunctionIfNotInDict(field[0]) + ") dto.get" + p.a_capitalize(field[1]) + "(), "
    dao_class = dao_class[:-2] + ");\n"
    dao_class += "\t}\n"
    # convertBusinessToDto method.
    dao_class += "\t@Override\n"
    # convertBusinessToDto method body.
    dao_class += "\tprotected " + class_name + "DTO convertBusinessToDto(" + class_name + " business) {\n"
    dao_class += "\t\treturn new " + class_name + "DTO("
    for field in class_fields:
        dao_class += "business.get" + p.a_capitalize(field[1]) + "(), "
    dao_class = dao_class[:-2] + ");\n"
    dao_class += "\t}\n"
    # createDTO method. (override)
    dao_class += "\t@Override\n"
    # createDTO method body.
    dao_class += "\tprotected " + class_name + "DTO createDTO(List<Object> listFields) {\n"
    dao_class += "\t\treturn new " + class_name + "DTO("
    for field in class_fields:
        dao_class += "(" + field[0] + ") listFields.get(" + str(class_fields.index(field)) + "), "
    dao_class = dao_class[:-2] + ");\n"
    dao_class += "\t}\n"
    dao_class += "}\n"
    return packages + "\n\n" + dao_class


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


def create_dao_classes(fD):
    ap = os.getcwd() + "\\DAOFiles" if p.pathToDal == "1" else p.pathToDal + "\\DAOs"
    p.createDirectoryIfNotExist(ap)
    for class_name in fD.keys():
        fin = generate_dao_class_given_class_name_and_class_fields(class_name, fD[class_name])
        open(f'{ap}\\{class_name + "DAO.java"}', "w").write(IndentJavaFile.indentJavaFile(fin))


if __name__ == '__main__':
    s = """package DataAccess.DTOs;
import DataAccess.PrimaryKeys.PK;
import java.lang.reflect.Field;
public class AssignmentDTO extends DTO<PK>{
    private String date;
    private String shiftTime;
    private String branch;
    private String job;
    private long capacity;
    private long quantity;
    public AssignmentDTO(String date, String shiftTime, String branch, String job, long capacity, long quantity){
        super(new PK(getFields(), date, shiftTime, branch, job));
        this.date = date;
        this.shiftTime = shiftTime;
        this.branch = branch;
        this.job = job;
        this.capacity = capacity;
        this.quantity = quantity;
    }
    public static Field[] getFields(){ return getFields(new String[]{"date", "shiftTime", "branch", "job"}, AssignmentDTO.class);}
    
    public static PK getPK(String date, String shiftTime, String branch, String job){ return new PK(getFields(), date,  shiftTime,  branch,  job);}
    
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getShiftTime(){
        return shiftTime;
    }
    public void setShiftTime(String shiftTime){
        this.shiftTime = shiftTime;
    }
    public String getBranch(){
        return branch;
    }
    public void setBranch(String branch){
        this.branch = branch;
    }
    public String getJob(){
        return job;
    }
    public void setJob(String job){
        this.job = job;
    }
    public long getCapacity(){
        return capacity;
    }
    public void setCapacity(long capacity){
        this.capacity = capacity;
    }
    public long getQuantity(){
        return quantity;
    }
    public void setQuantity(long quantity){
        this.quantity = quantity;
    }
    public String toString(){
        return "Assignment{"
        "date = [" + date + "]" +
        "shiftTime = [" + shiftTime + "]" +
        "branch = [" + branch + "]" +
        "job = [" + job + "]" +
        "capacity = [" + capacity + "]" +
        "quantity = [" + quantity + "]" +
        "}";
    }
    @Override
    public Object[] getValues() {return new Object[]{date, shiftTime, branch, job, capacity, quantity};}
}


"""
    fields = get_class_fields(s.split("\n"), "AssignmentDTO")
    print(generate_dao_class_given_class_name_and_class_fields("Assignment", fields))
