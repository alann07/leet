package com.mycompany.linkedlistreverse206;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        ListNode head = null;
        assertNull(solution.reverseList(head));

        head = new ListNode(1, new ListNode(2));
        ListNode result = solution.reverseList(head);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);

        head = new ListNode(1, new ListNode(2));
        result = solution.reverseList(head);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        result = solution.reverseList(head);
        assertEquals(5, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(1, result.next.next.next.next.val);
        assertNull(result.next.next.next.next.next);
    }
}
