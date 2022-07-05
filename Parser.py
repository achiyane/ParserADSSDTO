# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
import glob
import os
import sqlite3

from FilesHandlers import IndentJavaFile, PathFinder
from ClassesGenerators import ServiceGenerator, BusinessGenerator, DTOGenerator, DAOGenerator, GenericGenerator

s = ""
backend_dal = "DataAccessLayer"
pathToDataAccess = f"C:\\Users\\achiy\\ADSS-Projects\\superlee\\dev\\src\\{backend_dal}\\DataAccess"
PathToDB = "C:\\Users\\achiy\\ADSS-Projects\\superlee\\dev\\src\\DataAccessLayer\\DataAccess\\DATA_BASE\\dbSuperLi.db"
clo = "{"
clc = "}"
pathToDal = "1"
pathToSrc = "0"


def path():
    return f"{pathDTOs()}\\{s}DTOS"


def pathDTOs():
    return f"{pathToDataAccess}\\DTOs"


def filesInDTO():
    lst = glob.glob(f"{path()}\\*")
    l = []
    for i in lst:
        if "java" in i:
            l.append(i)
    return l


def filesInOutDTO():
    lst = glob.glob(f"{path()}\\DTOC\\*")
    return lst


def parseName(name):
    return name.split("\\")[len(name.split("\\")) - 1]


def outPath(name):
    return f'{path()}\\DTOC\\{name}'


def deleteFilesInDTO():
    lst = filesInDTO()
    for i in lst:
        os.remove(i)


def deleteFilesInOutDTO():
    lst = filesInOutDTO()
    for i in lst:
        os.remove(i)


"""DTO Form
without PK and Obj.parser imports
extending DTO<...PrimaryKey>
super is with Primary Key
"""


def changedDTO1(ts, className):
    lst = ts.split("\n")
    fin = ""
    im1 = f"import {backend_dal}.DataAccess.DTOs.PrimaryKeys.PK;"
    im2 = "import Obj.Parser;"
    isIm = False
    for i in range(len(lst)):
        d = lst[i].replace(" ", "")
        if not isIm and "import" in lst[i]:
            fin += lst[i] + f"\n{im1}\n{im2}\n"
            isIm = True
        elif "extends" in lst[i]:
            a = lst[i]
            ind = a.index("extends")
            fin += a[0:int(ind + 8)] + "DTO<PK> {\n"
        elif "super(new" in d:
            a = lst[i]
            ind = a.index("PrimaryKey")
            str1 = a[int(ind + 10) + 1:int(len(a))]
            str3 = str1.split(")")[0]
            str4 = str3.split(",")
            str5 = 'new String[] {'
            for j in range(len(str4)):
                str5 += f'"{matchAccordingToThisRef(str4[j].strip(), ts)}"'
                if j != len(str4) - 1:
                    str5 += ", "
                else:
                    str5 += "}"
            str3 += ", Parser.getFields(" + str5 + ", " + className + ".class)));"
            ind = a.index("new")
            str2 = a[0:int(ind) + 4] + "PK("
            str2 += str3
            fin += str2 + "\n"
        else:
            fin += lst[i] + "\n"
    return changedDTO2(fin)


"""DTO Form
without Field import
super in shape Parser.getFields(newString[]...
create static methods getKey and getFields.
"""


def changedDTO2(ts):
    lst = ts.split("\n")
    fin = ""
    action = ""
    isAction = False
    isAdded = False
    dicts = {}
    im = "import java.lang.reflect.Field;"
    isIm = im in ts
    for i in range(len(lst)):
        d = lst[i].replace(" ", "")
        if not isIm and "import" in lst[i]:
            fin += lst[i] + f"\n{im}\n"
            isIm = True
        elif "private" in d:
            a = lst[i].strip()
            if " final " in a:
                type1 = a.split(" ")[2]
                name = a.split(" ")[3]
                name = name[0: len(name) - 1]
                name = f'"{matchAccordingToThisRef(name, ts)}"'
                dicts[name] = type1
                fin += lst[i] + "\n"
            else:
                type1 = a.split(" ")[1]
                name = a.split(" ")[2]
                name = f'"{name[0: len(name) - 1]}"'
                dicts[name] = type1
                fin += lst[i] + "\n"
        elif "Parser.getFields(newString[]" in d:
            ind = lst[i].index("Parser.getFields(new String[]")
            a = lst[i]
            str2 = a[int(ind):len(a)].split(")")[0]
            fin += a + "\n"
            isAction = True
            action = "    public static Field[] getFields(){ return " + str2 + ");}\n\n    public static PK getPK("
            str3 = str2.split('{')[1].split("}")[0].split(",")
            args = ""
            args2 = ""
            for j in range(len(str3)):
                t = dicts[str3[j].strip()]
                args2 += str3[j].split('"')[1] + ", "
                args += t + " " + str3[j].split('"')[1]
                if j != len(str3) - 1:
                    args += ", "
                else:
                    args += "){"
            action += args + f" return new PK({args2}getFields());" + "}"
        elif isAction and not isAdded and "}" in lst[i]:
            fin += lst[i] + "\n" + action + "\n"
            isAdded = True
        else:
            fin += lst[i] + "\n"
    return changedDTO3(fin)


