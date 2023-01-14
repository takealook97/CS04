public class Heap {
    String[] heapInfo(String input) {
        int size = 0;
        for (int i = 0; i < Memory.heap.size(); i++) {
            if (Memory.heap.get(new Memory().getHexAddress(i))[0].equals(input)) {
                size++;
            }
        }
        return new String[]{input, Integer.toString(size), Integer.toString(new Memory().pointer)};
    }
}
