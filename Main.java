import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Memory memory = new Memory();
        String baseAddress = memory.init(1024, 1024);
        memory.setSize("short", 4);
        memory.setSize("int", 8);
        memory.setSize("string", 16);


    }
    void print(String input){
        System.out.println(input);
    }
    void print(String[] input){
        System.out.println(Arrays.toString(input));
    }
}
