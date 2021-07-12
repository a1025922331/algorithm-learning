public class Exercise0198_house_robber {
    // // 动态规划1：最容易理解的dp
    // public int rob(int[] nums) {
    //     if (nums.length == 1)
    //         return nums[0];
    //     int[][] dp = new int[nums.length][2]; //0不偷，1偷
    //     dp[0][0] = 0;
    //     dp[0][1] = nums[0];
    //     for (int i = 1; i < dp.length; i++) {
    //         dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
    //         dp[i][1] = dp[i - 1][0] + nums[i];
    //     }
    //     return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    // }

    // 动态规划2：
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int bt = dp[i-1];
            int t = dp[i - 2] + nums[i];
            dp[i] = Math.max(bt, t);
        }
        return dp[nums.length - 1];
    }
}
// 动态规划1：最容易理解的dp
// dp数组：[0]存储假设当前房屋不偷的累计最高金额，[1]存储假设偷当前房屋的累计最高金额
// dp方程：dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
//        dp[i][1] = dp[i - 1][0] + nums[i]

// 动态规划2：dp数组存储截止当前房间最大可以偷窃多少金额
// 偷窃第 kk 间房屋，那么就不能偷窃第 k-1k−1 间房屋，偷窃总金额为前 k-2k−2 间房屋的最高总金额与第 kk 间房屋的金额之和。
//不偷窃第 kk 间房屋，偷窃总金额为前 k-1k−1 间房屋的最高总金额。
// 边界条件：
// dp[0]=nums[0]
// dp[1]=max(nums[0],nums[1])
// dp方程：dp[i]=max(dp[i−2]+nums[i],dp[i−1])[i][1] = dp[i - 1][0] + nums[i]