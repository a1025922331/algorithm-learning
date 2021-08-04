import java.util.*;

public class Exercise0039_组合总数 {
    public static void main(String[] args) {
        Exercise0039_组合总数 solution = new Exercise0039_组合总数();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, list, result);
        return new ArrayList<>(result);
    }

    private void dfs(int[] candidates, int target, int cur, int sum, List<Integer> list, Set<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = cur; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                    list.add(candidates[i]);
                    dfs(candidates, target, i, sum + candidates[i], list, result);
                    list.remove(list.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
