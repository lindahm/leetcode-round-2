package org.example.easy;

import org.example.ListNode;

/**
 * 21
 */
public class MergeTwoSortedList {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0, null);
            ListNode resultTail = dummy;
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

            if (l1 != null) {
                resultTail.next = l1;
            }
            if (l2 != null) {
                resultTail.next = l2;
            }

            return dummy.next;
        }
}
