import org.example.hard.CountOfRangeSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountOfRangeSumTest {
    @Test
    void test() {
        CountOfRangeSum counter = new CountOfRangeSum();
        Assertions.assertEquals(3, counter.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        Assertions.assertEquals(2, counter.countRangeSum(new int[]{0,-3,-3,1,1,2}, 3, 5));
    }
}
