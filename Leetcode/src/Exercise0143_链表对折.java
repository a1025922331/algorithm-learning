import java.util.ArrayList;
import java.util.List;

class ListNode {
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

public class Exercise0143_链表对折 {
    // 链表中点 + 链表反转 + 链表合并
    // 原题可以转换为将左半边链表和翻转后的右半边链表进行合并
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void reorderList(ListNode head) {
        if (head != null || head.next != null) {
            // 获取左半边链表
            ListNode middleNode = middleNode(head);
            ListNode right = middleNode.next;
            middleNode.next = null;
            ListNode left = head;
            // 获取翻转后的右半边链表
            right = reverseList(right);
            // 合并两个链表
            mergeTwoList(left, right);
        }
    }

    // 交叉合并链表
    private void mergeTwoList(ListNode left, ListNode right) {
        ListNode leftNext, rightNext;
        while (left != null && right != null) {
            leftNext = left.next;
            rightNext = right.next;

            left.next = right;
            left = leftNext;

            right.next = left;
            right = rightNext;
        }
    }

    // 链表反转
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 获取链表中点
    private ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 先将链表转换成线性表再按要求连接（原地，参考解法）
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    // 效率没有上一个高，因为涉及比较多的list的get操作
    public void reorderList2(ListNode head) {
        ListNode node = head;
        // 创建线性链表存储原链表
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        // 按要求连接
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    // 先将链表转换成线性表再按要求连接
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public void reorderList1(ListNode head) {
        ListNode node = head;
        // 创建线性链表存储原链表
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int len = list.size();
        ListNode cur = new ListNode();
        for (int i = 0; i < len / 2; i++) {
            // 处理i
            cur.next = list.get(i);
            cur = cur.next;
            // 处理len-1-i
            cur.next = list.get(len - 1 - i);
            cur = cur.next;
        }
        // 如果链表长度为奇数，还需要加上中间的结点
        if (len % 2 != 0) {
            cur.next = list.get(len / 2);
            cur = cur.next;
        }
        // 收尾
        cur.next = null;
    }
}