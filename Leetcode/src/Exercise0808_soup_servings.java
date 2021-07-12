import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Exercise0808_soup_servings {
    // dfs + cache (>5000近似为1)
    private static HashMap<List<Integer>, Double> cache = new HashMap<>();
    public double soupServings(int N) {
        if (N >= 5000)
            return 1;
        cache.clear();
        return  dfs(N, N, 1);
    }

    private static double dfs(int a, int b, double error) {
        double p = 0;
        if (a <= 0 && b <= 0) {
            p += 0.5;
            return p;
        }
        if (a <= 0) {
            p += 1;
            return p;
        }
        else if (b <= 0) {
            return 0;
        }
        Double temp1;
        List<Integer> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        if ((temp1 = cache.get(list)) != null) {
            return temp1;
        }
        // 第一个操作
        p += 0.25 * dfs(a-100, b, error * 0.25);
        // 第二个操作
        p += 0.25 * dfs(a-75, b - 25, error * 0.25);
        // 第三个操作
        p += 0.25 * dfs(a-50, b - 50, error * 0.25);
        // 第四个操作
        p += 0.25 * dfs(a-25, b - 75, error * 0.25);
        cache.put(list, p);
        return p;
    }

//    // 动态规划 (>5000近似为1)
//    public double soupServings(int N) {
//        N = N/25 + (N%25 > 0 ? 1 : 0);
//        if (N >= 500) return 1.0;
//
//        double[][] memo = new double[N+1][N+1];
//        for (int s = 0; s <= 2*N; ++s) {
//            for (int i = 0; i <= N; ++i) {
//                int j = s-i;
//                if (j < 0 || j > N) continue;
//                double ans = 0.0;
//                if (i == 0) ans = 1.0;
//                if (i == 0 && j == 0) ans = 0.5;
//                if (i > 0 && j > 0) {
//                    ans = 0.25 * (memo[M(i-4)][j] + memo[M(i-3)][M(j-1)] +
//                            memo[M(i-2)][M(j-2)] + memo[M(i-1)][M(j-3)]);
//                }
//                memo[i][j] = ans;
//
//            }
//        }
//        return memo[N][N];
//    }
//
//    public int M(int x) { return Math.max(0, x); }
}