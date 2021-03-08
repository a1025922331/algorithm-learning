import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Exercise0145_binary_tree_postorder_traversal {
    private class TreeNode {
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

    //后序遍历与前序遍历的差别：左右父、父左右，因此可以考虑倒转前序
    //遍历的结果（并在遍历时倒转访问左右结点的顺序）
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> list = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return new LinkedList(list);
    }
}
