import java.util.HashMap;

public class Memory {
    int pointer;//4바이트 기준으로 동작하는 타입
    int integerType;
    String stringType;
    int shortType;



    static HashMap<String, Integer> stack = new HashMap<>();
    static HashMap<String, String> heap = new HashMap<>();

    String init(int stackSize, int heapSize) {
        for (int i = 0; i < stackSize / 4; i++) {
            String hex = Integer.toHexString(i);
            while (hex.length() < 2) {
                hex = "0" + hex;
            }
            stack.put("0x" + hex + "00", 0);//들어온 스택메모리 사이즈만큼 키값 생성
        }
        for (int i = 0; i < heapSize / 4; i++) {
            String hex = Integer.toHexString(i);
            while (hex.length() < 2) {
                hex = "0" + hex;
            }
            heap.put("0x" + hex + "00", null);//들어온 힙메모리 사이즈만큼 키값 생성
        }

        return "0x0000";
    }

    void setSize(String type, int length) {
        switch (type) {
            case "int":
                for (int i = pointer; i < pointer + length; i++) {
                    String hex = Integer.toHexString(i);
                    while (hex.length() < 2) {
                        hex = "0" + hex;
                    }
                    stack.put("0x" + hex + "00", integerType);
                }
                break;
            case "string":
                for (int i = pointer; i < pointer + length; i++) {
                    String hex = Integer.toHexString(i);
                    while (hex.length() < 2) {
                        hex = "0" + hex;
                    }
                    heap.put("0x" + hex + "00", null);
                }
                break;
            case "short":
                for (int i = pointer; i < pointer + length; i++) {
                    String hex = Integer.toHexString(i);
                    while (hex.length() < 2) {
                        hex = "0" + hex;
                    }
                    stack.put("0x" + hex + "00", shortType);
                }
                break;
        }
    }

    String malloc(String type, int count) {
        return null;
    }

    void call(String name, int paramCount) {

    }

    void returnFrom(String name) {

    }

    String usage() {
        return null;
    }

    String callstack() {
        return null;
    }

    String[] heapdump() {
        return null;
    }

    void reset() {

    }
}
