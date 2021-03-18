import java.util.Deque;
import java.util.LinkedList;

public class Exercise0111_minimum_depth_of_binary_tree {
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

//    // 广度优先搜索，遍历到第一个叶子结点就可以停止了
//    // 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小
//    public int minDepth(TreeNode root) {
//        int depth = 0;
//        Deque<TreeNode> queue = new LinkedList<>();
//        if (root == null)
//            return depth;
//        queue.addLast(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            depth++;
//            for (int i = 0; i < size; i++) {
//                root = queue.removeFirst();
//                if (root.left == null && root.right == null)
//                    return depth;
//                if (root.left != null)
//                    queue.addLast(root.left);
//                if (root.right != null)
//                    queue.addLast(root.right);
//            }
//        }
//        return depth;
//    }

    // 深度优先搜索, 需要遍历完才能知道结果
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftTreeDepth = minDepth(root.left);
        int rightTreeDepth = minDepth(root.right);
        // 其中一个子树为null，则深度取决于另一个子树
        if (root.left == null || root.right == null) {
            return Math.max(leftTreeDepth, rightTreeDepth) + 1;
        }
        return Math.min(leftTreeDepth, rightTreeDepth) + 1;
    }
}
