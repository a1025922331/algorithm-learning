package mo.must.array;

import java.util.ArrayList;
import java.util.Stack;

public class Exercise006 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        //使用集合
//        ArrayList<Integer> list = new ArrayList<>();
//        ListNode node = head;
//        while (node != null) {
//            list.add(node.val);
//            node = node.next;
//        }
//        int[] result = new int[list.size()];
//        for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
//            result[j] = list.get(i);
//        }
//        return result;

        //使用stack栈
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while(node!=null){
            stack.push(node.val);
            node = node.next;
        }

        int len = stack.size();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = stack.pop();
        }

        return result;
    }
}