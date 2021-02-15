import java.util.HashSet;
import java.util.List;

public class Exercise0141_linked_list_cycle {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 1. 哈希表 O(n)、O(n)
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.add(head)) {
                head = head.next;
            }else {
                return true; // add方法返回false表示添加失败
            }
        }
        return false;
    }
//    // 2. 快慢指针 O(n)、O(1)
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null)
//            return false;
//        ListNode quickPointer = head.next, slowedPointer = head;
//        while (quickPointer != null && quickPointer.next != null) {
//            if (quickPointer == slowedPointer)
//                return true;
//            slowedPointer = slowedPointer.next;
//            quickPointer = quickPointer.next.next;
//        }
//        return false;
//    }
}

// 1. 哈希表 O(n)、O(n)
// 2. 快慢指针 O(n)、O(1)
// 如果存在环，如何判断环的长度呢？方法是，快慢指针相遇后继续移动，直到第二次相遇。两次相遇间的移动次数即为环的长度