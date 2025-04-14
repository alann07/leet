package com.mycompany.mergetwolists21;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.val);
        assertNull(result.next.next.next.next.next.next);

        l1 = new ListNode(1, new ListNode(2));
        l2 = null;
        result = solution.mergeTwoLists(l1, l2);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);

        l1 = new ListNode(1, new ListNode(2));
        l2 = new ListNode(3);
        result = solution.mergeTwoLists(l1, l2);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull(result.next.next.next);

        l1 = new ListNode(2, new ListNode(3));
        l2 = new ListNode(1);
        result = solution.mergeTwoLists(l1, l2);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull(result.next.next.next);
    }
}