"""DTO Form
without Field import
super in shape new PK(objects..., getFields)
switch super PK arguments order.
"""


def changedDTO3(ts):
    lst = ts.split("\n")
    fin = ""
    skip = False
    for i in range(len(lst)):
        if skip:
            if "}" in lst[i]:
                skip = False
            continue
        a = lst[i]
        d = lst[i].replace(" ", "")
        if "publicstaticPKgetPK" in d:
            if "}" not in d:
                skip = True
                a += lst[i + 1]
            if "}" not in a:
                a += lst[i + 2]
            str2 = a.split("{")[1].split("getFields")[0].split("(")[1]
            str2 = str2.split(",")
            args = a.split("{")[0] + "{ return new PK(getFields(), "
            for j in range(len(str2) - 1):
                args += str2[j]
                if j == len(str2) - 2:
                    args += ");}"
                else:
                    args += ", "
            fin += args + "\n"
        elif "super(" in d:
            str2 = a.split("PK")[1].split("Parser")[0].split("(")[1]
            str2 = str2.split(",")
            args = a.split("PK")[0] + "PK(getFields(), "
            for j in range(len(str2) - 1):
                args += str2[j].strip()
                if j == len(str2) - 2:
                    args += "));"
                else:
                    args += ", "
            fin += args + "\n"
        else:
            fin += a + "\n"
    return changedDTO4(fin.replace("Backend", backend_dal))


def matchAccordingToThisRef(ref, code):
    lst = code.split("\n")
    for i in range(len(lst)):
        a = lst[i]
        if "this." in a and ref in a:
            a = a.strip()
            return a.split(" ")[0].split("=")[0].split("this.")[1]
    return "no match"


def saveDTOFiles1():
    l = filesInDTO()
    for i in l:
        st = open(i).read()
        fin = changedDTO1(st, parseName(i).split(".java")[0])
        open(outPath(parseName(i)), "w").write(fin)


def saveDTOFiles2():
    l = filesInDTO()
    for i in l:
        st = open(i).read()
        fin = changedDTO2(st)
        open(outPath(parseName(i)), "w").write(fin)


def saveDTOFiles3():
    l = filesInDTO()
    for i in l:
        st = open(i).read()
        fin = changedDTO3(st)
        open(outPath(parseName(i)), "w").write(fin)


def saveDTOFilesBringTo2():
    l = filesInDTO()
    for i in l:
        st = open(i).read()
        fin = bringDTOTo2(st, parseName(i).split(".java")[0], getPKDict())
        open(outPath(parseName(i)), "w").write(fin)


def DAOPath():
    return f'{pathToDataAccess}\\DAOs\\{s}DAOs'


def filesInDAO():
    lst = glob.glob(f"{DAOPath()}\\*")
    l = []
    for i in lst:
        if "java" in i:
            l.append(i)
    return l


def outFilesDAO():
    return f'{pathToDataAccess}\\DAOs\\{s}DAOs\\DAOC'


"""DAO Form
extends DAO<...PrimaryKey,..,..> => DAO<PK,..,..>
super with ....IdentityMap"""


def changeDAO1(text, className):
    lst = text.split("\n")
    fin = ""
    im1 = f"import {backend_dal}.DataAccess.DTOs.PrimaryKeys.PK;"
    im2 = f"import {backend_dal}.DataAccess.IdentityMap.IM;"
    isIm1 = im1 in text
    isIm2 = im2 in text
    isIm = False
    threeT = []
    skip = False
    for i in range(len(lst)):
        if skip:
            skip = False
            continue
        if not isIm and "import" in lst[i]:
            fin += lst[i] + f"\n"
            if not isIm1:
                fin += f"{im1}\n"
            if not isIm2:
                fin += f"{im2}\n"
            isIm = True
        elif "extends" in lst[i]:
            a = lst[i]
            ind = a.index("extends")
            str2 = a[int(ind + 8): len(a)].split("<")[1].split(">")[0]
            str3 = ["PK", str2.split(",")[1], str2.split(",")[2]]
            threeT = str3
            fin += a[0: int(ind)] + f"extends DAO<{str3[0]},{str3[1]},{str3[2]}>" + "{\n"
        elif "super(" in lst[i].replace(" ", ""):
            a = lst[i]
            if ".getIdentityMap()" not in a:
                a += lst[i + 1]
                skip = True
            ind = a.index(",")
            ind1 = a.index(".getIdentityMap()")
            fin += a[0:int(
                ind) + 1] + f"IM.getInstance().getIdentityMap({threeT[0].strip()}.class, {threeT[2].strip()}.class)" + a[
                                                                                                                       int(ind1 + 17): len(
                                                                                                                           a)] + "\n"
        else:
            fin += lst[i] + "\n"
    return changeDAO2(fin, className)


