// LEETCODE: MEDIUM -----> 237 -----> https://leetcode.com/problems/delete-node-in-a-linked-list/description/

// head is not given only 1 node is given. using 1 node u have to delete 1 node

/*
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5.
the linked list should become 4 -> 1 -> 9 after calling your function.

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1.
 the linked list should become 4 -> 5 -> 9 after calling your function.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class O8_delete_any_node {
    public void deleteNode(ListNode node) {

        ListNode temp = node;
        temp.val = node.next.val;
        temp.next = node.next.next;
    }
}