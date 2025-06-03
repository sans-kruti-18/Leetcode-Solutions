// Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert copy nodes in between original nodes
        Node temp = head;
        while (temp != null) {
            Node nextNode = temp.next;
            Node copy = new Node(temp.val);
            temp.next = copy;
            copy.next = nextNode;
            temp = nextNode;
        }

        // Step 2: Assign random pointers for the copy nodes
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate original and copied lists
        temp = head;
        Node pseudoHead = new Node(0);
        Node copyCurrent = pseudoHead;

        while (temp != null) {
            Node copy = temp.next;
            temp.next = copy.next; // restore original list
            copyCurrent.next = copy;
            copyCurrent = copy;
            temp = temp.next;
        }

        return pseudoHead.next;
    }
}
