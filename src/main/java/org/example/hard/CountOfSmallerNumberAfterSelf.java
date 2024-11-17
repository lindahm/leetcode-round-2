package org.example.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 315
 * */
public class CountOfSmallerNumberAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sortedList = new ArrayList<>(nums.length);
        Integer[] result = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int sortedIndex = getInsertionIndex(sortedList, nums[i]);
            sortedList.add(sortedIndex, nums[i]);
            result[i] = dedupIndex(nums[i], sortedIndex, sortedList);
        }
        return List.of(result);
    }

    private Integer dedupIndex(int num, int index, List<Integer> sortedList) {
        int dedupIndex = index;
        while (dedupIndex >= 0 && sortedList.get(index).equals(sortedList.get(dedupIndex))) {
            dedupIndex--;
        }
        dedupIndex++;
        return dedupIndex;
    }

    private int getInsertionIndex(List<Integer> sortedList, int num) {
        int low = 0;
        int high = sortedList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedList.get(mid) == num) {
                return mid;
            } else if (num < sortedList.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}
