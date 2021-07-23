import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Author: guozexin.gzx
 * @Date: 2021/7/24
 */
public class Exercise0023_合并K个升序链表 {
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

    // k：链表数
    // n：链表长度
    // 方法2、3非常值得学习

    // 1.每次选出剩余链表中最小的元素（基于比较）
    // 时间复杂度：O(k^2 * n) 计算方法：kn个结点，每个结点平均被比较n次
    // 空间复杂度：O(k) 用于存储剩余链表的index
    public ListNode mergeKLists1(ListNode[] lists) {
        HashSet<Integer> hashset = new HashSet<>();
        ListNode dummyNode = new ListNode(), cur = dummyNode;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                hashset.add(i);
            }
        }
        while (hashset.size() > 1) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for (Integer i : hashset) {
                if (lists[i].val <= minValue) {
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }
            cur.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            if (lists[minIndex] == null) {
                hashset.remove(minIndex);
            }
            cur = cur.next;
        }
        if (hashset.size() == 1) {
            for (Integer index : hashset) {
                cur.next = lists[index];
            }
            return dummyNode.next;
        } else {
            cur.next = null;
            return dummyNode.next;
        }
    }

    // 2.每次选出剩余链表中最小的元素（基于优先队列）
    // 时间复杂度：O(kn * logk) 计算方法：kn个结点，每个结点插入和删除的时间都为logk（优先队列中最多只维护k个值）
    // 空间复杂度：O(k) 优先队列用于存储当前各个剩余链表的最小结点
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummyNode = new ListNode(), tail = dummyNode;
        while (queue.size() >= 1) {
            ListNode minNode = queue.remove();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) {
                queue.add(minNode.next);
            }
        }
        tail.next = queue.size() == 1 ? queue.remove() : null;
        return dummyNode.next;
    }

    // 3.分治归并（每次合并两个，共合并logk轮）
    // 时间复杂度：O(kn * logk) 计算方法：kn个结点，每个结点参与logk轮比较，每轮比较平均比较2次
    // 空间复杂度：O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeK(lists, 0, lists.length - 1);
    }

    private ListNode mergeK(ListNode[] lists, int begin, int end) {
        if (begin > end) {
            return null;
        } else if (begin == end) {
            return lists[begin];
        }
        int mid = (begin + end) >> 1;
        return mergeTwoList(mergeK(lists, begin, mid), mergeK(lists, mid + 1, end));
    }


    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(), tail = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
        return dummyNode.next;
    }
}