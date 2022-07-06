# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
import glob
import os
import sqlite3

PathToDB = "default path"
clo = "{"
clc = "}"
pathToSrc = "default path"
DATA_ACCESS, LOGIC, PRESENTATION, SERVICE, DTOs, DAOs, SERVICE_OBJECTS = range(7)
path_to_src_components = ["default path", "default path", "default path", "default path", "default path",
                          "default path", "default path"]


def sql_identifier(s3):
    return '"' + s3.replace('"', '""') + '"'


def isNameFileInList(lst, name):
    for i in lst:
        if name in i:
            return True
    return False


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


def capitalize_first_letter(string):
    """
    this method is to capitalize the first letter of a string
    :param string: string, the string to capitalize the first letter
    :return: the string with the first letter capitalized
    """
    if len(string) > 0:
        return string[0].upper() + string[1:]
    return string


def de_capitalize_first_letter(string):
    """
    this method is to de-capitalize the first letter of a string
    :param string: string, the string to de-capitalize the first letter
    :return: the string with the first letter de-capitalized
    """
    if len(string) > 0:
        return string[0].lower() + string[1:]
    return string