"""DAO Form
without classNameDTO and DTOS.className imports
with new PK(objects..., getFields) => replace arguments order"""


def changeDAO2(code, className):
    lst = code.split("\n")
    fin = ""
    im = f"import {backend_dal}.DataAccess.DTOs.{s}DTOS.{className}DTO;\n"
    isIm = f"import {backend_dal}.DataAccess.DTOs.{s}DTOS.{className}" in code
    for i in range(len(lst)):
        a = lst[i]
        d = a.replace(" ", "")
        if not isIm and "import" in a:
            isIm = True
            fin += a + "\n" + im
        elif "newPK" in d:
            ind = a.index("new PK(")
            t = a
            ind1 = t.replace("()", "##").index(")")
            f = a[int(ind + 7):ind1].split(",")
            args = f"{f[len(f) - 1]}"
            for j in range(len(f) - 1):
                args += f", {f[j]}"
            fin += f'{a[0: int(ind + 7)]}{args}{a[int(ind1): len(a)]}\n'
        else:
            fin += a + "\n"
    return changeDAO3(fin)


"""DAO Form
with getIdentityMap(PK.class, name.class) => remove PK.class"""


def changeDAO3(code):
    lst = code.split("\n")
    fin = ""
    for i in range(len(lst)):
        a = lst[i]
        d = a.replace(" ", "")
        if "super" in d:
            c = "getIdentityMap("
            if c in d:
                changed = a.split(c)[1]
                idx = a.index(c) + len(c)
                n = changed.split(",")[1].strip()
                fin += f'{a[0:idx]}{n}\n'
        else:
            fin += f'{a}\n'
    return fin


def saveDAOFiles1():
    l = filesInDAO()
    for i in l:
        st = open(i).read()
        fin = changeDAO1(st, parseName(i).split("DAO.java")[0])
        open(f'{outFilesDAO()}\\{parseName(i)}', "w").write(fin)


def saveDAOFiles2():
    l = filesInDAO()
    for i in l:
        st = open(i).read()
        fin = changeDAO2(st, parseName(i).split("DAO.java")[0])
        open(f'{outFilesDAO()}\\{parseName(i)}', "w").write(fin)


def saveDAOFiles3():
    l = filesInDAO()
    for i in l:
        st = open(i).read()
        fin = changeDAO3(st)
        open(f'{outFilesDAO()}\\{parseName(i)}', "w").write(fin)


"""DTO Form.
only fields and get/set
add static methods. 
add getValue, imports.
add constructor and extend
"""


def bringDTOTo2(code, nameOfClass, pkDict):
    fin = ""
    dicts = {}
    fields = []
    lst1 = code.split("\n")
    im1 = f"import {backend_dal}.DataAccess.DTOs.PrimaryKeys.PK;"
    im2 = "import Backend.DataAccess.DTOs.DTO;"
    isIm = False
    found = False
    lst = []
    for i in lst1:
        if i.strip() != "":
            lst.append(i)
    for i in range(len(lst)):
        a = lst[i]
        d = lst[i].replace(" ", "")
        if not found and "public" in a and ("get" in a or "set" in a) and "(" in a and ")" in a:
            args = ""
            initialize = ""
            superArgs = ""
            parserArgs = ""
            for j in range(len(fields)):
                args += f"{dicts[fields[j]]} {fields[j]}"
                initialize += f"\t\tthis.{fields[j]} = {fields[j]};\n"
                if j != len(fields) - 1:
                    args += ", "
                else:
                    args += "){"
            tableName = nameOfClass.strip().split("DTO")[0]
            pklst = pkDict[tableName]
            if "" in pklst:
                pklst = [pklst]
            for j in range(len(pklst)):
                superArgs += f"{pklst[j]}, "
                parserArgs += f'"{pklst[j]}"'
                if j != len(pklst) - 1:
                    parserArgs += f", "
            fin += f"    public {nameOfClass}({args}\n\t\tsuper(new PK({superArgs}Parser.getFields(new String[]" + "{" + f"{parserArgs}" + "}, "
            fin += f"{nameOfClass}.class)));\n{initialize}" + "    }\n\n" + lst[i] + "\n"
            found = True
        elif "publicclass" in d and "extends" not in d:
            f = a.split("{")[0] + "extends DTO<PK>{\n"
            fin += f
        elif not isIm and "import" in a:
            isIm = True
            fin += f"{im1}\n{im2}\n"
            fin += a + "\n"
        elif "private" in d:
            a = lst[i].strip()
            if " final " in a:
                type1 = a.split(" ")[2]
                name = a.split(" ")[3]
                name = name[0: len(name) - 1]
                fields.append(name)
                dicts[name] = type1
                fin += lst[i] + "\n"
            else:
                type1 = a.split(" ")[1]
                name = a.split(" ")[2]
                name = name[0: len(name) - 1]
                fields.append(name)
                dicts[name] = type1
                fin += lst[i] + "\n"
        elif i == len(lst) - 1:
            args = ""
            for j in range(len(fields)):
                args += f"{fields[j]}"
                if j != len(fields) - 1:
                    args += ", "
            fin += "\t@Override\n\tpublic Object[] getValues() {return new Object[]{" + args + "};}\n"
            fin += a
        else:
            fin += a + "\n"
    return changedDTO2(fin)


