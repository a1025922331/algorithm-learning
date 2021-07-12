import javax.swing.table.TableColumn;

public class Exercise1876_li_wu_de_zui_da_jie_zhi_lcof {
//    // 动态规划：f(i,j) = max(f(i-1,j),f(i,j-1)) + grid(i,j)
//    // 采用滑动数组，记录从起点到指定格子能拿到多少价值的礼物
//    // 也可以直接在原数组上改
//    // 时间复杂度：O(mn)
//    // 空间复杂度：O(1) / O(n)
//    public int maxValue(int[][] grid) {
//        if (grid == null)
//            return 0;
//        int row = grid.length, column = grid[0].length;
//        int[] array = new int[column + 1]; //0索引不用
//        for (int i = 1; i <= row; i++) {
//            for (int j = 1; j <= column; j++) {
//                array[j] = Math.max(array[j], array[j - 1]) + grid[i - 1][j - 1];
//            }
//        }
//        return array[column];
//    }

    // 深度优先：从左上开始, 加缓存
    // 时间复杂度：O(mn)
    // 空间复杂度：O(m + n) (取决于递归栈的深度)
    public int maxValue(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int rows=grid.length;
        int columns=grid[0].length;
        int[][] values=new int[rows][columns];  // 存放改格子到终点最多可以拿多少价值的礼物
        return dfs(grid,0, 0,values);

    }

    public int dfs(int[][] grid, int i, int j, int[][] values){
        int rows=grid.length;
        int columns=grid[0].length;
        // 边界条件
        if (i == rows - 1 && j == columns - 1)
            return grid[i][j];
        if (i >= rows || j >= columns)
            return 0;

        // 查看缓存中是否有数据
        if (values[i][j] != 0)
            return values[i][j];

        // 当前层逻辑
        int right = dfs(grid, i, j + 1, values);
        int down = dfs(grid, i + 1, j, values);
        values[i][j] = Math.max(right, down) + grid[i][j];
        return values[i][j];
    }
}