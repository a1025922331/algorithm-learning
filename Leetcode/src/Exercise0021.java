//合并有序链表
class Exercise0021 {
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        //方法1：迭代
//        //使用哑结点处理边界问题
//        ListNode preResult = new ListNode(-1);
//        //指向新链表当前结点的结点
//        ListNode node = preResult;
//        while (l1 != null && l2 != null) {
//            if (l1.val > l2.val) {
//                node.next = l2;
//                l2 = l2.next;
//            } else {
//                node.next = l1;
//                l1 = l1.next;
//            }
//            node = node.next;
//        }
//        node.next = (l1 == null) ? l2 : l1;
//        return preResult.next;

        //方法2：递归
        //处理边界
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //递归循环体
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}