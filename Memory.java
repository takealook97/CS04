import java.util.*;

public class Memory {
    static Stack<String> stack;
    static ArrayDeque<HashMap<String, String>> heap;
    int stackWholeSize;
    int heapWholeSize;
    static String baseAddress = new Memory().getHexAddress(0);
    static HashMap<String, Integer> sizeOfType = new HashMap<>();
    int pointer;//4바이트 기준으로 동작하는 타입
    static HashMap<String, String> heapInfo = new HashMap<>();
    int stackAddressNum;

    String init(int stackSize, int heapSize) {
        stack = new SizedStack<>(stackSize);//후입선출
        heap = new ArrayDeque<>(heapSize);//선입선출
        stackWholeSize = stackSize;
        heapWholeSize = heapSize;
        return baseAddress;
    }

    void setSize(String type, int length) {
        //todo : 1~32 특정 숫자가 아닐경우 return 하는 if문 추가
        if (sizeOfType.containsKey(type)) {
            return;
        }
        sizeOfType.put(type, length);
    }

    int malloc(String type, int count) {//count만큼 반복 후 메모리할당, 시작주소 스택에 추가, 스택 주소값 리턴
        if (!sizeOfType.containsKey(type)) {//malloc시 setSize 안된 타입이 들어오면 -1 리턴
            return -1;
        }
        stack.push(Integer.toString(pointer));//힙메모리에 malloc으로 추가할 때의 포인터 주소값을 스택에 추가
        if (sizeOfType.get(type) < 8) {
            sizeOfType.put(type, 8);//패딩 todo : 잠깐 바꿔야함
        }
        heapInfo.put(type, sizeOfType.get(type) + "(size)," + pointer + "(sp)");
        int startPoint = pointer;//포인터 위치변 전 위치값 변수
        for (int i = pointer; i < pointer + (count * sizeOfType.get(type)); i++) {//포인터를 시작점으로 count만큼의 범위 할당
            heap.add(heapInfo);
        }
        pointer += (sizeOfType.get(type) * count);//타입에 맞게 힙에 추가 해준 뒤 늘어난 범위만큼 포인터 위치 변경
        return stack.indexOf(Integer.toString(startPoint));//포인터의 위치를 찾아서 스택주소값 리턴
    }


    String free(int stackAddress) {//스택 주소값에 있는 힙영역 고유 주소를 찾아서 해제하고 반환
        for (int i = stackAddress; i < heap.size(); i++) {

        }
        heap.pop(stackAddress);
        stackAddress = getHexAddress(stack.get(baseAddress));
        return null;
    }

    void call(String name, int paramCount) {//함수 호출 하면 스택에 쌓임 = 쌓는다
        if (name.length() > 8 || name.length() == 0) {
            System.out.println("Name is out of range");
        } else if (paramCount < 0 || paramCount > 10) {
            System.out.println("Parameter Count is out of range");
        } else {//

//            stack.push(stack(name, paramCount));
//            stackPointer += paramCount;
        }
    }

    void returnFrom(String name) {//스택에 쌓인 마지막을 리턴한다. = 리턴한다 + 힙영역에 있는 정보값들은 삭제가 되지 않은 상태(garbage collect)

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
