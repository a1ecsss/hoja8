/**
 * clase que implementa un min heap generico basado en prioridades numericas
 */
import java.util.ArrayList;
public class Heap<Type extends Comparable<Type>> {
    private ArrayList<HeapNode<Type>> heap;

    /**
     * constructor que inicializa la lista y coloca null en la posicion cero
     */
    public Heap() {
        heap = new ArrayList<>();
        heap.add(null);
    }

    /**
     * inserta un nuevo nodo en el heap segun su prioridad
     * @param value valor a insertar
     * @param priority prioridad del nodo
     */
    public void insert(Type value, int priority) {
        HeapNode<Type> newNode = new HeapNode<>(value, priority);
        heap.add(newNode);
        heapifyUp(heap.size() - 1);
    }

    /**
     * remueve el nodo con menor prioridad del heap
     * @return el nodo removido
     */
    public HeapNode<Type> remove() {
        if (heap.size() == 1) return null;
        if (heap.size() == 2) return heap.remove(1);
        HeapNode<Type> top = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));
        heapifyDown(1);
        return top;
    }

    /**
     * ajusta la posicion del nodo hacia arriba si su prioridad es menor
     * @param index posicion del nodo
     */
    private void heapifyUp(int index) {
        while (index > 1 && heap.get(index).priority < heap.get(index / 2).priority) {
            switchNodes(index, index / 2);
            index /= 2;
        }
    }

    /**
     * ajusta la posicion del nodo hacia abajo si pierde prioridad
     * @param index posicion del nodo
     */
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

    /**
     * intercambia dos nodos en el heap
     * @param i posicion del primer nodo
     * @param j posicion del segundo nodo
     */
    private void switchNodes(int i, int j) {
        HeapNode<Type> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /** @return true si el heap esta vacio */
    public boolean isEmpty() {
        return heap.size() == 1;
    }

    /** @return cantidad de nodos dentro del heap */
    public int size() {
        return heap.size() - 1;
    }
}