import java.util.Vector;

    /** Clase creada por Juan Carlos Bajan
     * Vector Heap
    * **/

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    protected Vector<E> data; // the data, kept in heap order

        /**Constructor**/
    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }
        /**Retorna el indice del padre**/
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i - 1) / 2;
    }

        /**Retorna el indice del hijo izquierdo**/
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2 * i + 1;
    }

        /**Retorna el indice del hijo derecho**/
    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2 * i + 1) + 1;
    }

        /**Reordena el Heap**/
    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

        /**Anade un valor y luego ordena el Heap**/
    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size() - 1);
    }

        /**Funcion para bajar un valor en su jerarquia**/
    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos + 1)).compareTo
                                (data.get(childpos)) < 0)) {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root, value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root, value);
                return;
            }
        }
    }

        /**Elimina el primer valor del heap**/
    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }


        /**Retorna el primer valor, en otras estructuras se conoce como peek**/
    @Override
    public E getFirst() {
        if (data.isEmpty()){
            return null;
        } else {
            return data.firstElement();
        }
    }

        /**Imprime los valores del heap ordenadamente**/
    public void print(){
        int initialSize = data.size();
        for (int i = 0; i<initialSize;i++){
            System.out.println(getFirst().toString());
            remove();
        }
    }

}