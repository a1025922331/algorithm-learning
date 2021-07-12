import java.util.List;

public class Exercise0120_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }
}

// 每个结点保存该点到底部的最小路径，从下往上走
// 子问题：f(i,j) = min(f(i+1,j), f(i+1,j+1)) + triangle[i][j]
// dp数组：滑动数组dp
// dp方程：dp[j] = min(dp[j], dp[j+1]) + triangle[i][j]