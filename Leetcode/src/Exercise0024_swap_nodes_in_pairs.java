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

    // 2. 递归法 O(n)、O(n) 从后往前
    public ListNode swapPairs(ListNode head) {
        // 边界条件
        if (head == null || head.next == null)
            return head;
        // 递：获取后续处理队列
        ListNode tail = swapPairs(head.next.next);
        // 归：拼接
        ListNode newHead = head.next;
        head.next = tail;
        newHead.next = head;
        return newHead;
    }

//    // 1. 迭代法 O(n)、O(1) 从前往后
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummyHead = new ListNode();
//        dummyHead.next = head;
//        ListNode pre = dummyHead;
//        while(pre.next != null && pre.next.next != null) {
//            ListNode node1 = pre.next;
//            ListNode node2 = node1.next;
//            node1.next = node2.next;
//            node2.next = node1;
//            pre.next = node2;
//            pre = node1;
//        }
//        return dummyHead.next;
//    }
}

// 1. 迭代法 O(n)、O(1) 从前案后
// 2. 递归法 O(n)、O(n) 从后往前