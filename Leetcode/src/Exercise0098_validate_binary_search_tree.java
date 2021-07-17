
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Exercise0098_validate_binary_search_tree {


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

//    //1. 用迭代中序遍历来验证 (2ms,27%)
//    //O(n)
//    //O(n): 栈深，最坏情况为O(n)
//    public boolean isValidBST(TreeNode root) {
//        //中序遍历
//        int index = 0;
//        int temp = 0;
//        Deque<TreeNode> stack = new LinkedList<>();
//        while(root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (index != 0 && root.val <= temp)
//                return false;
//            index ++;
//            temp = root.val;
//            root = root.right;
//        }
//        return true;
//    }

//    //2. 用递归中序遍历来验证 (0ms,100%)
//    //O(n)
//    //O(n)：递归栈的最大深度
//    public boolean isValidBST(TreeNode root) {
//        long pre = Long.MIN_VALUE;
//        return isValidBSTMethod(root, pre);
//    }
//
//    private boolean isValidBSTMethod(TreeNode root, long pre) {
//        // 边界条件，root==null
//        if (root == null)
//            return true;
//        // 左子树是否合法
//        if (!isValidBSTMethod(root.left, pre))
//            return false;
//        // 当前节点是否大于pre
//        if (root.val <= pre)
//            return false;
//        pre = root.val;
//        // 右子树是否合法
//        return isValidBSTMethod(root.right, pre);
//    }

    //3. 从根节点往下验证，给子树划定取值范围
    //O(n)
    //O(n)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        // 终止条件
        if (root == null)
            return true;
        // 当前结点是否在限定范围
        if (root.val <= minValue || root.val >= maxValue)
            return false;
        // 子树是否在限定范围
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
}