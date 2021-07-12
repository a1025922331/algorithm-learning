public class Exercise0424_longest_repeating_character_replacement {
    // 双指针思想
    // 保证当前窗口内的元素能够通过变换变成同一个字符，如果满足的话右指针右移继续增长当前窗口
    // 如果不满足，则继续扩大窗口也没有意义了，则将当前窗口向右滑动一格（为了维护最大，所以小于当前窗口的就不用再考虑了）
    // 时间复杂度：O(n)
    // 空间复杂度: O(1)
    public int characterReplacement(String s, int k) {
        int longest = 0;
        char[] chars = s.toCharArray();
        int[] letters = new int[26];
        int maxIndex = 0;  //当前窗口内的主要元素
        int i = 0, j = 0;  //双指针
        while (j < chars.length) {
            //添加当前元素
            int cur = chars[j] - 'A';
            letters[cur]++;
            //更新最多的元素
            if (letters[cur] > letters[maxIndex]) {
                maxIndex = cur;
            }
            //如果当前符合条件的话则更新最大长度，且只移动右指针，继续增长当前窗口
            if (j - i + 1 - letters[maxIndex] <= k) {
                longest = j - i + 1;
                j++;
            } else { //不符合条件，平移当前窗口，左右指针都向右移动一格
                letters[chars[i] - 'A']--; //左指针右移，需要从letters中消掉i
                i++;
                j++;
            }
        }
        return longest;
    }
}
