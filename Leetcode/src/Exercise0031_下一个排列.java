import java.lang.invoke.VarHandle;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: guozexin.gzx
 * @Date: 2021/7/24
 */
public class Exercise0031_下一个排列 {
    public static void main(String[] args) {
        Exercise0031_下一个排列 object = new Exercise0031_下一个排列();
        int[] nums = new int[]{3, 2, 1};
        object.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 基本思想：将前面的小数和后面的大数交换
    // 1. 从后往前找到第一对顺序对a[i]、a[i+1]，此时[i+1, end]为降序，a[i]为需要更换的小数
    // 2. 从后往前找到第一个大于a[i]的数a[k]（也是最接近的数），此数为变化最小的大数
    // 3. 交换二者，并将[i+1, end]翻转，变为顺序
    // https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        // 找到从后往前的第一对顺序对，找到小数
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 找到大数
        if (i >= 0) {
            int j = len - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 反转
        reverse(nums, i + 1, len - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
