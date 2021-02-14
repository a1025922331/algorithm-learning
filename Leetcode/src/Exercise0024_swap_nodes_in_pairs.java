import java.util.List;

public class Exercise0024_swap_nodes_in_pairs {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode node1 = pre.next, node2;
        while(node1 != null && node1.next != null) {

        }

        return head;
    }
}

// 1. 迭代法