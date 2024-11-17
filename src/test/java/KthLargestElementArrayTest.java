import org.example.easy.heap.KthLargestElementInArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthLargestElementArrayTest {

    @Test
    void test() {
        KthLargestElementInArray kthLargest = new KthLargestElementInArray();

        Assertions.assertEquals(3, kthLargest.findKthLargest(new int[]{4, 1, 2, 3}, 2));
        Assertions.assertEquals(4, kthLargest.findKthLargest(new int[]{4, 1, 2, 3}, 1));
        Assertions.assertEquals(3, kthLargest.findKthLargest(new int[]{3}, 1));
        Assertions.assertEquals(4, kthLargest.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
