import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Exercise0144_binary_tree_preorder_traversal {
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
    // //递归
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new LinkedList<>();
    //     preorder(root,list);
    //     return list;
    // }

    // private void preorder(TreeNode root, List<Integer> list) {
    //     if (root != null) {
    //         list.add(root.val);
    //         preorder(root.left, list);
    //         preorder(root.right, list);
    //     }
    // }

    // //迭代
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     Deque<TreeNode> deque = new LinkedList<>();
    //     while (root != null || !deque.isEmpty()) {
    //         while (root != null) {
    //             list.add(root.val);
    //             deque.push(root);
    //             root = root.left;
    //         }
    //         root = deque.pop();
    //         root = root.right;
    //     }
    //     return list;
    // }

    //迭代2:N叉树也适用
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if (root == null)
            return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
        return list;
    }
}
