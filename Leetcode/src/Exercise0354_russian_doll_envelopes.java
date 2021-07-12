import java.util.Arrays;
import java.util.Comparator;

public class Exercise0354_russian_doll_envelopes {
    // 首先我们将所有的信封按照 w 值第一关键字升序、hh 值第二关键字降序进行排序
    // 随后我们就可以忽略 w 维度，求出 h 维度的最长严格递增子序列，其长度即为答案
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]? o2[1] - o1[1]: o1[0] - o2[0];
            }
        });
        int[] mslLength = new int[envelopes.length];

        Arrays.fill(mslLength, 1);
        int max = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    if (mslLength[j] + 1 > mslLength[i]) { //更新最长递增子序列
                        mslLength[i] = mslLength[j] + 1;
                    }
                }
            }
            max = Math.max(max, mslLength[i]);
        }
        return max;
    }
    // 还可看看该题目的方法3:维护单增序列，及其优化二分查找
    // https://leetcode-cn.com/problems/russian-doll-envelopes/solution/jin-zhi-tao-wa-tu-jie-guo-cheng-by-zaozh-rubf/

}