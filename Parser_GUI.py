import os
from tkinter import *
from tkinter import filedialog

import Parser as p
from ClassesGenerators import ServiceGenerator, BusinessGenerator, DAOGenerator, DTOGenerator, GenericGenerator
from FilesHandlers import PathFinder

"""this is the main window of the program
    it contains the main menu and the main frame
    the main frame contains the other frames
    the main menu contains the buttons
    the other frames contain the other widgets
    the other widgets are the buttons, labels, text fields, etc."""


def generate_classes_by_path(root, what_to_generate="All"):
    pathsFiles = os.getcwd() + "\\PathFiles"
    src_path_text = pathsFiles + "\\srcPath.txt"
    db_path_text = pathsFiles + "\\dbPath.txt"
    dal_path_text = pathsFiles + "\\dalPath.txt"
    path_to_data_access = pathsFiles + "\\pathToDataAccess.txt"
    p.createDirectoryIfNotExist(pathsFiles)
    p.PathToDB = open(db_path_text).read().strip()
    p.pathToDal = open(dal_path_text).read().strip()
    p.pathToSrc = open(src_path_text).read().strip()
    fD = p.getFieldDict()
    pkD = p.getPKDict()
    fkD = p.getFKDict()
    pkDTypes = {}
    for i in pkD:
        pkDTypes[i] = []
        for j in pkD[i]:
            pkDTypes[i].append([p.getFieldInTableType(j, fD, i), j])
    paths = PathFinder.findPath(["DataAccess", "Logic", "PresentationLayer", "ServiceLayer"],
                                p.pathToSrc)
    if what_to_generate == "Service":
        ServiceGenerator.create_service_classes(fD)
    elif what_to_generate == "Business":
        BusinessGenerator.create_business_classes(fD)
    elif what_to_generate == "DAO":
        DAOGenerator.create_dao_classes(fD, fkD)
    elif what_to_generate == "DTO":
        DTOGenerator.create_dto_classes(fD, pkDTypes)
    elif what_to_generate == "All":
        ServiceGenerator.create_service_classes(fD)
        BusinessGenerator.create_business_classes(fD)
        DAOGenerator.create_dao_classes(fD, fkD)
        DTOGenerator.create_dto_classes(fD, pkDTypes)


def generate_classes(root, what_to_generate="All"):
    # tester = input("Test or Not? [y/n]\n")
    print("Generating classes...")
    tester = "y"
    test = tester != "n"
    pathsFiles = os.getcwd() + "\\PathFiles"
    src_path_text = pathsFiles + "\\srcPath.txt"
    db_path_text = pathsFiles + "\\dbPath.txt"
    dal_path_text = pathsFiles + "\\dalPath.txt"
    path_to_data_access = pathsFiles + "\\pathToDataAccess.txt"
    p.createDirectoryIfNotExist(pathsFiles)
    if tester == "y":
        p.PathToDB = "1"
        if p.PathToDB != "1":
            open(db_path_text, "w").write(p.PathToDB)
        else:
            p.PathToDB = open(db_path_text).read().strip()
        p.pathToSrc = "0"
        if p.pathToSrc == "0":
            p.pathToSrc = "0"
        elif p.pathToSrc == "1":
            p.pathToSrc = open(src_path_text).read().strip()
        else:
            open(src_path_text, "w").write(p.pathToSrc)
        p.pathToDal = "2"
        if p.pathToDal == "1":
            p.pathToDal = open(dal_path_text).read().strip()
        elif p.pathToDal == "2":
            p.pathToDal = "1"
        else:
            open(dal_path_text, "w").write(p.pathToDal)
        backend_dal = "Backend"
        s = "none"
        """print(p.getPKDictForAllTables())
        op = input("Press Enter to continue..., press c to exit")
        if op == "c":
            exit()"""
        fD = p.getFieldDict()
        pkD = p.getPKDict()
        fkD = p.getFKDict()
        pkDTypes = {}
        for i in pkD:
            pkDTypes[i] = []
            for j in pkD[i]:
                pkDTypes[i].append([p.getFieldInTableType(j, fD, i), j])
        paths = PathFinder.findPath(["DataAccess", "Logic", "PresentationLayer", "ServiceLayer"],
                                    p.pathToSrc)
        if what_to_generate == "Service":
            ServiceGenerator.create_service_classes(fD)
        elif what_to_generate == "Business":
            BusinessGenerator.create_business_classes(fD)
        elif what_to_generate == "DAO":
            DAOGenerator.create_dao_classes(fD, fkD)
        elif what_to_generate == "DTO":
            DTOGenerator.create_dto_classes(fD, pkDTypes)
        elif what_to_generate == "All":
            ServiceGenerator.create_service_classes(fD)
            BusinessGenerator.create_business_classes(fD)
            DAOGenerator.create_dao_classes(fD, fkD)
            DTOGenerator.create_dto_classes(fD, pkDTypes)
    elif test:
        p.PathToDB = "1"
        if p.PathToDB != "1":
            open(db_path_text, "w").write(p.PathToDB)
        else:
            p.PathToDB = open(db_path_text).read().strip()
        p.pathToSrc = "0"
        if p.pathToSrc == "0":
            p.pathToSrc = "0"
        elif p.pathToSrc == "1":
            p.pathToSrc = open(src_path_text).read().strip()
        else:
            open(src_path_text, "w").write(p.pathToSrc)
        p.pathToDal = "2"
        if p.pathToDal == "1":
            p.pathToDal = open(dal_path_text).read().strip()
        elif p.pathToDal == "2":
            p.pathToDal = "1"
        else:
            open(dal_path_text, "w").write(p.pathToDal)
        backend_dal = "Backend"
        s = "none"
        # createDAOFiles()
        # createBusinessFiles()
        # createServiceFiles()
        # createDTOFiles()
    else:
        print("insert 1 if you want to use old path")
        p.PathToDB = input("insert db path\n")
        if p.PathToDB != "1":
            open(db_path_text, "w").write(p.PathToDB)
        else:
            p.PathToDB = open(db_path_text).read().strip()
        print("insert 0 if you want to use default path")
        p.pathToSrc = input("insert src path\n")
        if p.pathToSrc == "0":
            p.pathToSrc = "0"
        elif p.pathToSrc == "1":
            p.pathToSrc = open(src_path_text).read().strip()
        else:
            open(src_path_text, "w").write(p.pathToSrc)
        print("insert 1 if you want to use old path, 2 if you want to use the default path.(to this directory):")
        p.pathToDal = input("insert path to data access layer file\n")
        if p.pathToDal == "1":
            p.pathToDal = open(dal_path_text).read().strip()
        elif p.pathToDal == "2":
            p.pathToDal = "1"
        else:
            open(dal_path_text, "w").write(p.pathToDal)
        backend_dal = "Backend"
        s = "none"
        # createDAOFiles()
        # createBusinessFiles()
        # createServiceFiles()
        # createDTOFiles()


