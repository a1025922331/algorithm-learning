import java.util.*;

public class Exercise0039_组合总数 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 先排序便于后续剪枝
        Arrays.sort(candidates);
        dfs(candidates, target, 0, list, result);
        return result;
    }

    private void dfs(int[] candidates, int target, int cur, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = cur; i < candidates.length; i++) {
                // 剪枝
                if (candidates[i] <= target) {
                    list.add(candidates[i]);
                    dfs(candidates, target - candidates[i], i, list, result);
                    list.remove(list.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}

