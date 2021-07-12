public class Exercise0309_best_time_to_buy_and_sell_stock_with_cooldown {
    //动态规划：状态机解法 (5ms)
    //原始状态转移方程：
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //根据题意优化的状态转移方程：(k不受限制，因此直接取无穷，省去了一个维度)
    //dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
    //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
    public int maxProfit(int[] prices) {
        //存放当前最大利润，索引1为当前天数，索引2为当天结束后的状态，0为未持有，1为持有
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
            } else if (i == 1) {
                dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
                dp[1][1] = Math.max(dp[0][1], - prices[1]);
            }else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }
}