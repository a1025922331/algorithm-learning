/**
 * @Author: guozexin.gzx
 * @Date: 2021/7/12
 */
public class Exercise0005_longest_palindromic_substring {
    // 动态规划,85ms,59.25%
    // 可以进行状态转移，若左右两边相同，则看中间
    // 状态：dp[i,j]表示s(i,j)是否为回文子串，i左起始点，j右起始点
    // 状态转移方程：dp[i,j] = s[i] == s[j] AND (j - i = 1 || dp[i + 1, j - 1])
    // 边界：若i = j，则dp[i,j] = true
    // 遍历的时候同时维护最长字串起始点和长度
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (chars[i] == chars[j] && (j - i == 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // 中心扩散法：枚举中心。n < 1000,9ms,95%
    // O(n^2)、O(1)
    public String longestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int max1 = 0;
        int max2 = 0;
        int mid1 = 0;
        int mid2 = 0;
        // 情形1: 奇数回文子串
        for (int i = 0; i < chars.length; i++) {
            int localMax = 1;
            int step = 1;
            while ((i - step) >= 0 && (i + step) < chars.length && chars[i - step] == chars[i + step]) {
                step++;
                localMax += 2;
            }
            if (max1 < localMax) {
                max1 = localMax;
                mid1 = i;
            }
        }
        // 情形2: 偶数回文子串
        for (int i = 1; i < chars.length; i++) {
            int localMax = 0;
            int step = 1;
            while ((i - step) >= 0 && (i + step - 1) < chars.length && chars[i - step] == chars[i + step - 1]) {
                step++;
                localMax += 2;
            }
            if (max2 < localMax) {
                max2 = localMax;
                mid2 = i;
            }
        }
        if (max1 > max2) {
            return s.substring(mid1 - (max1 - 1) / 2, mid1 + (max1 - 1) / 2 + 1);
        } else {
            return s.substring(mid2 - max2 / 2, mid2 + max2 / 2);
        }
    }
}