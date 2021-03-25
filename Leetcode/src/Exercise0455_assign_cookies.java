import java.util.Arrays;

public class Exercise0455_assign_cookies {
    // 优先满足最小胃口的孩子
    public int findContentChildren(int[] g, int[] s) {
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0, i = 0, j = 0;
        // 遍历
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}