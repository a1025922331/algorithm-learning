public class Exercise0122_best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int temp;
        for (int i = 0; i < prices.length - 1; i++) {
            temp = prices[i + 1] - prices[i];
            if (temp > 0)
                maxProfit += temp;
        }
        return maxProfit;
    }
}