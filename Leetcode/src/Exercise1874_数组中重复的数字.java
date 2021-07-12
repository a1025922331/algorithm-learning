public class Exercise1874_数组中重复的数字 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i) {
                    if (nums[nums[i]] == nums[i])
                        return nums[i];
                    else {
                        int temp = nums[i];
                        nums[i] = nums[nums[i]];
                        nums[temp] = temp;
                    }
                }
            }
            return 0;
        }
    }
}
