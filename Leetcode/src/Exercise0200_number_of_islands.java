public class Exercise0200_number_of_islands {
    //深度优先，遍历二维网格，用深度优先搜索把岛屿炸掉，同时统计铲了多少个岛屿
    public int numIslands(char[][] grid) {
        int num = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    floodfill(x, y, dx, dy, grid);
                    num += 1;
                }
            }
        }
        return num;
    }

    private void floodfill(int x, int y, int[] dx, int[] dy, char[][] grid) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < grid.length && newX >= 0 && newY < grid[0].length && newY >= 0
                    && grid[newX][newY] == '1')
                floodfill(newX, newY, dx, dy, grid);
        }
    }
}