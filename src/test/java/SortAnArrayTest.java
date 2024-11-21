import org.example.medium.SortAnArrayMergeSort;
import org.example.medium.SortAnArrayQuickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortAnArrayTest {
    @Test
    void mergeSort() {
        SortAnArrayMergeSort sorter = new SortAnArrayMergeSort();
        System.out.println(Arrays.toString(sorter.sortArray(new int[]{-2,3,-5})));
    }

    @Test
    void quicksort() {
        SortAnArrayQuickSort sorter = new SortAnArrayQuickSort();
        System.out.println(Arrays.toString(sorter.sortArray(new int[]{5,1,1,2,0,0})));
    }
}
