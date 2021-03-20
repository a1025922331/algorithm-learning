import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
p
public class Exercise0051_n_queens {
    // 回溯法求解
    // 时间复杂度：O(n!)
    // 空间复杂度：O(n)
    // 主要思想：枚举并剪枝叶。在每一行放入一个queen，并判断是否会符合规则，不符合直接回溯
    // 重点：如何在O(1)的时间内判断处是否符合规则？
    // 可以利用哈希表解决，找出同一列，同一左斜线，同一右斜线所具备的共同特征假设棋局上每一个格子的坐标为(i,j)，
    // 则同一列的j相同，同一左斜线的i+j相同，同一右斜线的i-j相同，因此可以分别构建三个hashset，并把上述值当作
    // key，因此在判断时直接查询对于哈希表是否存在该值即可，查询时间复杂度为O(1)
    // https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode-solution/

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];      //存放每一行queen的位置
        Arrays.fill(queens, -1);
        HashSet<Integer> columns = new HashSet<>();         //保存所有存在queen的列
        HashSet<Integer> leftDiagonal = new HashSet<>();    //保存所有存在queen的左斜线
        HashSet<Integer> rightDiagonal = new HashSet<>();   //保存所有存在queen的右斜线
        backTracking(result, queens, columns, leftDiagonal, rightDiagonal, n, 0);
        return result;
    }

    private void backTracking(List<List<String>> result, int[] queens, HashSet<Integer> columns, HashSet<Integer> leftDiagonal, HashSet<Integer> rightDiagonal, int n, int i) {
        // 边界条件 (i为当前要添加queen的行号)
        if (i == n) {
            generateList(result, queens, n);
            return;
        }
        // 遍历所有可能，添加当前行的queen
        for (int j = 0; j < n; j++) {
            // 判断是否符合列规则
            if (columns.contains(j)) continue;
            // 判断是否符合左斜线规则
            if (leftDiagonal.contains(i + j)) continue;
            // 判断是否符合右斜线规则
            if (rightDiagonal.contains(i - j)) continue;
            // 符合条件，可以插入
            queens[i] = j;
            columns.add(j);
            leftDiagonal.add(i + j);
            rightDiagonal.add(i - j);
            // 下探
            backTracking(result, queens, columns, leftDiagonal, rightDiagonal, n, i + 1);
            // 撤回操作，继续尝试
            queens[i] = -1;
            columns.remove(j);
            leftDiagonal.remove(i + j);
            rightDiagonal.remove(i - j);
        }
    }

    private void generateList(List<List<String>> result, int[] queens, int n) {
        List<String> list = new ArrayList<>();
        for (int i : queens) {
            char[] cArray = new char[n];
            Arrays.fill(cArray, '.');
            cArray[i] = 'Q';
            list.add(new String(cArray));
        }
        result.add(list);
    }
}