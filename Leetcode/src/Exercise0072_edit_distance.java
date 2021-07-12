public class Exercise0072_edit_distance {
    // 动态规划，自底向上，从两个空字符串开始
    // dp方程的元素表示，当前字符串1和当前字符串2要经过多少步的操作才能相等（可以理解为两个都变为空）
    // 状态变化方程：if s1[i] == s2[j], 那么dp[i][j] = dp[i - 1][j - 1]
    //             if s1[i] != s2[j], 那么dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
    // dp[i - 1][j] 表示删除字符串1的最后一个字符
    // dp[i][j - 1] 表示删除字符串2的最后一个字符
    // dp[i - 1][j - 1] 表示将字符串1的最后一个字符修改成字符串2的最后一个字符，并抵消
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = i;
        for (int j = 0; j < dp[0].length; j++) dp[0][j] = j;
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}