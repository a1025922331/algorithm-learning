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


    // 全局最大路径和
    // https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
    // 采用递归的思想，计算每一个节点的贡献值，此处贡献值意味着以该节点为根节点的子
    // 树中以该节点为起点的一条路径，使得该路径上的节点值之和最大。在计算每个节点的
    // 贡献值的同时根据左右子节点的贡献值求出当前局部最大路径和，比较更新全局最大路
    // 路和
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxGain(root);
        return max;
    }

    // 返回每个节点的贡献值的函数
    // 由于左右子树可能为空或者贡献值为负，因此需要取所有情况中的最大值
    // 贡献值的计算，max(左子树贡献值 + 根节点的值，右子树贡献值 + 根节点的值，根节点的值（左右为负的情况下）)
    // 最大路径和计算，max(左，右，中，左+中，右+中，左+中+右) (因为任何一个都有可能为负)
    private int maxGain(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxGain(root.left), right = maxGain(root.right);
        // 更新全局最大，可能的6种组合()
        if (root.left != null) max = Math.max(max, left);
        if (root.right != null) max = Math.max(max, right);
        max = Math.max(max, root.val);
        max = Math.max(max, root.val + left);
        max = Math.max(max, root.val + right);
        max = Math.max(max, left + root.val + right);
        int val = Math.max(Math.max(left, right) + root.val, root.val);
        return val;
    }
}