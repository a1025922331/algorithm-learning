import java.util.List;

/**
 * @Author: guozexin.gzx
 * @Date: 2021/7/10
 */
public class Exercise0002_add_two_numbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode pointerNode = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            pointerNode.next = newNode;
            pointerNode = pointerNode.next;
            carry = sum / 10;
        }
        return dummyNode.next;


    }
}