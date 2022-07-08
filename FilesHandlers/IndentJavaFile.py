"""reads the java class and return it indentsed
like a java file in intellij
this template class is an example of how to indent a java file
public class Template...{
    private type id;(can be more fields)
    public Template(...){
        this.id = id;
        ...
    }
    public type getId(){
        return id;
    }
    public void setId(type id){
        this.id = id;
    }
    ...(can have a lot of methods)
}
more examples of how to indent a java file in intellij and in the file .txt
public class Foo {
    public int[] X = new int[]{1, 3, 5, 7, 9, 11};

    public void foo(boolean a, int x, int y, int z) {
        label1:
        do {
            try {
                if (x > 0) {
                    int someVariable = a ? x : y;
                    int anotherVariable = a ? x : y;
                } else if (x < 0) {
                    int someVariable = (y + z);
                    someVariable = x = x + y;
                } else {
                    label2:
                    for (int i = 0; i < 5; i++) doSomething(i);
                }
                switch (a) {
                    case 0:
                        doCase0();
                        break;
                    default:
                        doDefault();
                }
            } catch (Exception e) {
                processException(e.getMessage(), x + y, z, a);
            } finally {
                processFinally();
            }
        }
        while (true);

        if (2 < 3) return;
        if (3 < 4) return;
        do {
            x++;
        }
        while (x < 10000);
        while (x < 50000) x++;
        for (int i = 0; i < 5; i++) System.out.println(i);
    }

    private class InnerClass implements I1, I2 {
        public void bar() throws E1, E2 {
        }
    }
}"""


# the line doesn't have to start in { or }, it can be everywhere
# the line doesn't have to end in }, it can be everywhere
# the line doesn't have to start in }, it can be everywhere
# indentation code
def indentJavaFile(lines: str):
    indent = 0
    lst = []
    file = lines.split("\n")
    for i in range(len(file)):
        line = file[i].strip()
        if line.endswith("{"):
            lst.append("    " * indent + line)
            indent += line.count("{")
        elif line.startswith("}"):
            indent -= line.count("}")
            lst.append("    " * indent + line + "\n")
        else:
            if line.strip() != "":
                lst.append("    " * indent + line)
    return join_all_lines(lst)


"""lines will be joined with \n between each line"""


def join_all_lines(file: list[str]):
    return "\n".join(file)
