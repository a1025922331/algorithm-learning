import java.util.Arrays;

public class Exercise0322_coin_change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1; //最大值
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }
}
// 1. 层次遍历，谁先减到0就是最短的
// 2. 动态规划，子问题：dp[i] = min (dp[i-x]...) + 1，x∈coins
//                   每个元素保存，当前金额最小币数，初始值为amount + 1，如果大于amount则说明无效，应当返回-1