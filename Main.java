import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Memory memory = new Memory();
        String baseAddress = memory.init(1024, 1024);
        memory.setSize("short", 4);
        memory.setSize("int", 8);
        memory.setSize("string", 16);
        String arrayPointer = memory.malloc("int", 4);
        String shortPointer = memory.malloc("short", 5);
        new Main().print(new Memory().heapdump());
        new Memory().call("foo", 2);
        String string1 = memory.malloc("crong", 1);
        new Main().print(new Memory().callstack());
        new Memory().call("bar", 1);
        String string2 = memory.malloc("jk", 2);
        new Memory().returnFrom("bar");
        new Memory().free(string1);
        new Main().print(new Memory().heapdump());
        new Memory().free(string2);
        new Main().print(new Memory().callstack());
        new Memory().garbageCollect();
        new Main().print(new Memory().heapdump());
        new Memory().reset();
        new Main().print(new Memory().heapdump());
    }

    void print(String input) {
        System.out.println(input);
    }

    void print(String[] input) {
        System.out.println(Arrays.toString(input));
    }
}
