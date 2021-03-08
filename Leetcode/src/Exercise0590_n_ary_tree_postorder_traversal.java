import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Exercise0590_n_ary_tree_postorder_traversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    // 迭代
    public List<Integer> postorder(Node root) {
        Deque<Node> stack = new LinkedList<>();
        Deque<Integer> list = new LinkedList<>();
        if (root == null)
            return new ArrayList();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.addFirst(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    stack.push(node);
                }
            }
        }
        return new ArrayList(list);
    }

    // // 递归
    // public List<Integer> postorder(Node root) {
    //     List<Integer> list = new ArrayList<>();
    //     function(root, list);
    //     return list;
    // }

    // private void function(Node root, List<Integer> list) {
    //     if (root != null) {
    //         for (Node node : root.children) {
    //             function(node, list);
    //         }
    //         list.add(root.val);
    //     }
    //     return;
    // }
}
