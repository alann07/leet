package com.mycompany.copyrandomlist138;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();

        Node root = new Node(-1);
        Node result = solution.copyRandomList(root);
        assertFalse(root == result);
        assertEquals(root.val, result.val);

        root = new Node(1);
        Node child = new Node(2);
        root.next = child;
        result = solution.copyRandomList(root);
        assertEquals(root.val, result.val);
        assertEquals(root.next.val, result.next.val);

        root = new Node(1);
        child = new Node(2);
        root.next = child;
        root.random = child;
        child.random = root;
        result = solution.copyRandomList(root);
        assertFalse(root == result);
        assertEquals(root.val, result.val);
        assertEquals(root.next.val, result.next.val);
        assertFalse(root.next == result.next);
        assertNotNull(result.random);
        assertNotNull(result.next.random);
    }
}
