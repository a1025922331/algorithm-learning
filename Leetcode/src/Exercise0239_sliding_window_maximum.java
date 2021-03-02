import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Exercise0239_sliding_window_maximum {
    // 1、优先队列PriorityQueue 112ms O(nlogn)、O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        //创建大根堆，默认是小根堆，传入比较器对象。heap中元素，0索引为值，1索引为位置
        PriorityQueue<Integer[]> bigHeap = new PriorityQueue<>(11, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[0] - o1[0];
            }
        });
        int length = nums.length;
        int[] result = new int[length - k + 1];
        int index = 0;

        //先插入第一个框
        for (int i = 0; i < k; i++) {
            bigHeap.add(new Integer[]{nums[i], i});
        }
        result[index++] = bigHeap.peek()[0];

        //插入后续框
        for (int i = k; i < length; i++) {
            bigHeap.add(new Integer[]{nums[i], i});
            while (bigHeap.peek()[1] <= i - k) {
                bigHeap.poll();
            }
            result[index++] = bigHeap.peek()[0];
        }
        return result;
    }


//    // 2、单调队列方法 37ms O(n)、O(n)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        //创建变量
//        int length = nums.length;
//        Deque<Integer> deque = new LinkedList<>();
//        int[] result = new int[length - k + 1];
//        int index = 0;
//
//        //添加第一个框
//        for (int i = 0; i < k; i++) {
//            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
//                deque.removeLast();
//            }
//            deque.offerLast(nums[i]);
//        }
//        result[index++] = deque.peekFirst(); //这个不需要判断，因为不会超出边界
//
//        //添加后面的框
//        for (int i = k; i < length; i++) {
//            //先判断当前队头元素是否超出边界
//            if (deque.peekFirst() == nums[i - k])
//                deque.removeFirst();
//            //添加并维护队列单调
//            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
//                deque.removeLast();
//            }
//            deque.offerLast(nums[i]);
//            result[index++] = deque.peekFirst();
//        }
//        return result;
//    }
}

// 1. O(nlogn)、O(n) PriorityQueue

// 2. O(n)、O(n) 单调队列：维护一个单调递减队列
//https://leetcode-cn.com/problems/sliding-window-maximum/solution/zhe-hui-yi-miao-dong-bu-liao-liao-de-hua-7fy5/