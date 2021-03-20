import java.util.ArrayList;
import java.util.List;

public class Exercise0433_minimum_genetic_mutation {
    // DFS回溯：
    // 因为每次变化必须合法，因此可以从bank中取一个只相差一个元素的string做为当前变化并进入下一层递归。
    // 时间复杂度: O(k * len(bank)^2)
    // 空间复杂度: O(len(bank))
    public int minMutation(String start, String end, String[] bank) {
        boolean[] hasVisited = new boolean[bank.length];
        int minStep[] = {Integer.MAX_VALUE}; //仅用0索引来存放最小值，方便做为形参进行修改
        dfs(start, end, bank, hasVisited, 0, minStep);
        return minStep[0] == Integer.MAX_VALUE ? -1: minStep[0];
    }

    private void dfs(String start, String end, String[] bank, boolean[] hasVisited, int step, int[] minStep) {
        if (step >= minStep[0]) //剪枝
            return;
        if (start.equals(end)) {
            minStep[0] = Math.min(minStep[0], step);
        }
        for (int i = 0; i < bank.length; i++) {
            if (!hasVisited[i] && isValid(start, bank[i])) {
                hasVisited[i] = true;
                dfs(bank[i], end, bank, hasVisited, step + 1, minStep); //下探
                hasVisited[i] = false;  // 回溯
            }
        }
    }

    private boolean isValid(String s1, String s2) {
        int numDif = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                numDif++;
        }
        return numDif == 1;
    }
}