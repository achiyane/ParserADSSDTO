import os


def findPath(namesLst: list, startPath: str):
    """find the path to all files in list from startPath"""
    return [findPathRec(name, startPath) for name in namesLst]


def findPathRec(path: str, startPath: str) -> str:
    # if we need find it first
    try:
        for root, dirs, files in os.walk(startPath):
            for name in dirs:
                if name == path:
                    return os.path.abspath(os.path.join(root, name))
    except Exception as e:
        return str(e)


if __name__ == '__main__':
    print(findPath(["DataAccess", "Logic", "PresentationLayer", "ServiceLayer"],
                   'C:\\Users\\achiy\\ADSS-Projects\\git\\superlee\\dev\\src'))
