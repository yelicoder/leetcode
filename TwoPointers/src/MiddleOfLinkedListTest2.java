import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class MiddleOfLinkedListTest2 {

    @Test
    public void shouldGetMiddleNodeOf12345(){
        int[] head = {1,2,3,4,5};
        int[] expected = {3,4,5};

        LinkedList ll = new LinkedList();
        for (int i=0; i<head.length; i++ ) {
            ll.add(i, new ListNode(i));
        }

        ListNode node = new ListNode(head[head.length-1]);
        MiddleOfLinkedList ob = new MiddleOfLinkedList();
        for (int i=head.length-2; i>=0; i--) {
            node = ob.pushNode(head[i], node);
        }

        node = ob.middleNode(node);

        ListNode expectedNode = new ListNode(expected[expected.length-1]);
        for (int i=expected.length-2; i>=0; i--) {
            expectedNode = ob.pushNode(expected[i], expectedNode);
        }

        Assertions.assertEquals(expectedNode, node);
    }
}
