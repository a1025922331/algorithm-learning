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
        ListNode pointer = head;
        while(pointer == null || pointer.next == null) {
            ListNode temp = pointer.next;
            pointer.next = pointer.next.next;
            temp.next = pointer;

        }

        return head;
    }
}

// 1. 迭代法