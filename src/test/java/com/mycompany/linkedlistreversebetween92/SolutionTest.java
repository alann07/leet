package com.mycompany.linkedlistreversebetween92;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        ListNode head = new ListNode(5);
        assertEquals(5, solution.reverseBetween(head, 1,1).val);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.reverseBetween(head, 2, 4);
        assertEquals(1, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        result = solution.reverseBetween(head, 2, 4);
        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(2, result.next.next.val);

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        result = solution.reverseBetween(head, 2, 3);
        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(2, result.next.next.val);

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        result = solution.reverseBetween(head, 2, 2);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);

        head = new ListNode(3, new ListNode(5, new ListNode(2)));
        result = solution.reverseBetween(head, 1, 3);
        assertEquals(2, result.val);
        assertEquals(5, result.next.val);
        assertEquals(3, result.next.next.val);

        head = new ListNode(3, new ListNode(5));
        result = solution.reverseBetween(head, 1, 2);
        assertEquals(5, result.val);
        assertEquals(3, result.next.val);
    }
}

