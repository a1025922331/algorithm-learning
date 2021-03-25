import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise0529_minesweeper {
    int[] di = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dj = {-1, -1, -1, 0, 0, 1, 1, 1};

    // DFS
    // 时间复杂度：O(mn) 因为不会重复访问
    // 空间复杂度：最坏情况O(mn)
    public char[][] updateBoard(char[][] board, int[] click) {
        char current = board[click[0]][click[1]];
        if (current == 'M')
            board[click[0]][click[1]] = 'X';
        else if (current == 'E')
            DFS(board, click[0], click[1]);
        return board;
    }

    private void DFS(char[][] board, int i, int j) {
        int count = 0;
        board[i][j] = 'B'; // 设置为临时值，表示visit过了
        // 在实际测试中发现，再遍历一遍比保存下来的效率要高
        List<int[]> list = new ArrayList<>(); // 保存可以下探的坐标
        // 先统计一下周围有多少个雷，有哪些空地还没扫描过
        for (int k = 0; k < 8; k++) {
            int newI = i + di[k];
            int newJ = j + dj[k];
            if (newI < 0 || newI >= board.length || newJ < 0 || newJ >= board[0].length)
                continue;
            if (board[newI][newJ] == 'M')
                count++;
            else if (board[newI][newJ] == 'E') {
                list.add(new int[]{newI, newJ});
            }
        }
        // 如果周围有雷的话则停止往外下探，直接返回
        if (count != 0) {
            board[i][j] = (char) ('0' + count);
            return;
        }
        // 若周围安全，则继续下探
        for (int[] loc : list) {
            DFS(board, loc[0], loc[1]);
        }
    }
}