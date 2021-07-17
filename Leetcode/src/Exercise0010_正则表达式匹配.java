import java.util.regex.Pattern;

public class Exercise0010_正则表达式匹配 {

    public static void main(String[] args) {
        Exercise0010_正则表达式匹配 sulution = new Exercise0010_正则表达式匹配();
        System.out.println(sulution.isMatch("aa", "a*"));
    }

    // 动态规划：详情见oneNote
    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        // 边界条件
        dp[0][0] = true;
        for (int j = 1; j <= s.length(); j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= p.length(); i++) {
            char c = pattern[i - 1];
            if (c == '.') {
                dp[i][0] = false;
            } else if (c == '*') {
                dp[i][0] = dp[i - 2][0];
            } else {
                dp[i][0] = false;
            }
        }

        // 状态转移方程
        for (int i = 1; i < p.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                char c = pattern[i - 1];
                if (c == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c == '*'){
                    // 匹配0个的情况 || 匹配1个的情况
                    dp[i][j] = dp[i - 2][j] || ((pattern[i - 2] == chars[j - 1]
                            || pattern[i - 2] == '.') && dp[i][j - 1]);
                } else {
                    dp[i][j] = c == chars[j - 1] && dp[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }

        return dp[p.length()][s.length()];
    }


    public boolean isMatch1(String s, String p) {
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();

        return method(chars, pattern, s.length() - 1, p.length() - 1);
    }

    private boolean method(char[] chars, char[] pattern, int i, int j) {
        while (i >= 0 || j >= 0) {
            if (j >= 0) {
                if (pattern[j] == '.') {
                    if (i < 0) {
                        return false;
                    }
                    i--;
                    j--;
                } else if (pattern[j] >= 'a' && pattern[j] <= 'z') {
                    if (i < 0 || chars[i] != pattern[j]) {
                        return false;
                    }
                    i--;
                    j--;
                } else {
                    boolean result = false;
                    char c = pattern[j - 1];
                    if (method(chars, pattern, i, j -2)) {
                        return true;
                    }
                    for (int k = i; k >= 0  ; k--) {
                        if (c == '.' || chars[k] == c) {
                            if (method(chars, pattern, k - 1, j - 2)) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                    return result;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}