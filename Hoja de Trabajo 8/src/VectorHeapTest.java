import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @org.junit.jupiter.api.Test
    void add() {
        VectorHeap<String> v = new VectorHeap<>();
        v.add("A");
        v.add("B");
        v.add("D");
        v.add("A");
        v.add("E");
        v.add("G");
        v.add("I");
        v.add("C");

        v.print();

    }

    @org.junit.jupiter.api.Test
    void remove() {
        VectorHeap<String> v = new VectorHeap<>();
        v.add("A");
        v.add("B");
        v.add("D");
        v.add("A");
        v.add("E");
        v.add("G");
        v.add("I");
        v.add("C");

        v.remove();
        v.remove();

        v.print();

    }
}