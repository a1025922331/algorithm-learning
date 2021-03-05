import java.util.LinkedList;
import java.util.List;

public class Exercise0094_binary_tree_inorder_traversal {
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

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorder(root,list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
        return;
    }

    // // 非递归
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     Deque<TreeNode> deque= new LinkedList<>();
    //     List<Integer> list = new LinkedList<>();
    //     while (root != null || !deque.isEmpty()) {
    //         while (root != null) {
    //             deque.push(root);
    //             root = root.left;
    //         }
    //         //此时已经到了最左边
    //         root = deque.pop();
    //         //访问该结点
    //         list.add(root.val);
    //         root = root.right;
    //     }
    //     return list;
    // }
}
