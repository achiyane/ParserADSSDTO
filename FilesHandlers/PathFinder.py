import os


def findPath(namesLst: list, startPath: str):
    """find the path to all files in list from startPath"""
    return [findPathRec(name, startPath) for name in namesLst]


def findPathRec(path: str, startPath: str) -> str:
    # if we need find it first
    try:
        for root, dirs, files in os.walk(startPath):
            if "\\" in name:
                parent, file_name = name.split("\\")
                if parent == root.split("\\")[-1]:
                    return os.path.join(root, file_name)
            else:
                for name in dirs:
                    if name == path:
                        return os.path.abspath(os.path.join(root, name))
    except Exception as e:
        return str(e)
    return create_dir_if_not_exist(os.path.abspath(os.path.join(startPath, path)))


def create_dir_if_not_exist(path: str):
    if not os.path.exists(path):
        os.makedirs(path)
    return path
