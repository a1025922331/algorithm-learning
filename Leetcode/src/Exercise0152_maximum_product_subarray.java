public class Exercise0152_maximum_product_subarray {
//    // 解法一：先求积，再遍历，维护负数最小和正数最小 (太慢了，且逻辑复杂)
//    public int maxProduct(int[] nums) {
//        if (nums.length == 1)
//            return nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] != 0)
//                nums[i] *= nums[i - 1];
//        }
//        int positiveMin = 1, negativeMin = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
//        for (int num : nums) {
//            if (num == 0){
//                positiveMin = 1;
//                negativeMin = Integer.MIN_VALUE;
//            } else if (num > 0){
//                max = Math.max(max, num / positiveMin);
//                positiveMin = Math.min(num, positiveMin);
//            } else {
//                max = Math.max(max, num / negativeMin);
//                negativeMin = Math.max(num, negativeMin);
//            }
//            //System.out.println(num + "," +positiveMin + "," + negativeMin + "," + max);
//        }
//        return max;
//    }

    // 解法二：动态规划
    // 维护包含当前元素的连乘积的最大值和最小值
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        // 可以简化：先判断是否为负数，为负数则调换最大最小，再统一处理
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {int temp = imax; imax = imin; imin = temp;}
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            max = Math.max(max, imax);
//            if (nums[i] > 0) {
//                imax = Math.max(nums[i], imax * nums[i]);
//                imin = Math.min(nums[i], imin * nums[i]);
//            } else if (nums[i] < 0) {
//                int temp = imax;
//                imax = Math.max(nums[i], imin * nums[i]);
//                imin = Math.min(nums[i], temp * nums[i]);
//            } else {
//                imax = 0;
//                imin = 0;
//            }
//            max = Math.max(max, imax);
        }
        return max;
    }
}

// 解法一：先求积，再遍历，维护负数最小和正数最小
// [2,3,-2,4]
// 数组multi:[2,6,-12,-48]
// 遍历，维护负数最小和正数最小，并更新最大积

// 解法二：动态规划
// 分析子问题：每一步存储截止当前元素，且包含当前元素的最大积和最小积连续子数组，并维护全局最大积
// 最小积和最大积均有可能为正或者为负
// 动态规划方程
// if (nums[i] > 0) dp[i][0] = max(nums[i], nums[i - 1][0] * nums[i])
//                  dp[i][1] = max(nums[i], nums[i - 1][1] * nums[i])
// if (nums[i] < 0) dp[i][0] = max(nums[i], nums[i - 1][1] * nums[i])
//                  dp[i][1] = max(nums[i], nums[i - 1][0] * nums[i])
// if (nums[i] = 0) dp[i][0] = 0
//                  dp[i][1] = 0

//合并：if (nums[i] < 0) {int temp = imax; imax = imin; imin = temp;}
//      imax = Math.max(nums[i], imax * nums[i]);
//      imin = Math.min(nums[i], imin * nums[i]);
