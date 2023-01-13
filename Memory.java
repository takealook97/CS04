import java.util.HashMap;

public class Memory {
    int pointer;//4바이트 기준으로 동작하는 타입
    String pointer2String;
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
            stack.put("0x" + hex + "00", null);//들어온 스택메모리 사이즈만큼 키값 생성
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
        for (int i = 0; i < count; i++) {

        }

        return null;
    }

    String free(String stackAddress) {
        return null;
    }

    void call(String name, int paramCount) {

    }

    void returnFrom(String name) {

    }

    String usage() {
        int stackLeft = 0;
        for (int i = 0; i < stack.size(); i++) {
            String hex = Integer.toHexString(i);
            while (hex.length() < 2) {
                hex = "0" + hex;
            }
            if (stack.get("0x" + hex + "00") == null) {
                stackLeft++;
            }
        }
        int stackUsed = stack.size() - stackLeft;

        int heapLeft = 0;
        for (int i = 0; i < heap.size(); i++) {
            String hex = Integer.toHexString(i);
            while (hex.length() < 2) {
                hex = "0" + hex;
            }
            if (heap.get("0x" + hex + "00") == null) {
                heapLeft++;
            }
        }
        int heapUsed = heap.size() - heapLeft;
        return stack.size() + ", " + stackUsed + ", " + stackLeft + ", " +
                heap.size() + ", " + heapUsed + ", " + heapLeft;
    }

    String callstack() {
        return null;
    }

    String[] heapdump() {
        String type = "";
        int size = 0;
        String stackPointer = "";
        return new String[]{type, Integer.toString(size), stackPointer};
    }

    void garbageCollect() {

    }

    void reset() {
        new Memory().init(stack.size(), heap.size());
    }
}
