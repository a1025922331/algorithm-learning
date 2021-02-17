import java.util.ArrayList;
import java.util.List;

public class Exercise0206_reverse_linked_list {
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

//    // 1. 递归1：尾插O(n^2)、O(n)：尾插，空间n为递归栈
//    public ListNode reverseList(ListNode head) {
//        // 边界
//        if (head == null || head.next == null)
//            return head;
//        // 递归入口
//        // 1. 摘下当前结点并保存
//        ListNode node = head;
//        // 2. 尾插法 //[修改]其实不用那么麻烦，当前的node的next指向的即为result的尾结点，因此直接node.next.next = node即可，与法2的差别也在此
//        ListNode result = reverseList(head.next);
//        ListNode point = result;
//        while (point.next != null) {
//            point = point.next;
//        }
//        point.next = node;
//        node.next = null;
//        return result;
//    }

    // 2. 递归2：O(n)、O（n）:从头到尾变成从尾到头
    // https://leetcode-cn.com/problems/reverse-linked-list/solution/shi-pin-jiang-jie-die-dai-he-di-gui-hen-hswxy/
    public ListNode reverseList(ListNode head) {
        // 边界条件,只剩一个结点了，同时把空链表也并入处理
        if (head == null || head.next == null) {
            return head;
        }
        // 递
        ListNode newHead = reverseList(head.next);
        // 归
        head.next.next = head; //把链表方向反过来
        head.next = null; //1、原先的第一个结点的next应为null 2、其它结点的next会在归的过程中重新赋值，即上一条语句
        return newHead;
    }

//    // 3. 迭代 O(n)、O(n)
//    public ListNode reverseList(ListNode head) {
//        ListNode cur = head, next, result = null;;
//        while(cur != null) {
//            next = cur.next;
//            cur.next = result;
//            result = cur;
//            cur = next;
//        }
//        return result;
//    }
}

// 1. 递归1：尾插O(n^2)、O(n)：尾插，空间n为递归栈(可以优化成O(n)，不用遍历即可找到尾指针)
// 2. 递归2：O(n)、O（n）:从头到尾变成从尾到头，把链表方向反过来（值得学习）
// https://leetcode-cn.com/problems/reverse-linked-list/solution/shi-pin-jiang-jie-die-dai-he-di-gui-hen-hswxy/
// 3. 迭代 O(n)、O(1)

