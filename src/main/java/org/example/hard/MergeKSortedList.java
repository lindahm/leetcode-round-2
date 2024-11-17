package org.example.hard;

/**
 * 23
 * */
import org.example.ListNode;
import org.example.easy.MergeTwoSortedList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length > 1) {
            int middle = (lists.length - 1) / 2;
            ListNode mergedListRight = mergeKLists(Arrays.copyOfRange(lists,0, middle + 1));
            ListNode mergedListLeft = mergeKLists(Arrays.copyOfRange(lists,middle + 1, lists.length));
            return merge(mergedListLeft, mergedListRight);
        }

        return lists.length == 0 ? null : lists[0];
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0, null);
        ListNode resultTail = dummyNode;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                resultTail.next = l1;
                l1 = l1.next;
            } else {
                resultTail.next = l2;
                l2 = l2.next;
            }
            resultTail = resultTail.next;
        }

        if (l1 != null) resultTail.next = l1;
        if (l2 != null) resultTail.next = l2;

        return dummyNode.next;
    }
}
