import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class Exercise1143_longest_common_subsequence {
//    //动态规划
//    //时间复杂度:mn
//    //空间复杂度:mn
//    //dp方程：
//    // if (text1[i] == text[j]) lcs[i][j] = lcs[i - 1][j - 1] + 1
//    // if (text1[i] != text[j]) lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
//    public int longestCommonSubsequence(String text1, String text2) {
//        char[] s1 = text1.toCharArray(), s2 = text2.toCharArray(); //转为字符数组更快
//        int rows = s1.length, columns = s2.length;
//        int[][] lcs = new int[rows + 1][columns + 1];
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= columns; j++) {
//                if (s1[i - 1] == s2[j - 1]) {
//                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
//                } else {
//                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
//                }
//            }
//        }
//        return lcs[rows][columns];
//    }

    //方法2：2^n，先生成两个字符串的所有的最短子序列，再比较长度
    //超时
    @Test
    public void test() {
        long point1 = System.currentTimeMillis();
        System.out.println(longestCommonSubsequence("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(System.currentTimeMillis() - point1 + "ms");
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray(), s2 = text2.toCharArray(); //转为字符数组更快
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        generateSubsequence(s1, s1.length, 0, "", set1);
        generateSubsequence(s2, s2.length, 0, "", set2);

        int max = 0;
        for (String s : set1) {
            if (set2.contains(s))
                max = Math.max(max, s.length());
        }
        return max;
    }

    private void generateSubsequence(char[] s1, int len, int cur, String s, HashSet<String> set) {
        if (cur == len) {
            set.add(s);
            return;
        }
        generateSubsequence(s1, len, cur + 1, s, set);
        generateSubsequence(s1, len, cur + 1, s + String.valueOf(s1[cur]), set);
    }
}