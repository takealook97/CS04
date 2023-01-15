import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Memory memory = new Memory();

        String baseAddress = memory.init(1024, 1024);
        memory.setSize("short", 4);
        memory.setSize("int", 8);
        memory.setSize("string", 16);
        int arrayPointer = memory.malloc("int", 4);// = 0
        int shortPointer = memory.malloc("short", 5);// = 1
        print(memory.heapdump());
        memory.call("foo", 2);
//        int string1 = memory.malloc("crong", 1);
//        print(memory.callstack());
//        memory.call("bar", 1);
//        int string2 = memory.malloc("jk", 2);
//        memory.returnFrom("bar");
//        memory.free(string1);
//        print(memory.heapdump());
//        memory.free(string2);
//        print(memory.callstack());
//        memory.garbageCollect();
//        print(memory.heapdump());
//        memory.reset();
//        print(memory.heapdump());
    }

    static void print(String input) {
        System.out.println(input);
    }

    static void print(String[] input) {
        System.out.println(Arrays.toString(input));
    }
}
