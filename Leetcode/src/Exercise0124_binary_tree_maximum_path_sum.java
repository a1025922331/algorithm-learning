public class Exercise0124_binary_tree_maximum_path_sum {
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


    private Integer max;

    public int maxPathSum(TreeNode root) {
        // 全局最大路径和
        max = Integer.MIN_VALUE;
        maxPathBranchSum(root);
        return max;
    }

    // 计算包含当前结点的最大路径分支，即还可向上生长的路径
    private int maxPathBranchSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathBranchSum(root.left);
        int right = maxPathBranchSum(root.right);
        // 左中右完整路径，不再向上生长的路径
        int fullPath = left + root.val + right;
        // 包含当前结点的最大路径分支，即还可向上生长的路径
        int branchPath = root.val + Math.max(0, Math.max(left, right));
        // 维护全局最大路径和
        max = Math.max(max, Math.max(fullPath, branchPath));
        return branchPath;
    }
}