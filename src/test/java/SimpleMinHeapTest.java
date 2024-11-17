import org.example.easy.heap.SimpleMinHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleMinHeapTest {

    @Test
    void add() {
        SimpleMinHeap heap = new SimpleMinHeap(5);
        heap.add(5);
        heap.add(1);
        heap.add(3);
        heap.add(4);
        heap.add(2);

        heap.print();
        for (int i = 1; i < 5; i++) {
            Assertions.assertEquals(i, heap.peek());
            Assertions.assertEquals(i, heap.poll());
        }
    }
}
