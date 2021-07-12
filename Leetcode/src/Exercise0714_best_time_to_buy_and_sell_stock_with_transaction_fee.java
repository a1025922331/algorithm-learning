import java.util.Arrays;

public class Exercise0714_best_time_to_buy_and_sell_stock_with_transaction_fee {
//    //动态规划：状态机解法 (23ms)
//    //原始状态转移方程：
//    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
//    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
//    //根据题意优化的状态转移方程：(k不受限制，因此直接取无穷，省去了一个维度)
//    //dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//    //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//    public int maxProfit(int[] prices, int fee) {
//        //存放当前最大利润，索引1为当前天数，索引2为当天结束后的状态，0为未持有，1为持有
//        int[][] dp = new int[prices.length][2];
//        for (int i = 0; i < prices.length; i++) {
//            if (i == 0) {
//                dp[0][0] = 0;
//                dp[0][1] = -prices[0] - fee;
//            } else {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
//            }
//        }
//        return dp[prices.length - 1][0];
//    }

    //贪心算法：维护截至目前最低的买入价（含手续费）
    //此外，如果当日股价大于minBuy的时候，即直接卖出，且更新minBuy为当前股价
    //因此如果后面一天也持续上涨的话我们就不用再多付手续费了
    //上面的贪心思想可以浓缩成一句话，即当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int minBuy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            // 当前有收益，马上入账
            if (minBuy < prices[i]) {
                profit += prices[i] - minBuy;
                minBuy = prices[i]; //留一手
            } else if (prices[i] + fee < minBuy) { // 当前遇到了更小的买入价
                minBuy = prices[i] + fee;
            }
        }
        return profit;
    }
}