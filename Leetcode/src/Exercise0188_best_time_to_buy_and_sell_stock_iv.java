public class Exercise0188_best_time_to_buy_and_sell_stock_iv {
    //动态规划：状态机解法 (107ms)
    //原始状态转移方程：
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //根据题意优化的状态转移方程：(k最大k)
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //边界条件比较多：
    //①类：dp[0][][]
    //②类：dp[][0][]
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        int maxK = k;
        //存放当前最大利润，索引1为当前天数，索引2为当天结束后的状态，0为未持有，1为持有
        int[][][] dp = new int[prices.length][maxK + 1][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0][0] = 0;
                dp[0][0][1] = Integer.MIN_VALUE; //不可能出现的情况
                for (int j = 1; j <= maxK; j++) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                }
            } else {
                for (int j = 0; j <= maxK; j++) {
                    if (j == 0) {
                        dp[i][0][0] = 0;
                        dp[i][0][1] = Integer.MIN_VALUE;
                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }
        }
        return dp[prices.length - 1][maxK][0];
    }
}