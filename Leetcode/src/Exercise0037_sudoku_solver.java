import java.util.ArrayList;
import java.util.List;

public class Exercise0037_sudoku_solver {
    boolean[][] columns = new boolean[9][9];
    boolean[][] rows = new boolean[9][9];
    boolean[][] blocks = new boolean[9][9];
    List<int[]> needFill = new ArrayList<>();  // 存放需要填充的空
    boolean achieve = false;

    // 递归 + 回溯
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int k = (i / 3) * 3 + j / 3; //区域号
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    columns[i][num] = rows[j][num] = blocks[k][num] = true;
                } else {
                    needFill.add(new int[]{i, j});
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int curFillNum) {
        if (needFill.size() == curFillNum) {
            achieve = true;
            return;
        }
        int i = needFill.get(curFillNum)[0];
        int j = needFill.get(curFillNum)[1];
        int k = (i / 3) * 3 + j / 3;

        for (int num = 0; num < 9 && !achieve; num++) {
            //不合法直接返回
            if (columns[i][num] || rows[j][num] || blocks[k][num]) {
                continue;
            }
            //合法则处理并下探
            columns[i][num] = rows[j][num] = blocks[k][num] = true;
            board[i][j] = (char) ('1' + num);
            dfs(board, curFillNum + 1);
            //回溯
            columns[i][num] = rows[j][num] = blocks[k][num] = false;
        }
        // 没找到合适的值填充，回溯
        return;
    }
}

// 回溯
// https://blog.csdn.net/m0_37609579/article/details/70160002