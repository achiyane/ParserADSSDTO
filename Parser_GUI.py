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


def choose_generator(fD, pkD, fkD, what_to_generate):
    if what_to_generate == "Service":
        ServiceGenerator.create_service_classes(fD)
    elif what_to_generate == "Business":
        BusinessGenerator.create_business_classes(fD)
    elif what_to_generate == "DAO":
        DAOGenerator.create_dao_classes(fD, fkD)
    elif what_to_generate == "DTO":
        DTOGenerator.create_dto_classes(fD, pkD)
    elif what_to_generate == "All":
        ServiceGenerator.create_service_classes(fD)
        BusinessGenerator.create_business_classes(fD)
        DAOGenerator.create_dao_classes(fD, fkD)
        DTOGenerator.create_dto_classes(fD, pkD)


def generate_classes(root, what_to_generate="All"):
    # tester = input("Test or Not? [y/n]\n")
    print("Generating classes...")
    pathsFiles = os.getcwd() + "\\PathFiles"
    p.createDirectoryIfNotExist(pathsFiles)
    fD = p.getFieldDict()
    pkD = p.getPKDict()
    fkD = p.getFKDict()
    pkDTypes = {}
    for i in pkD:
        pkDTypes[i] = []
        for j in pkD[i]:
            pkDTypes[i].append([p.getFieldInTableType(j, fD, i), j])
    if p.pathToSrc != "default path":
        p.path_to_src_components = PathFinder.findPath(
            ["DataAccess", "Logic", "PresentationLayer", "Service", "DTOs", "DAOs", "Service\\Objects"],
            p.pathToSrc)
    choose_generator(fD, pkDTypes, fkD, what_to_generate)
    print("Generating classes... Done!")


def create_text_box(root, text, x, y, width, height):
    text_box = Text(root, width=width, height=height)
    text_box.insert(INSERT, text)
    text_box.place(x=x, y=y)
    return text_box


def choose_path(text_box, path_text):
    text = str(text_box.get(0.0, END))
    open(os.getcwd() + path_text, "w").write(text)
    if path_text == "\\PathFiles\\pathToSrc.txt":
        p.pathToSrc = text
    elif path_text == "\\PathFiles\\dbPath.txt":
        p.pathToDB = text


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
    p.PathToDB = open(db_path_text).read().strip()
    main_menu.add_cascade(label="File", menu=file_menu)
    file_menu.add_command(label="Generate Service", command=lambda: generate_classes(root, "Service"))
    file_menu.add_command(label="Generate Business", command=lambda: generate_classes(root, "Business"))
    file_menu.add_command(label="Generate DTO", command=lambda: generate_classes(root, "DTO"))
    file_menu.add_command(label="Generate DAO", command=lambda: generate_classes(root, "DAO"))
    file_menu.add_command(label="Generate All", command=lambda: generate_classes(root, "All"))
    file_menu.add_command(label="Exit", command=root.destroy)
    """ add the text boxes and buttons """
    path_to_src_box = create_text_box(root, open(src_path_text).read(), 10, 10, 60, 20)
    path_to_db_box = create_text_box(root, open(db_path_text).read(), 10, 40, 60, 20)
    """ add the buttons for choosing the path """
    choose_src_path = Button(root, text="Choose src path",
                             command=lambda: choose_path(path_to_src_box, "\\PathFiles\\srcPath.txt"))
    choose_src_path.place(x=500, y=10)
    choose_db_path = Button(root, text="Choose db path",
                            command=lambda: choose_path(path_to_db_box, "\\PathFiles\\dbPath.txt"))
    choose_db_path.place(x=500, y=40)
    root.mainloop()


if __name__ == '__main__':
    main()
