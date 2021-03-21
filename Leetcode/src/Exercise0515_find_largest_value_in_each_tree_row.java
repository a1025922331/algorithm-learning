import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Exercise0515_find_largest_value_in_each_tree_row {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//    // BFS
//    public List<Integer> largestValues(TreeNode root) {
//        Deque<TreeNode> queue = new LinkedList<>();
//        List<Integer> result = new LinkedList<>();
//        if (root != null) queue.addLast(root);
//        while (!queue.isEmpty()) {
//            int currentLevelNum = queue.size();
//            int max = Integer.MIN_VALUE;
//            for (; currentLevelNum > 0; currentLevelNum--) {
//                root = queue.removeFirst();
//                max = Math.max(root.val, max);
//                if (root.left != null) queue.addLast(root.left);
//                if (root.right != null) queue.addLast(root.right);
//            }
//            result.add(max);
//        }
//        return result;
//    }

    //DFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth >= result.size()) {
            result.add(root.val);
        } else if (result.get(depth) < root.val) {
            result.set(depth, root.val);
        }
        dfs(result, root.left, depth + 1);
        dfs(result, root.right, depth + 1);
    }

}