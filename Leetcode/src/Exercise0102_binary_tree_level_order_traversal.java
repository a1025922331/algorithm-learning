import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Exercise0102_binary_tree_level_order_traversal {
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

    // 每个while循环遍历一层，先统计一下当前队列中的结点数来确定当前层有多少个结点
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            //当前层有多少个结点
            int num = queue.size();
            List<Integer> currentLevelList = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                root = queue.removeFirst();
                currentLevelList.add(root.val);
                if (root.left != null)
                    queue.addLast(root.left);
                if (root.right != null)
                    queue.addLast(root.right);
            }
            result.add(currentLevelList);
        }
        return result;
    }

    // // 简单版：不分层输出
    // public List<Integer> levelOrder(TreeNode root) {
    //     Deque<TreeNode> queue = new LinkedList<>();
    //     List<Integer> list = new LinkedList<>();
    //     if (root == null)
    //         return list;
    //     queue.addLast(root);
    //     while (!queue.isEmpty()) {
    //         root = queue.removeFirst();
    //         list.add(root.val);
    //             if (root.left != null)
    //                 queue.addLast(root.left);
    //             if (root.right != null)
    //                 queue.addLast(root.right);
    //     }
    //     return list;
    // }

    // // 每次入队时存储结点所在层数和结点本身，所在层数为父亲结点+1，遍历时通过哈希来将同一层的结点归类
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     Deque<Object[]> queue = new LinkedList<>();
    //     HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    //     List<List<Integer>> result = new LinkedList<>();
    //     if (root == null)
    //         return result;
    //     queue.addLast(new Object[]{new Integer(0), root});
    //     while (!queue.isEmpty()) {
    //         Object[] objectArray = queue.removeFirst();
    //         TreeNode node = (TreeNode)objectArray[1];
    //         if (!hashMap.containsKey(objectArray[0]))
    //             hashMap.put((Integer)objectArray[0], new ArrayList<Integer>());
    //         hashMap.get(objectArray[0]).add(node.val);
    //         if (node.left != null) {
    //             queue.addLast(new Object[]{(Integer)(((Integer)objectArray[0]).intValue() + 1), node.left});
    //         }
    //         if (node.right != null) {
    //             queue.addLast(new Object[]{(Integer)(((Integer)objectArray[0]).intValue() + 1), node.right});
    //         }
    //     }

    //     for (int i = 0; i < hashMap.size(); i++) {
    //         result.add(hashMap.get(new Integer(i)));
    //     }
    //     return result;
    // }
}