def sql_identifier(s3):
    return '"' + s3.replace('"', '""') + '"'


def clear_DTO(code, className):
    lst1 = code.split("\n")
    skip = False
    lst = []
    fin = ""
    badImports = ["import java.lang.reflect.Field;", "import Obj.Parser;",
                  "import Backend.DataAccess.DTOs.DTO;",
                  f"import {backend_dal}.DataAccess.DTOs.PrimaryKeys.PK;"]
    for i in lst1:
        if i.strip() != "":
            lst.append(i)
    i = 0
    while i < len(lst):
        a = lst[i]
        d = lst[i].replace(" ", "")
        if skip:
            skip = "}" not in d
            i += 1
            continue
        if f"public{className}(" in d:
            skip = True
        elif ("@Override" in a and f"publicObject[]getValues()" in lst[i + 1].replace(" ",
                                                                                      "")) or f"publicObject[]getValues()" in d:
            if "@Override" in a:
                i += 1
            i += 2
            skip = "}" not in lst[i]
        elif "publicstatic" in d and ("getFields(" in d or "getPK(" in d):
            skip = "}" not in d
        elif a.strip() in badImports:
            i += 1
            continue
        else:
            fin += a + "\n"
        i += 1
    return fin


def changedDTO4(ts):
    im = "import Obj.Parser;"
    ts = ts.replace(im, "")
    return changedDTO5(ts.replace("Parser.getFields", "getFields"))


def getPathFromSrc():
    if "src" in pathToDal:
        return pathToDal.split("src\\")[1].replace("\\", ".")
    else:
        return "DataAccess"


def changedDTO5(ts):
    d = getPathFromSrc()
    dto = ["package DataAccess.DTOs;", "import DataAccess.PrimaryKeys.PK;", "import java.lang.reflect.Field;"]
    skip = False
    lst = ts.split("\n")
    fin = ""
    for i in range(len(lst)):
        a = lst[i]
        if "import" in a and not skip:
            skip = True
            for j in dto:
                fin += j.replace("DataAccess", d) + "\n"
        elif "import" not in a:
            fin += a + "\n"
    return fin


def isNameFileInList(lst, name):
    for i in lst:
        if name in i:
            return True
    return False


"""
def getPathForPackage(name):
    if pathToSrc == "0":
        return name
    packagePath = ""
    lst = glob.glob(f"{pathToSrc}\\*")
    if lst
    if isNameFileInList(lst, name):
        return name
    for i in lst:
        packagePath"""


def createBusinessFiles():
    ap = os.getcwd() + "\\BusinessFiles" if pathToSrc == "0" else pathToSrc + "\\Logic"
    fD = getFieldDict()
    createDirectoryIfNotExist(ap)
    for i in fD.keys():
        fin = createBusinessClass(i, fD)
        open(f'{ap}\\{i}.java', "w").write(IndentJavaFile.indentJavaFile(fin))


def createServiceFiles():
    ap = os.getcwd() + "\\ServiceFiles" if pathToSrc == "0" else pathToSrc + "\\Service\\Objects"
    fD = getFieldDict()
    createDirectoryIfNotExist(ap)
    for i in fD.keys():
        fin = createServiceClass(i, fD)
        open(f'{ap}\\S{i}.java', "w").write(IndentJavaFile.indentJavaFile(fin))


def createDTOFiles():
    ap = os.getcwd() + "\\DTOFiles" if pathToDal == "1" else pathToDal + "\\DTOs"
    fD = getFieldDict()
    pkD = getPKDict()
    createDirectoryIfNotExist(ap)
    for i in fD.keys():
        fin = createDTOClass(i, fD, pkD)
        open(f'{ap}\\{i + "DTO.java"}', "w").write(IndentJavaFile.indentJavaFile(fin))


