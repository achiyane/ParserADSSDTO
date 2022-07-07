import os
from tkinter import *
from tkinter import filedialog, messagebox

import Parser as p
from ClassesGenerators import ServiceGenerator, BusinessGenerator, DAOGenerator, DTOGenerator, CLIGenerator
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


def generate_cli(root):
    print("Generating CLI...")
    pathsFiles = os.getcwd() + "\\PathFiles"
    p.createDirectoryIfNotExist(pathsFiles)
    CLIGenerator.create_cli_class(p.pathToFacade)
    print("Generating CLI... Done!")


def help_window(root, menu):
    """create the help window. explain usage in the system"""
    help_window = Label(root, text="""default path of the src is the working directory path
    when you insert the regular path, it will look for your packages called DataAccess, Logic, PresentationLayer, Service, DTOs, DAOs, Service\Objects
    if you want to change the path, you can insert the path in the text box and press the button
    if you want to generate the classes, you can choose the classes you want to generate in the menu in the top left corner
    if you want to generate the CLI, you can press the button in the menu in the top left corner
    """, font=("Arial", 10))
    help_window.pack()
    help_window.place(x=20, y=120)


def main():
    root = Tk()
    root.title("Classes Generator GUI")
    root.geometry("1300x500")
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
    root.config(menu=main_menu, borderwidth=2, highlightthickness=2)
    file_menu = Menu(main_menu)
    pathsFiles = os.getcwd() + "\\PathFiles"
    src_path_text = pathsFiles + "\\srcPath.txt"
    db_path_text = pathsFiles + "\\dbPath.txt"
    facade_path_text = pathsFiles + "\\facadePath.txt"
    p.PathToDB = open(db_path_text).read().strip()
    p.pathToFacade = open(facade_path_text).read().strip()
    main_menu.add_cascade(label="Menu", menu=file_menu)
    file_menu.add_command(label="Generate Service", command=lambda: generate_classes(root, "Service"))
    file_menu.add_command(label="Generate Business", command=lambda: generate_classes(root, "Business"))
    file_menu.add_command(label="Generate DTO", command=lambda: generate_classes(root, "DTO"))
    file_menu.add_command(label="Generate DAO", command=lambda: generate_classes(root, "DAO"))
    file_menu.add_command(label="Generate All", command=lambda: generate_classes(root, "All"))
    file_menu.add_command(label="Generate CLI", command=lambda: generate_cli(root))
    file_menu.add_command(label="Exit", command=root.destroy)
    """ add the text boxes and buttons """
    width = 140
    path_to_src_box = create_text_box(root, open(src_path_text).read(), 10, 10, width, 20)
    path_to_db_box = create_text_box(root, open(db_path_text).read(), 10, 40, width, 20)
    path_to_facade_box = create_text_box(root, open(facade_path_text).read(), 10, 70, width, 20)
    """ add the buttons for choosing the path """
    x_size, y_size = 1140, 10
    choose_src_path = Button(root, text="Choose src path",
                             command=lambda: choose_path(path_to_src_box, "\\PathFiles\\srcPath.txt"))
    choose_src_path.place(x=x_size, y=y_size)
    choose_db_path = Button(root, text="Choose db path",
                            command=lambda: choose_path(path_to_db_box, "\\PathFiles\\dbPath.txt"))
    choose_db_path.place(x=x_size, y=y_size + 30)
    choose_facade_path = Button(root, text="Choose facade path",
                                command=lambda: choose_path(path_to_facade_box, "\\PathFiles\\facadePath.txt"))
    choose_facade_path.place(x=x_size, y=y_size + 60)
    # help button for the user to know how to use the program
    help_button = Button(root, text="Help", command=lambda: help_window(root, main_menu))
    help_button.place(x=x_size, y=y_size + 90)
    root.mainloop()


if __name__ == '__main__':
    try:
        main()
    except Exception as e:
        print(e)
        print("Error in the program, please try again")
        msg = """make sure the db DDLs is in the correct format"""
        # gui window message for the user desplaying msg
        messagebox.showinfo("Error", msg)
        exit()
