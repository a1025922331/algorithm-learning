import java.util.Arrays;

public class Exercise0213_house_robber_ii {
    public int rob(int[] nums) {
        int len = nums.length;
        //边界处理
        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0], nums[1]);
        //dp数组
        int[][] dp = new int[2][len]; //0为第一个房间不偷，1为第一个房间偷
        //边界
        dp[0][0] = 0;
        dp[0][1] = nums[1];
        dp[1][0] = nums[0];
        dp[1][1] = dp[1][0];
        //中间过程
        for (int i = 2; i < len - 1; i++) {
            //第一个房间不偷
            dp[0][i] = Math.max(dp[0][i - 2] + nums[i], dp[0][i - 1]);
            //第一个房间偷
            dp[1][i] = Math.max(dp[1][i - 2] + nums[i], dp[1][i - 1]);
        }
        //最后一个结点单独处理
        int end = len - 1;
        dp[0][end] = Math.max(dp[0][end - 2] + nums[end], dp[0][end - 1]);
        dp[1][end] = dp[1][end - 1];
        return Math.max(dp[0][end], dp[1][end]);
    }
}
// 动态规划1
// 分两种情况讨论：第一个房间不偷，第二个房间偷
// dp数组：dp[i][2], [0]表示不偷，[1]表示偷，分别求最大