def createDAOFiles():
    ap = os.getcwd() + "\\DAOFiles" if pathToDal == "1" else pathToDal + "\\DAOs"
    fD = getFieldDict()
    fkD = getFKDict()
    createDirectoryIfNotExist(ap)
    for i in fD.keys():
        fin = createDAOClass(i, fD, fkD)
        open(f'{ap}\\{i + "DAO.java"}', "w").write(IndentJavaFile.indentJavaFile(fin))


def createDAOClass(name, fDict: dict, fkDict):
    nameOfDAOClass = name + "DAO"
    nameOfDTOClass = name + "DTO"
    d = getPathFromSrc()
    import_lst = """package DataAccess.DAOs;
import DataAccess.DTOs.<CLASS NAME>DTO;
import DataAccess.IdentityMap.IM;
import DataAccess.PrimaryKeys.PK;
import Logic.<CLASS NAME>;
import java.util.List;""".split("\n")
    nD = fDict[name]
    fD = fkDict[name]
    whatToCast = {"long": "int"}
    castObjTo = {"long": "(long)(int)", "String": "(String)", "double": "(double)"}
    args1 = ""
    args2 = ""
    args3 = ""
    args4 = ""
    for i in import_lst:
        args4 += i.replace("DataAccess", d).replace("<CLASS NAME>", name) + "\n"
    for i in range(len(nD)):
        t = nD[i]
        if t[0] in whatToCast.keys():
            args1 += f"({whatToCast[t[0]]}) "
        args1 += f"dto.get{a_capitalize(t[1])}()"
        args2 += f"business.get{a_capitalize(t[1])}()"
        args3 += f"{castObjTo[t[0]]} listFields.get({i})"
        if i != len(nD) - 1:
            args1 += ", "
            args2 += ", "
            args3 += ", "
    args5, addedFields, addedMethods = DAOsFieldsBasedOnFK(fkDict, name, fDict)
    args6 = ""
    args7 = ""
    for i in addedFields.keys():
        args6 += f"        this.{addedFields[i]} = new {i}();\n"
        args7 += addedMethods[i]
    fin = f"""{args4}
    
public class {nameOfDAOClass} extends DAO<PK, {nameOfDTOClass}, {name}>{clo}

{args5}
    public {nameOfDAOClass}(){clo}
        super({nameOfDTOClass}.class, IM.getInstance().getIdentityMap({name}.class));
{args6}
    {clc}

    @Override
    protected {name} convertDtoToBusiness({nameOfDTOClass} dto) {clo}
        return new {name}({args1});
    {clc}

    @Override
    protected {nameOfDTOClass} convertBusinessToDto({name} business) {clo}
        return new {nameOfDTOClass}({args2});
    {clc}

    @Override
    protected {nameOfDTOClass} createDTO(List<Object> listFields) {clo} 
        return new {nameOfDTOClass}({args3});
    {clc}
    
{args7}

{clc}"""
    return fin


def a_de_capitalize(s: str):
    if len(s) == 0:
        return s
    a = s[0: 1]
    return a.lower() + s[1:len(s)]


def createServiceClass(name, fDict: dict):
    serviceName = f"S{name}"
    fin = f"""package Service.Objects;
public class {serviceName}{clo}
    
"""
    bObj = "businessObject"
    nD = fDict[name]
    con = buildConstructor(serviceName, fDict, dictName=name)
    for i in nD:
        fin += f'    private {i[0]} {i[1]};\n\n'
    fin += con
    fin += f"\n     public {serviceName}({name} {bObj}){clo}\n           this("
    args1 = ""
    for i in nD:
        args1 += f"{bObj}.get{a_capitalize(i[1])}(), "
    if len(args1) != 0:
        args1 = args1[0:len(args1) - 2]
    fin += f"{args1});\n     {clc}\n\n"
    for i in nD:
        fin += f'{createGetSetForField(i[1], i[0])}\n'
    fin += f"{createToStringForClass(name, fDict)}\n"
    return fin + clc


def buildConstructor(name, fDict: dict, addedFields=None, dictName=""):
    if addedFields is None:
        addedFields = {}
    if dictName == "":
        dictName = name
    nD = fDict[dictName]
    fin = ""
    args1 = ""
    args2 = ""
    for i in nD:
        args1 += f"{i[0]} {i[1]}, "
        args2 += f"         this.{i[1]} = {i[1]};\n"
    for i in addedFields.keys():
        if i in ['String', 'long', 'int', 'double']:
            args1 += f"{i} {addedFields[i]}, "
            args2 += f"         this.{addedFields[i]} = {addedFields[i]};\n"
        else:
            args2 += f"         this.{addedFields[i]} = new {i}();\n"
    if len(args1) != 0:
        args1 = args1[0:len(args1) - 2]
    fin += f"""    public {name}({args1}){clo}
{args2}
    {clc}\n\n"""
    return fin


