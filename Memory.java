import java.util.HashMap;

public class Memory {
    int pointer;//4바이트 기준으로 동작하는 타입
    HashMap<String, String> stack = new HashMap<>();
    HashMap<String, String> heap = new HashMap<>();

    String init(int stackSize, int heapSize) {
        for (int i = 0; i < stackSize; i++) {
            String hex = Integer.toHexString(i);
            while (hex.length() < 3) {
                hex = "0" + hex;
            }
            stack.put("0x0" + hex, null);//들어온 스택메모리 사이즈만큼 키값 생성
        }
        for (int i = 0; i < heapSize; i++) {
            String hex = Integer.toHexString(i);
            while (hex.length() < 3) {
                hex = "0" + hex;
            }
            heap.put("0x0" + hex, null);//들어온 힙메모리 사이즈만큼 키값 생성
        }

        return "0x0000";
    }

    void setSize(String type, int length) {
        switch (type) {
            case "int":

                break;
            case "string":

                break;
            case "short":

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
