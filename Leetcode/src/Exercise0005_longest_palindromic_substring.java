/**
 * @Author: guozexin.gzx
 * @Date: 2021/7/12
 */
public class Exercise0005_longest_palindromic_substring {

    // 2021/07/13
    // 时间复杂度O(n^2)， 看到题目字符串长度最长为1000，才觉得n方可行
    // 9ms，95.5%
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int max1 = 0;
        int max2 = 0;
        int mid1 = 0;
        int mid2 = 0;
        // 情形1：最长回文数长度为奇数
        for (int i = 0; i < chars.length; i++) {
            int localMax = 1;
            int step = 1;
            while ((i - step) >= 0 &&
                    (i + step) < chars.length &&
                    chars[i - step] == chars[i + step]) {
                step++;
                localMax += 2;
            }
            if (max1 < localMax) {
                max1 = localMax;
                mid1 = i;
            }
        }
        // 情形2: 最长回文数长度为偶数
        for (int i = 1; i < chars.length; i++) {
            int localMax = 0;
            int step = 1;
            while ((i - step) >= 0 &&
                    (i + step - 1) < chars.length &&
                    chars[i - step] == chars[i + step - 1]) {
                step++;
                localMax += 2;
            }
            if (max2 < localMax) {
                max2 = localMax;
                mid2 = i;
            }
        }
        if (max1 > max2) {
            return s.substring(mid1 - (max1 - 1) / 2, mid2 - (max1 - 1) / 2 + 1);
        } else {
            return s.substring(mid2 - max2 / 2, mid2 + max2 / 2);
        }
    }
}