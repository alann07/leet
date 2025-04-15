package com.mycompany.mergeklists23;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        ListNode[] lists = new ListNode[2];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeKLists(lists);
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.val);
        assertNull(result.next.next.next.next.next.next);

        lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(6);
        result = solution.mergeKLists(lists);
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.next.val);
        assertNull(result.next.next.next.next.next.next.next);

        lists = new ListNode[4];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(6);
        lists[3] = null;
        result = solution.mergeKLists(lists);
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.next.val);
        assertNull(result.next.next.next.next.next.next.next);
    }
}

