public class Exercise0121_best_time_to_buy_and_sell_stock {
//    // 遍历日期，维护最低股价 (2ms)
//    // dp数组存放截止当前日的最大收益
//    // 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int minPrice = Integer.MAX_VALUE;
//        for (int price : prices) {
//            int temp = price - minPrice;
//            minPrice =  temp < 0 ? price: minPrice;
//            maxProfit = temp > maxProfit ? temp: maxProfit;
//        }
//        return maxProfit;
//    }

    //动态规划：状态机解法 (34ms)
    //原始状态转移方程：
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //根据题意优化的状态转移方程：
    //dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
    //dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
    public int maxProfit(int[] prices) {
        //存放当前最大利润，索引1为当前天数，索引2为当天结束后的状态，0为未持有，1为持有
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }
}