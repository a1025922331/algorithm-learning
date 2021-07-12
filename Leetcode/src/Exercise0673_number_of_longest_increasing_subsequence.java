import java.util.Arrays;

public class Exercise0673_number_of_longest_increasing_subsequence {
    //动态规划：
    //题解：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/dong-tai-gui-hua-dong-tu-fu-zhu-li-jie-ru-you-bang/

    // dp数组1：存放以当前元素为结尾的最长递增子序列的长度
    // dp数组2：存放以当前元素为结尾的最长递增子序列的组合数
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] lisLength = new int[nums.length];
        int[] lisCount = new int[nums.length];

        //初始条件，都为1
        Arrays.fill(lisLength, 1);
        Arrays.fill(lisCount, 1);

        //
        int maxLength = 1;
        int maxCount = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //当nums[j] < nums[i]时，dp[i]可以更新
                if (nums[j] < nums[i]) {
                    //第一次见这个长度的子序列
                    if (lisLength[j] + 1 > lisLength[i]) {
                        lisLength[i] = lisLength[j] + 1;
                        lisCount[i] = lisCount[j];
                    } else if (lisLength[j] + 1 == lisLength[i]) { //之前见过这么长的序列，此处新见到，更新组合数
                        lisCount[i] += lisCount[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, lisLength[i]);
        }

        //统计组合数
        for (int i = 0; i < nums.length; i++) {
            if (maxLength == lisLength[i]) {
                maxCount += lisCount[i];
            }
        }
        return maxCount;
    }
}