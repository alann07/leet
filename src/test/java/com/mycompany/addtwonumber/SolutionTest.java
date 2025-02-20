package com.mycompany.addtwonumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testSoloution() {
        Solution solution = new Solution();

        System.out.println("test case 1");
        ListNode result = solution.addTwoNumbers(null, null);
        assertNull(result);

        System.out.println("test case 2");
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        l1.val = 2; l1.next = new ListNode(4, new ListNode(3));
        l2.val = 5; l2.next = new ListNode(6, new ListNode(4));

        result = solution.addTwoNumbers(l1, l2);
        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);

        System.out.println("test case 3");
        l1.val = 9; l1.next = new ListNode(9);
        l2.val = 9; l2.next = new ListNode(9, new ListNode(9));

        result = solution.addTwoNumbers(l1, l2);
        assertEquals(8, result.val);
        assertEquals(9, result.next.val);
        assertEquals(0, result.next.next.val);
        assertEquals(1, result.next.next.next.val);

        System.out.println("test case 4");
        l1.val = 0; l1.next = null;
        l2.val = 0; l2.next = null;

        result = solution.addTwoNumbers(l1, l2);
        assertEquals(0, result.val);

        System.out.println("test case 5");
        l1.val = 9; l1.next = null;
        l2.val = 9; l2.next = null;

        result = solution.addTwoNumbers(l1, l2);
        assertEquals(8, result.val);
        assertEquals(1, result.next.val);

        System.out.println("test case 6");
        l1.val = 3; l1.next = null;
        l2.val = 4; l2.next = null;

        result = solution.addTwoNumbers(l1, l2);
        assertEquals(7, result.val);
        assertNull(result.next);
    }
}
