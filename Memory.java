import java.util.HashMap;

public class Memory {
    int pointer;//4바이트 기준으로 동작하는 타입
    int integerSize;
    int stringSize;
    int shortSize;
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
                integerSize = length;
                break;
            case "string":
                stringSize = length;
                break;
            case "short":
                shortSize = length;
                break;
        }
    }

    String malloc(String type, int count) {//count만큼 반복 후 메모리할당, 시작주소 스택에 추가, 스택 주소값 리턴
        String startAddress = pointer2string();
        stack.put(,pointer2string())//시작주소 스택에 추가
        if (integerSize < 8) integerSize = 8;
        else if (stringSize < 8) stringSize = 8;
        else if (shortSize < 8) shortSize = 8;//패딩 todo : 아예 바꾸는 것이 아니라 malloc할 때만 패딩을 붙여야하지 않나

        switch (type) {
            case "int":
                for (int i = pointer; i < pointer + count * integerSize; i++) {//포인터를 시작점으로 count만큼의 범위 할당
                    String hex = Integer.toHexString(i);
                    while (hex.length() < 2) {
                        hex = "0" + hex;
                    }
                    stack.put("0x" + hex + "00", ?);//todo 범위만 늘려주면되는데 무엇을 넣어야하는가?
                }
                pointer += integerSize * count;
                break;
            case "string":
                for (int i = pointer; i < pointer + count * integerSize; i++) {
                    String hex = Integer.toHexString(i);
                    while (hex.length() < 2) {
                        hex = "0" + hex;
                    }
                    heap.put("0x" + hex + "00", ?);
                }
                pointer += stringSize * count;//할당한 범위의 끝으로 포인터 위치 조정
                break;
            case "short":
                for (int i = pointer; i < pointer + count * shortSize; i++) {
                    String hex = Integer.toHexString(i);
                    while (hex.length() < 2) {
                        hex = "0" + hex;
                    }
                    stack.put("0x" + hex + "00", ?);
                }
                pointer += shortSize * count;
                break;
        }
        return pointer2string();
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

    String pointer2string() {
        String hex = Integer.toHexString(pointer);
        while (hex.length() < 2) {
            hex = "0" + hex;
        }
        return "0x" + hex + "00";
    }
}
