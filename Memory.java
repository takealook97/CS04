import java.util.*;

public class Memory {
    static Stack<Integer> stack;
    static ArrayDeque<String> heap;
    int stackWholeSize;
    int heapWholeSize;
    static String baseAddress = new Memory().getHexAddress(0);
    int pointer;//4바이트 기준으로 동작하는 타입
    static HashMap<String, String> heapInfo = new HashMap<>();

    int stackAddressNum;
    int integerSize;
    int stringSize;
    int shortSize;
    int integerPointer;
    int stringPointer;
    int shortPointer;

    String init(int stackSize, int heapSize) {
        stack = new SizedStack<>(stackSize);//후입선출
        heap = new ArrayDeque<>(heapSize);//선입선출
        stackWholeSize = stackSize;
        heapWholeSize = heapSize;
        return baseAddress;
    }

    void setSize(String type, int length) {
//        stack.push(pointer);//힙메모리 주소값
//        heap.add(Integer.toString(length));//type : length
        switch (type) {
            case "int" -> integerSize = length;
            case "string" -> stringSize = length;
            case "short" -> shortSize = length;
        }
    }

    int malloc(String type, int count) {//count만큼 반복 후 메모리할당, 시작주소 스택에 추가, 스택 주소값 리턴
        stack.push(pointer);//힙메모리에 malloc으로 추가할 때의 포인터 주소값을 스택에 추가
        switch (type) {
            case "int" -> {
                if (integerSize < 8) integerSize = 8;
                stack.push(integerSize);
                for (int i = pointer; i < pointer + (count * integerSize); i++) {//포인터를 시작점으로 count만큼의 범위 할당
                    heap.add(type);
                }
                integerPointer = pointer;
                heapInfo.put(type, integerSize + "(size)," + pointer + "(sp)");
                pointer += (integerSize * count);//타입에 맞게 힙에 추가 해준 뒤 늘어난 범위만큼 포인터 위치 변경
            }
            case "string" -> {
                if (stringSize < 8) stringSize = 8;
                stack.push(stringSize);
                for (int i = pointer; i < pointer + (count * stringSize); i++) {
                    heap.add(type);
                }
                stringPointer = pointer;
                heapInfo.put(type, stringSize + "(size)," + pointer + "(sp)");
                pointer += (stringSize * count);//할당한 범위의 끝으로 포인터 위치 조정
            }
            case "short" -> {
                if (shortSize < 8) shortSize = 8;
                stack.push(shortSize);
                for (int i = pointer; i < pointer + (count * shortSize); i++) {
                    heap.add(type);
                }
                shortPointer = pointer;
                heapInfo.put(type, shortSize + "(size)," + pointer + "(sp)");
                pointer += (shortSize * count);
            }
        }
        return stack.search(pointer);//포인터의 위치를 찾아서 스택주소값 리턴
    }


    String free(int stackAddress) {//스택 주소값에 있는 힙영역 고유 주소를 찾아서 해제하고 반환
        for(int i = 0; i < heap.size(); i++){

        }
        heap.pop(stackAddress);
        stackAddress = getHexAddress(stack.get(baseAddress));
        return null;
    }

    void call(String name, int paramCount) {

    }

    void returnFrom(String name) {

    }

    int[] usage() {
        int[] usage = new int[6];
        usage[0] = stackWholeSize;
        usage[1] = stack.size();
        usage[2] = stackWholeSize - stack.size();
        usage[3] = heapWholeSize;
        usage[4] = heap.size();
        usage[5] = heapWholeSize - heap.size();
        return usage;
    }

    String callstack() {
        return null;
    }

    String heapdump() {//타입, 크기, 스택포인터를 문자열 배열로 리턴
        return heapInfo.toString();
    }

    void garbageCollect() {

    }

    void reset() {
        new Memory().init(stackWholeSize, heapWholeSize);
    }

    String getHexAddress(int input) {
        String hex = Integer.toHexString(input);
        while (hex.length() < 2) {
            hex = "0" + hex;
        }
        return "0x" + hex + "00";
    }


}
