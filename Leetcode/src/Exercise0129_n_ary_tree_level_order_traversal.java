import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Exercise0129_n_ary_tree_level_order_traversal {
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

    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int currentLevelNum = queue.size();
            List<Integer> currentLevelList = new LinkedList<>();
            for (int i = 0; i < currentLevelNum; i++) {
                root = queue.removeFirst();
                currentLevelList.add(root.val);
                if (root.children != null) {
                    for (Node node : root.children)
                        queue.addLast(node);
                }
            }
            list.add(currentLevelList);
        }
        return list;
    }
}