def DAOsFieldsBasedOnFK(fkDict: dict, name, fDict: dict):
    nD = fkDict[name]
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
    return [args1, addedFields, addedMethods]


def createBusinessClass(name, fDict: dict):
    d = getPathFromSrc()
    daoName = f"{a_de_capitalize(name)}DAO"
    fin = f"""package Logic;
import {d}.DAOs.{name}DAO;
import {d}.DTOs.{name}DTO;
public class {name}{clo}
    private {name}DAO {daoName};
          
"""
    nD = fDict[name]
    addedF = {f"{name}DAO": daoName}
    con = buildConstructor(name, fDict, addedFields=addedF)
    for i in nD:
        fin += f'    private {i[0]} {i[1]};\n\n'
    fin += con
    for i in nD:
        fin += f'{createGetSetForFieldInBusiness(daoName, i[1], i[0])}\n'
    fin += f'{createToStringForClass(name, fDict)}\n'
    return fin + clc


def createDTOClass(name, fDict: dict, pkDict):
    fin = f"""import java.lang.reflect.Field;

            import Backend.DataAccess.DTOs.DTO;

public class {name}DTO extends DTO<PK>{clo}

"""
    nD = fDict[name]
    for i in nD:
        fin += f'    private {i[0]} {i[1]};\n\n'
    for i in nD:
        fin += f'{createGetSetForField(i[1], i[0])}\n'
    fin += f'{createToStringForClass(name, fDict)}\n'
    return bringDTOTo2(fin + clc, name + "DTO", pkDict)


def a_capitalize(s: str):
    if len(s) == 0:
        return s
    a = s[0: 1]
    return a.capitalize() + s[1:len(s)]


def createToStringForClass(name, fDict: dict):
    nD = fDict[name]
    fin = f'"{name}{clo}"\n'
    for i, j in nD:
        fin += f'               "{j} = [" + {j} + "]" +\n'
    fin += f'               "{clc}"'
    return f"""    public String toString(){clo}
        return {fin};
    {clc}"""


def createGetSetForField(f: str, t: str):
    return f"""
    public {t} get{a_capitalize(f)}(){clo}
        return {f};
    {clc}

    public void set{a_capitalize(f)}({t} {f}){clo}
        this.{f} = {f};
    {clc}\n"""


def createGetSetForFieldInBusiness(DAOVarName: str, f: str, t: str):
    return f"""
    public {t} get{a_capitalize(f)}(){clo}
        return {f};
    {clc}

    public void set{a_capitalize(f)}({t} {f}){clo}
        this.{f} = {f};
        {DAOVarName}.update(this);
    {clc}\n"""


def getFieldInTableType(field, fDict: dict, tbl):
    nD = fDict[tbl]
    for i in nD:
        if i[1] == field:
            return i[0]
    return f"no field for {field} in table {tbl}"


def getFKDict():
    """[table name, tableField, fkTableField]"""
    """FOREIGN KEY("item_ID") REFERENCES "Items"("ID")"""
    sqliteConnection = sqlite3.connect(PathToDB)
    db = sqliteConnection.cursor()
    rows = db.execute("SELECT name, sql FROM sqlite_master WHERE type = 'table' AND sql NOT NULL").fetchall()
    fKDict = {}
    fLst = ["INTEGER", "REAL", "TEXT"]
    tDict = {"INTEGER": "long", "REAL": "double", "TEXT": "String"}
    for table in rows:
        if "sqlite" in table[0]:
            continue
        sql = table[1]
        name = table[0]
        fKDict[name] = []
    for table in rows:
        if "sqlite" in table[0]:
            continue
        sql = table[1]
        name = table[0]
        lst = sql.split("\n")
        l = []
        for i in lst:
            i = i.replace(" (", "(")
            a = str(i).upper()
            if "FOREIGN KEY" in a:
                fieldName = i.split("FOREIGN KEY(")[1].split(")")[0].strip()
                if '"' in fieldName:
                    fieldName = fieldName.replace('"', "")
                fkTbl = i.split("REFERENCES ")[1].split("(")[0].strip()
                if '"' in fkTbl:
                    fkTbl = fkTbl.replace('"', "")
                fkName = i.split("REFERENCES ")[1].split("(")[1].split(")")[0].strip()
                fKDict[fkTbl].append([name, fieldName, fkName])
    db.close()
    sqliteConnection.close()
    return fKDict


