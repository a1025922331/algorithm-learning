public class Exercise0153_find_minimum_in_rotated_sorted_array {
    // //直接遍历一遍
    // public int findMin(int[] nums) {
    //     int min = Integer.MAX_VALUE;
    //     for (int num : nums) {
    //         min = Math.min(min, num);
    //     }
    //     return min;
    // }

    // 二分: 难点在于寻找边界条件，当显然此处的边界条件即为mid两侧出现降序，判断一下即可
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        // 完全有序
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        //
        while (right >= left) {
            int mid = left + (right - left) / 2;
            //边界条件1
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            //边界条件2
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            //前面有序，说明变化点在后面
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}