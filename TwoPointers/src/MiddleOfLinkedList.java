public class MiddleOfLinkedList {

    /*
    Given the head of a singly linked list, return the middle node of the
    linked list.

    If there are two middle nodes, return the second middle node.

        Example 1:
        Input: head = [1,2,3,4,5]
        Output: [3,4,5]
        Explanation: The middle node of the list is node 3.

        Example 2:
        Input: head = [1,2,3,4,5,6]
        Output: [4,5,6]
        Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


        Constraints:

        The number of nodes in the list is in the range [1, 100].
        1 <= Node.val <= 100
     */

    /*
    run time 100%. memory 58%
     */
    public ListNode middleNode(ListNode head) {
        int length = getLen(head);
        ListNode temp = head;
        int middleLength = length / 2;
        while (middleLength != 0) {
            temp = temp.next;
            middleLength--;
        }
        return temp;
    }

    public int getLen(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public ListNode pushNode(int data, ListNode head)
    {
        ListNode new_node = new ListNode(data);
        new_node.next = head;
        return new_node;
    }

    public void printNode(ListNode head)
    {
        StringBuffer sb = new StringBuffer();
        ListNode temp = head;
        System.out.print("[");
        while (temp != null) {
            sb.append(temp.val);
            sb.append(",");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main (String[] args) {
        int[] head1 = {1,2,3,4,5};
        int[] head2 = {1,2,3,4,5,6};

        ListNode node1 = new ListNode(head1[head1.length-1]);
        MiddleOfLinkedList ob = new MiddleOfLinkedList();
        for (int i=head1.length-2; i>=0; i--) {
            node1 = ob.pushNode(head1[i], node1);
        }

        ob.printNode(ob.middleNode(node1));

        ListNode node2 = new ListNode(head2[head2.length-1]);
        for (int i=head2.length-2; i>=0; i--) {
            node2 = ob.pushNode(head2[i], node2);
        }

        ob.printNode(ob.middleNode(node2));
    }

}

