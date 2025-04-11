import java.util.ArrayList;

public class Heap<Type extends Comparable<Type>> {
    private ArrayList<HeapNode<Type>> heap;

    public Heap() {
        heap = new ArrayList<>();
        heap.add(null); // posición 0 no se usa
    }

    public void insert(Type value, int priority) {
        HeapNode<Type> newNode = new HeapNode<>(value, priority);
        heap.add(newNode);
        heapifyUp(heap.size() - 1);
    }

    public HeapNode<Type> remove() {
        if (heap.size() == 1){
            return null;
        } 
        if (heap.size() == 2){
            return heap.remove(1);
        } 
        HeapNode<Type> top = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));
        heapifyDown(1);
        return top;
    }

    private void heapifyUp(int index) {
        while (index > 1 && heap.get(index).priority < heap.get(index / 2).priority) {
            switchNodes(index, index / 2);
            index /= 2;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size() - 1;
        while (index * 2 <= size) {
            int left = index * 2;
            int right = index * 2 + 1;
            int smallest = left;
            if (right <= size && heap.get(right).priority < heap.get(left).priority) {
                smallest = right;
            }
            if (heap.get(smallest).priority < heap.get(index).priority) {
                switchNodes(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void switchNodes(int i, int j) {
        HeapNode<Type> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.size() == 1;
    }

    public int size() {
        return heap.size() - 1;
    }
}