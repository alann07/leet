package com.mycompany.copyrandomlist138;

/**
 * From discussion forum. A really smart idea.
 *
 * First, we create a copy of each node and insert it immediately after the original node. This
 * means that for every original node, the copied node will be placed next to it in the linked list.
 * This step ensures that we can directly access the random pointer of each original node and assign
 * it to the copied node without requiring extra space for mapping nodes.
 *
 * Next, we traverse the modified list again to correctly assign the random pointers for the newly
 * created nodes. Since each copied node follows its corresponding original node, its random pointer
 * should point to temp.random.next, where temp.random is the random pointer of the original node.
 * This step ensures that all copied nodes have correctly assigned random pointers.
 *
 * Finally, we separate the copied nodes from the original list. We traverse the list once more and
 * restore the next pointers of the original list while extracting the copied nodes into a separate list.
 * Using a dummy node, we efficiently construct the copied list while maintaining the integrity of the
 * original list structure. This final step ensures that we return a deep copy of the list without
 * modifying the original structure.
 *
 * 0ms Beats 100.00%, 44.68MB Beats 40.06%
 */
public class ImprovedSolution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node dummyHead = new Node(-1);
        Node dummy = dummyHead;
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null){
            dummy.next = temp.next;
            dummy = dummy.next;
            temp.next = dummy.next;
            temp = temp.next;
        }
        return dummyHead.next;
    }
}
