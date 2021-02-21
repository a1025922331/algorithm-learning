public class Exercise0025_reverse_nodes_in_k_group {
    public class ListNode {
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

    // 2. 大迭代+小迭代：O(n)、O(1)
    // https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // pre用于存放当前翻转段的前驱结点，end指向当前翻转段的尾结点，next用于存放下一个待翻转段的头结点
        ListNode pre = dummyHead, end = dummyHead, next;

        // end.next 不等于 null，意味着后面还有需要判断即翻转的
        while (end.next != null) {
            // 移动end指针到它本轮应该到的位置，并判断是否达到翻转条件，即有k个结点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果end == null了，说明该段不够k个，不需要翻转了
            if (end == null)
                break;
            next = end.next; // 记录下段待处理链表的头
            end.next = null;
            ListNode start = pre.next;
            ListNode tempHead = reverse(start);
            // 连接
            pre.next = tempHead;
            start.next = next; // 保证链表连续，以便能够访问到后边进行判断和处理
            // 指针复位
            pre = start;
            end = pre;
        }
        return dummyHead.next;

    }

    // 头插法翻转当前段
    private ListNode reverse(ListNode start) {
        ListNode cur = start, next, newHead = null;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

//    // 1. 大递归+小迭代: O(n)、O(1) 大递归从后往前，小迭代将k个结点头插
//    public ListNode reverseKGroup(ListNode head, int k) {
//        // 边界
//        ListNode pointer = head;
//        for (int i = 0; i < k; i++) {
//            if (pointer == null)
//                return head;
//            pointer = pointer.next;
//        }
//        // 递：获取后面一段的头节点
//        ListNode behindListHead = reverseKGroup(pointer, k);
//        // 归：处理，两个任务（1）连接上，头插法（2）返回新的head结点
//        ListNode cur = head, next, newHead = behindListHead;
//        // 头插
//        while (cur != pointer) {
//            next = cur.next;
//            cur.next = newHead;
//            newHead = cur;
//            cur = next;
//        }
//        return newHead;
//    }
}
// 1. 大递归+小迭代: O(n)、O(n) 大递归从后往前，小迭代将k个结点头插
// 2. 大迭代+小迭代：O(n)、O(1)
// https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
// 第一个网友的评论
// 字节面试最爱考的！！！！
