public class Exercise0036_valid_sudoku {
    // 有效的数独
    public boolean isValidSudoku(char[][] board) {
        boolean[][] columns = new boolean[9][9];
        boolean[][] rows = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = (i / 3) * 3 + j / 3; //区域号
                    int num = board[i][j] - '1';
                    if (columns[i][num] || rows[j][num] || blocks[k][num]) {
                        return false;
                    }
                    columns[i][num] = rows[j][num] = blocks[k][num] = true;
                }
            }
        }
        return true;
    }
}