def getFieldDict():
    sqliteConnection = sqlite3.connect(PathToDB)
    db = sqliteConnection.cursor()
    rows = db.execute("SELECT name, sql FROM sqlite_master WHERE type = 'table' AND sql NOT NULL").fetchall()
    fDict = {}
    fLst = ["INTEGER", "REAL", "TEXT"]
    tDict = {"INTEGER": "long", "REAL": "double", "TEXT": "String"}
    for table in rows:
        if "sqlite" in table[0]:
            continue
        sql = table[1]
        name = table[0]
        lst = sql.split("\n")
        l = []
        for i in lst:
            i = i.replace(" (", "(")
            a = str(i).upper()
            for j in fLst:
                if j in a and "foreign key" not in a.lower():
                    ty = tDict[j]
                    fName = ""
                    if '"' in i:
                        fName = str(i.strip()).split('"')[1].strip()
                    else:
                        fName = str(i.strip()).split(" ")[0].split("\t")[0].strip()
                    l.append([ty, fName])
        fDict[name] = l
    db.close()
    sqliteConnection.close()
    return fDict


def getPKDict():
    sqliteConnection = sqlite3.connect(PathToDB)
    db = sqliteConnection.cursor()
    rows = db.execute("SELECT name, sql FROM sqlite_master WHERE type = 'table' AND sql NOT NULL").fetchall()
    # tables = [row[0] for row in rows]
    pkdict = {}
    fLst = ["INTEGER", "REAL", "TEXT"]
    for table in rows:
        if "sqlite" in table[0]:
            continue
        sql = table[1]
        name = table[0]
        lst = sql.split("\n")
        for i in lst:
            i = i.replace(" (", "(")
            flag = False
            for ee in fLst:
                if ee in i:
                    flag = True
            if "PRIMARY KEY(" in i:
                a = i.split("PRIMARY KEY(")[1].split("AUTO")[0].split(")")[0].split(",")
                l = []
                for j in a:
                    l.append(j.replace('"', "").strip())
                pkdict[name] = l
            elif "primary key" in i and flag:
                pkdict[name] = [i.strip().split(" ")[0]]
            elif "primarykey(" in i.lower().replace(" ", ""):
                a = i.split("primary key")[1].split("(")[1].split("AUTO")[0].split(")")[0].split(",")
                l = []
                for j in a:
                    l.append(j.replace('"', "").strip())
                pkdict[name] = l
    db.close()
    sqliteConnection.close()
    return pkdict


"""this method is used to get the primary key of all tables in the database in path PathToDB
    returns a dictionary with table name as key and all primary keys as values in a list like this
     [[<type1>, <field1>], [<type2>, <field2>], ..., [<typeN>, <fieldN>]]
     we are given the DDL of the table in the database
     template for the DDL:
     CREATE TABLE "<table_name>" 
     (
	    "<field_name1>" "<type1>" ,
	    "<field_name2>" "<type2>" ,
	    ...
	    "<field_nameN>" "<typeN>"
	    PRIMARY KEY("<pk_table_field_1>","<pk_table_field_2>",..., "<pk_table_field_N>"),
	    FOREIGN KEY("<fk_table_field_1>") REFERENCES "<fk_table_name_1"("<fk_field_name_1>"),
	    FOREIGN KEY("<fk_table_field_2>") REFERENCES "<fk_table_name_2>"("<fk_field_name_2>"),
	    ...
	    FOREIGN KEY("<fk_table_field_N>") REFERENCES "<fk_table_name_N>"("<fk_field_name_N>")
    )
    <typeI> for i between 1 and N is one of the following:
    INTEGER, REAL, TEXT
    <fieldI> for i between 1 and N is the name of the field in the table
    <pk_table_field_I> for i between 1 and N is the name of the field in the table that is the primary key
    <fk_table_field_I> for i between 1 and N is the name of the field in the table that is the foreign key 
    <fk_table_name_I> for i between 1 and N is the name of the table that is the foreign key
    <fk_field_name_I> for i between 1 and N is the name of the field in the table that is the foreign key 
"""


def getPKDictForTable(DDL):
    lst = DDL.split("\n")
    l = []
    for i in lst:
        i = i.replace(" (", "(")
        # primary key is in the form of "PRIMARY KEY(<pk_table_field_1>,<pk_table_field_2>,...,<pk_table_field_N>)"
        # foreign key is in the form of "FOREIGN KEY(<fk_table_field_1>) REFERENCES <fk_table_name_1>(<fk_field_name_1>)"
        if "PRIMARY KEY(" in i:
            a = i.split("PRIMARY KEY(")[1].split("AUTO")[0].split(")")[0].split(",")
            for j in a:
                l.append(j.replace('"', "").strip())
        elif "primary key(" in i:
            a = i.split("primary key(")[1].split("AUTO")[0].split(")")[0].split(",")
            for j in a:
                l.append(j.replace('"', "").strip())
    return l


