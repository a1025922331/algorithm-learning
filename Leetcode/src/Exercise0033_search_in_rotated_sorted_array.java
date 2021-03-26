public class Exercise0033_search_in_rotated_sorted_array {
    // 更加正常的写法，在循环中判断，如果出了循环则说明没找到
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;
        if (len == 1)
            return nums[0] == target? 0: -1;

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            // 有等于号是因为mid可能等于left
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else {
                if (target > nums[mid] && target < nums[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    //在循环中判断，边界条件不容易想
//    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            // 列出规约到右边的情况
//            if (nums[mid] >= nums[left] && (nums[mid] < target || nums[left] > target))
//                left = mid + 1;
//            else if (nums[mid] < nums[left] && target > nums[mid] && nums[left] > target)
//                left = mid + 1;
//            else
//                right = mid; //不能-1，防止出界，考虑最短情况两个元素
//        }
//        // 这里right和left都可以
//        return nums[right] == target? left: -1;
//    }
}