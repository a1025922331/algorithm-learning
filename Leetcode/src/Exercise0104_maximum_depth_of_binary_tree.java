import java.util.Deque;
import java.util.LinkedList;

public class Exercise0104_maximum_depth_of_binary_tree {
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

//    // 递归，深度优先
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }

    // 广度优先，算有多少层
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return depth;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.removeFirst();
                if (root.left != null)
                    queue.addLast(root.left);
                if (root.right != null)
                    queue.addLast(root.right);
            }
            depth++;
        }
        return depth;
    }
}