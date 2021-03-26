public class Exercise0062_unique_paths {
    // // 动态规划（自底向上）
    // // 状态方程：map[i][j] = map[i+1][j] + map[i][j+1]
    // // 存储该点到终点有多少条路
    // public int uniquePaths(int m, int n) {
    //     int[][] map = new int[m][n];
    //     for (int i = 0; i < m; i++) map[i][n - 1] = 1;
    //     for (int j = 0; j < n; j++) map[m - 1][j] = 1;
    //     for (int i = m - 2; i >= 0; i--) {
    //         for (int j = n - 2; j >= 0; j--) {
    //             map[i][j] = map[i + 1][j] + map[i][j + 1];
    //             // System.out.println(i+","+j+","+map[i][j]);
    //         }
    //     }
    //     return map[0][0];
    // }

    // 空间上进行优化,仅使用一个数组即可
    public int uniquePaths(int m, int n) {
        int[] map = new int[n];
        for (int j = 0; j < n; j++) map[j] = 1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                map[j] = map[j] + map[j + 1];
                // System.out.println(i+","+j+","+map[i][j]);
            }
        }
        return map[0];
    }
}