def getPKDictForAllTables():
    sqliteConnection = sqlite3.connect(PathToDB)
    db = sqliteConnection.cursor()
    rows = db.execute("SELECT name, sql FROM sqlite_master WHERE type = 'table' AND sql NOT NULL").fetchall()
    pkDict = {}
    fLst = ["INTEGER", "REAL", "TEXT"]
    for table in rows:
        if "sqlite" in table[0]:
            continue
        sql = table[1]
        name = table[0]
        pkDict[name] = getPKDictForTable(sql)
    db.close()
    sqliteConnection.close()
    return pkDict


def createDirectoryIfNotExist(path):
    # Check whether the specified path exists or not
    isExist = os.path.exists(path)
    if not isExist:
        # Create a new directory because it does not exist
        os.makedirs(path)


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    tester = input("Test or Not? [y/n]\n")
    test = tester != "n"
    pathsFiles = os.getcwd() + "\\PathFiles"
    src_path_text = pathsFiles + "\\srcPath.txt"
    db_path_text = pathsFiles + "\\dbPath.txt"
    dal_path_text = pathsFiles + "\\dalPath.txt"
    path_to_data_access = pathsFiles + "\\pathToDataAccess.txt"
    createDirectoryIfNotExist(pathsFiles)
    if tester == "y":
        PathToDB = "1"
        if PathToDB != "1":
            open(db_path_text, "w").write(PathToDB)
        else:
            PathToDB = open(db_path_text).read().strip()
        pathToSrc = "0"
        if pathToSrc == "0":
            pathToSrc = "0"
        elif pathToSrc == "1":
            pathToSrc = open(src_path_text).read().strip()
        else:
            open(src_path_text, "w").write(pathToSrc)
        pathToDal = "2"
        if pathToDal == "1":
            pathToDal = open(dal_path_text).read().strip()
        elif pathToDal == "2":
            pathToDal = "1"
        else:
            open(dal_path_text, "w").write(pathToDal)
        backend_dal = "Backend"
        s = "none"
        print(getPKDictForAllTables())
        op = input("Press Enter to continue..., press c to exit")
        if op == "c":
            exit()
        fD = getFieldDict()
        pkD = getPKDict()
        pkDTypes = {}
        for i in pkD:
            pkDTypes[i] = []
            for j in pkD[i]:
                pkDTypes[i].append([getFieldInTableType(j, fD, i), j])
        paths = PathFinder.findPath(["DataAccess", "Logic", "PresentationLayer", "ServiceLayer"],
                                    pathToSrc)
        ServiceGenerator.create_service_classes(fD)
        BusinessGenerator.create_business_classes(fD)
        DAOGenerator.create_dao_classes(fD)
        DTOGenerator.create_dto_classes(fD, pkDTypes)
    elif test:
        PathToDB = "1"
        if PathToDB != "1":
            open(db_path_text, "w").write(PathToDB)
        else:
            PathToDB = open(db_path_text).read().strip()
        pathToSrc = "0"
        if pathToSrc == "0":
            pathToSrc = "0"
        elif pathToSrc == "1":
            pathToSrc = open(src_path_text).read().strip()
        else:
            open(src_path_text, "w").write(pathToSrc)
        pathToDal = "2"
        if pathToDal == "1":
            pathToDal = open(dal_path_text).read().strip()
        elif pathToDal == "2":
            pathToDal = "1"
        else:
            open(dal_path_text, "w").write(pathToDal)
        backend_dal = "Backend"
        s = "none"
        createDAOFiles()
        createBusinessFiles()
        createServiceFiles()
        createDTOFiles()
    else:
        print("insert 1 if you want to use old path")
        PathToDB = input("insert db path\n")
        if PathToDB != "1":
            open(db_path_text, "w").write(PathToDB)
        else:
            PathToDB = open(db_path_text).read().strip()
        print("insert 0 if you want to use default path")
        pathToSrc = input("insert src path\n")
        if pathToSrc == "0":
            pathToSrc = "0"
        elif pathToSrc == "1":
            pathToSrc = open(src_path_text).read().strip()
        else:
            open(src_path_text, "w").write(pathToSrc)
        print("insert 1 if you want to use old path, 2 if you want to use the default path.(to this directory):")
        pathToDal = input("insert path to data access layer file\n")
        if pathToDal == "1":
            pathToDal = open(dal_path_text).read().strip()
        elif pathToDal == "2":
            pathToDal = "1"
        else:
            open(dal_path_text, "w").write(pathToDal)
        backend_dal = "Backend"
        s = "none"
        createDAOFiles()
        createBusinessFiles()
        createServiceFiles()
        createDTOFiles()

# See PyCharm help at https:\\\\www.jetbrains.com\\help\\pycharm
