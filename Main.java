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
        print(new Memory().heapdump());
        memory.call("foo", 2);
        String string1 = memory.malloc("crong", 1);
        print(new Memory().callstack());
        memory.call("bar", 1);
        String string2 = memory.malloc("jk", 2);
        memory.returnFrom("bar");
        memory.free(string1);
        print(new Memory().heapdump());
        memory.free(string2);
        print(new Memory().callstack());
        memory.garbageCollect();
        print(new Memory().heapdump());
        new Memory().reset();
        print(new Memory().heapdump());
    }

    static void print(String input) {
        System.out.println(input);
    }

    static void print(String[] input) {
        System.out.println(Arrays.toString(input));
    }
}
