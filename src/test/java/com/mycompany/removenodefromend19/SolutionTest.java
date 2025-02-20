package com.mycompany.removenodefromend19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testRemoveNthFromEnd() {
        Solution solution = new Solution();
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = solution.removeNthFromEnd(root, 2);
        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertNull(result.next.next);

        root = new ListNode(1);
        result = solution.removeNthFromEnd(root, 2);
        assertEquals(1, result.val);
        assertNull(result.next);

        root = new ListNode(1);
        result = solution.removeNthFromEnd(root, 1);
        assertNull(result);

        root = new ListNode(1, new ListNode(2, new ListNode(3)));
        result = solution.removeNthFromEnd(root, 1);
        assertNotNull(result);
        assertNull(result.next.next);
        assertEquals(2, result.next.val);

        root = new ListNode(1, new ListNode(2, new ListNode(3)));
        result = solution.removeNthFromEnd(root, 3);
        assertEquals(2, result.val);

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        result = solution.removeNthFromEnd(root, 3);
        assertNotNull(result);
        assertEquals(4, result.next.next.val);
    }
}
