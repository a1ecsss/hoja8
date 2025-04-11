/**
 * clase que representa un nodo dentro del heap con un valor y una prioridad
 */
public class HeapNode<Type> {
    /** valor que guarda el nodo */
    public Type value;
    /** prioridad asociada al nodo */
    public int priority;

    /**
     * constructor que crea un nodo con su valor y prioridad
     * @param value dato generico
     * @param priority numero entero que indica la prioridad
     */
    public HeapNode(Type value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}