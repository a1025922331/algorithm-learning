public class Exercise0070_climbing_stairs {
    // 数学归纳法
    // N1：1
    // N2：2
    // N3：N1 + N2

    // // 傻递归:超出时间限制，O(n^2)
    // public int climbStairs(int n) {
    //     if (n == 1 || n == 2)
    //         return n;
    //     else
    //         return climbStairs(n - 1) + climbStairs(n - 2);
    // }

    // // 递归 + 缓存 O(n) 0ms
    // public int climbStairs(int n) {
    //     if (n == 1 || n == 2)
    //         return n;
    //     int[] cache = new int[n + 1];
    //     cache[1] = 1;
    //     cache[2] = 2;
    //     calculateN(n, cache);
    //     return cache[n];
    // }

    // private void calculateN(int n, int[] cache) {
    //     if (cache[n - 1] == 0)
    //         calculateN(n - 1, cache);
    //     if (cache[n - 2] == 0)
    //         calculateN(n - 2, cache);
    //     cache[n] = cache[n - 1] + cache[n - 2];
    //     return;
    // }

    // 迭代
    public int climbStairs(int n) {
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}