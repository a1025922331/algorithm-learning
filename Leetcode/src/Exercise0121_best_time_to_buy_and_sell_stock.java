public class Exercise0121_best_time_to_buy_and_sell_stock {
    // 遍历日期，维护最低股价和当前最高可能收益
    // 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            int temp = price - minPrice;
            minPrice =  temp < 0 ? price: minPrice;
            maxProfit = temp > maxProfit ? temp: maxProfit;
        }
        return maxProfit;
    }
}