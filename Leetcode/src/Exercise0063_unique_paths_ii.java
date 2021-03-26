import java.util.Arrays;

public class Exercise0063_unique_paths_ii {
//    // 可优化，不用先赋值最后列和最下行
//    // 另外，这是从后往前算，可以改为从前往后算，见题2
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid == null)
//            return 0;
//        int row = obstacleGrid.length, column = obstacleGrid[0].length;
//        int[][] map = new int[row][column];
//        for (int i = row - 1; i >= 0; i--) {
//            if (obstacleGrid[i][column - 1] != 1)
//                map[i][column - 1] = 1;
//            else
//                break;
//        }
//        for (int j = column - 1; j >= 0; j--) {
//            if (obstacleGrid[row - 1][j] != 1)
//                map[row - 1][j] = 1;
//            else
//                break;
//        }
//        for (int i = row - 2; i >= 0; i--) {
//            for (int j = column - 2; j >= 0; j--) {
//                if (obstacleGrid[i][j] != 1)
//                    map[i][j] = map[i][j + 1] + map[i + 1][j];
//                else
//                    map[i][j] = 0;
//            }
//        }
//        return map[0][0];
//    }

    // 从前往后
    // 保存从起点到指定点的路径数
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null)
            return 0;
        int row = obstacleGrid.length, column = obstacleGrid[0].length;
        int[] map = new int[column]; //滚动数组，降低空间复杂度
        map[0] = 1; //先不考虑原点是否有障碍物，后面会判断
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (obstacleGrid[i][j] == 1)
                    map[j] = 0;
                else if (j >= 1) // 第一列不需要计算，在前面判断了
                    map[j] += map[j - 1];
            }
        }
        return map[column - 1];
    }
}