def create_text_box(root, text, x, y, width, height):
    text_box = Text(root, width=width, height=height)
    text_box.insert(INSERT, text)
    text_box.place(x=x, y=y)
    return text_box


def choose_path(text_box, path_text):
    text = str(text_box.get(0.0, END))
    open(os.getcwd() + path_text, "w").write(text)


def main():
    root = Tk()
    root.title("Parser GUI")
    root.geometry("1000x500")
    """the main frame
    the main menu, in it we have a button for generating the service, business, dto and dao classes
    we have a text box for the path to the src folder
    we have a text box for the path to the database of the project
    we have a text box for the path to the dal folder
    under each text box we have a button for choosing the path
    for generating the service, business, dto and dao classes we have the functions in the ClassesGenerators folder
    
    """
    main_frame = Frame(root)
    main_frame.pack()
    main_menu = Menu(root)
    root.config(menu=main_menu)
    file_menu = Menu(main_menu)
    pathsFiles = os.getcwd() + "\\PathFiles"
    src_path_text = pathsFiles + "\\srcPath.txt"
    db_path_text = pathsFiles + "\\dbPath.txt"
    dal_path_text = pathsFiles + "\\dalPath.txt"
    path_to_data_access = pathsFiles + "\\pathToDataAccess.txt"
    main_menu.add_cascade(label="File", menu=file_menu)
    file_menu.add_command(label="Generate", command=lambda: generate_classes(root))
    file_menu.add_command(label="Exit", command=root.destroy)
    """ add the text boxes and buttons """
    path_to_src_box = create_text_box(root, open(src_path_text).read(), 10, 10, 60, 20)
    path_to_db_box = create_text_box(root, open(db_path_text).read(), 10, 40, 60, 20)
    path_to_dal_box = create_text_box(root, open(dal_path_text).read(), 10, 70, 60, 20)
    """ add the buttons for choosing the path """
    choose_src_path = Button(root, text="Choose src path",
                             command=lambda: choose_path(path_to_src_box, "\\PathFiles\\srcPath.txt"))
    choose_src_path.place(x=500, y=10)
    choose_db_path = Button(root, text="Choose db path",
                            command=lambda: choose_path(path_to_db_box, "\\PathFiles\\dbPath.txt"))
    choose_db_path.place(x=500, y=40)
    choose_dal_path = Button(root, text="Choose dal path",
                             command=lambda: choose_path(path_to_dal_box, "\\PathFiles\\dalPath.txt"))
    choose_dal_path.place(x=500, y=70)
    """ add the buttons for generating the classes """
    generate_service = Button(root, text="Generate Service", command=lambda: generate_classes(root, "Service"))
    generate_service.place(x=10, y=100)
    generate_business = Button(root, text="Generate Business", command=lambda: generate_classes(root, "Business"))
    generate_business.place(x=10, y=130)
    generate_dto = Button(root, text="Generate DTO", command=lambda: generate_classes(root, "DTO"))
    generate_dto.place(x=10, y=160)
    generate_dao = Button(root, text="Generate DAO", command=lambda: generate_classes(root, "DAO"))
    generate_dao.place(x=10, y=190)
    generate_all = Button(root, text="Generate All", command=lambda: generate_classes(root, "All"))
    generate_all.place(x=10, y=220)
    """ add the buttons for generating classes by path """
    generate_all_by_path = Button(root, text="Generate All by path",
                                  command=lambda: generate_classes_by_path(root, "All"))
    generate_all_by_path.place(x=100, y=220)
    generate_all_by_path.place(x=100, y=220)
    root.mainloop()


if __name__ == '__main__':
    main()
