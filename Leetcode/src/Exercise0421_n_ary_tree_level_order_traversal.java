import java.util.LinkedList;
import java.util.List;

public class Exercise0421_n_ary_tree_level_order_traversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 使用递归求解，不是层次遍历，但是可以不同顺序添加到list<List<Integer>>中，来输出层序遍历序列
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        function(root, 0, list);
        return list;
    }

    private void function(Node root, int level, List<List<Integer>> list) {
        if (root == null)
            return;
        if (list.size() <= level)  //size从1开始，level从0开始(因为list索引从1开始)
            list.add(new LinkedList());
        list.get(level).add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                function(node, level + 1, list);
            }
        }
    }

    // // O(n)、O(n)：正常求解，使用队列
    // // 使用队列，空间复杂度取决于树的宽度
    // public List<List<Integer>> levelOrder(Node root) {
    //     Deque<Node> queue = new LinkedList<>();
    //     List<List<Integer>> list = new LinkedList<>();
    //     if (root == null)
    //         return list;
    //     queue.addLast(root);
    //     while (!queue.isEmpty()) {
    //         int currentLevelNum = queue.size();
    //         List<Integer> currentLevelList = new LinkedList<>();
    //         for (int i = 0; i < currentLevelNum; i++) {
    //             root = queue.removeFirst();
    //             currentLevelList.add(root.val);
    //             if (root.children != null) {
    //                 queue.addAll(root.children);
    //             }
    //         }
    //         list.add(currentLevelList);
    //     }
    //     return list;
    // }
}