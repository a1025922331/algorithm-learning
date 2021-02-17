import java.util.HashSet;

public class Exercise0142_linked_list_cycle_ii {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    // 1. 哈希表 O(n)、O(n)
//    public ListNode detectCycle(ListNode head) {
//        HashSet<ListNode> hashSet = new HashSet<>();
//        while (head != null) {
//            if (hashSet.add(head)) {
//                head = head.next;
//            } else {
//                return head;
//            }
//        }
//        return null;
//    }

    // 2. 快慢指针 O(n)、O(1) ⬇
    // https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head, slow = head;
        while (fast != null) {
            // 先移动再判断
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            // 判断，当追上了进入循环　
            if (fast == slow) {
                ListNode node = head;
                while (node != slow) {
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        }
        return null;
    }
}

// 1. 哈希表 O(n)、O(n)
// 2. 快慢指针 O(n)、O(1) ⬇ slow还没走到环的时候一定会与fast相遇，再用等式变换
// https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
// 解析：slow：a + b
//      fast: a + n(b + c) + b
//      2*slow = fast
//  =>  a = n(b + c) - b = (n-1)(b + c) +c
//  =>  因此当双指针相遇时，再创建一个指针从head开始走，而slow指针继续走，他们就会在入环处相遇，
//      因为a = (n-1)(b + c) +c
