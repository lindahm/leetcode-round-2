import org.example.medium.SortAnArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    void mergeSort() {
        SortAnArray sorter = new SortAnArray();
        System.out.println(Arrays.toString(sorter.sortArray(new int[]{-2,3,-5})));
    }
}
