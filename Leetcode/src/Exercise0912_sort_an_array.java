import java.util.Arrays;

public class Exercise0912_sort_an_array {
//    // 1. 快速排序
//    // 时间: O(nlogn),乱序情况下，有序会退化成n2
//    // 空间: O(nlogn),
//    public int[] sortArray(int[] nums) {
//        partition(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void partition(int[] nums, int low, int high) {
//        // 边界条件
//        if (low >= high)
//            return;
//        // 创建变量
//        int lowCopy = low, highCopy = high;
//        int num = nums[low];
//        // 开始交换
//        while (low < high) {
//            while (low < high && nums[high] >= num) high--;
//            nums[low] = nums[high];
//            while (low < high && nums[low] <= num) low++;
//            nums[high] = nums[low];
//        }
//        // 下探
//        nums[low] = num;
//        partition(nums, lowCopy, low - 1);
//        partition(nums, low + 1, highCopy);
//    }

//    // 2.冒泡排序(稳定)
//    // 时间: O(n^2),
//    // 空间: O(1),
//    public int[] sortArray(int[] nums) {
//        int len = nums.length;
//        for (int i = 0; i < len - 1; i++) {
//            boolean flag = false;
//            for (int j = len - 1; j > i; j--) {
//                if (nums[j] < nums[j - 1]) {
//                    int temp = nums[j - 1];
//                    nums[j - 1] = nums[j];
//                    nums[j] = temp;
//                    flag = true;
//                }
//            }
//            if (!true)
//                return nums;
//        }
//        return nums;
//    }

//    // 3.简单插入排序(稳定)
//    // 时间: O(n^2),
//    // 空间: O(1),
//    public int[] sortArray(int[] nums) {
//        int i, j;
//        // 从第二个元素开始，往前插入
//        for (i = 1; i < nums.length; i++) {
//            int temp = nums[i];
//            // 和前面的比较，大于temp的向后移动
//            for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
//                nums[j + 1] = nums[j];
//            }
//            nums[j + 1] = temp;
//            // System.out.println(Arrays.toString(nums));
//        }
//        return nums;
//    }

    // 3.折半插入排序(稳定)
    // 时间: O(n^2),
    // 空间: O(1),
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i], low = 0, high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] > temp)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // 插在high后面
            for (int j = i - 1; j >= high + 1; j--)
                nums[j + 1] = nums[j];
            nums[high + 1] = temp;
        }
//        System.out.println(Arrays.toString(nums));
        return nums;
    }

//    // 4.简单选择排序(不稳定)
//    // 时间: O(n^2),
//    // 空间: O(1),
//    public int[] sortArray(int[] nums) {
//        //剩一个的时候就不用再选了
//        for (int i = 0; i < nums.length - 1; i++) {
//            int min = nums[i], minIndex = i;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] < min) {
//                    min = nums[j];
//                    minIndex = j;
//                }
//            }
//            int temp = nums[i];
//            nums[i] = nums[minIndex];
//            nums[minIndex] = temp;
//            System.out.println(Arrays.toString(nums));
//        }
//        return nums;
//    }
}