import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Exercise0297_serialize_and_deserialize_binary_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 先序遍历，若子树为null，则将null也存储下来
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeMethod(root, "");
    }

    private String serializeMethod(TreeNode root, String s) {
        if (root == null)
            s += "null,";
        else {
            s += String.valueOf(root.val) + ",";
            s = serializeMethod(root.left, s);
            s = serializeMethod(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strArray));
        return deserializeMethod(list);
    }

    private TreeNode deserializeMethod(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        node.left = deserializeMethod(list);
        node.right = deserializeMethod(list);
        return node;
    }

//    // 序列化为层次遍历序列，时间超时，因为相当于存储了一个完全二叉树。
//    // 当树比较稀疏时，存储的绝大部分是多余的null结点，效率太低
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        // 层次遍历
//        Deque<TreeNode> queue = new LinkedList<>();
//        List<String> list = new LinkedList<>();
//        if (root == null)
//            return null;
//        queue.addLast(root);
//        while (!queue.isEmpty()) {
//            boolean isAllNull = true;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                root = queue.removeFirst();
//                if (root != null) {
//                    isAllNull = false;
//                    list.add(String.valueOf(root.val));
//                    queue.addLast(root.left);
//                    queue.addLast(root.right);
//                } else {
//                    list.add("null");
//                    queue.addLast(null);
//                    queue.addLast(null);
//                }
//            }
//            if (isAllNull)
//                break;
//        }
//        while ("null".equals(list.get(list.size() - 1))) {
//            list.remove(list.size() - 1);
//        }
//        return list.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data == null)
//            return null;
//        String[] values = data.split(",");
//        TreeNode[] nodes = new TreeNode[values.length];
//        for (int i = 0; i < values.length; i++) {
//            String s = values[i].replace("[", "")
//                    .replace("]", "")
//                    .replace(" ", "");
//            System.out.print(s + " ");
//            if ("null".equals(s))
//                nodes[i] = null;
//            else
//                nodes[i] = new TreeNode(Integer.parseInt(s));
//        }
//
//        for (int i = 0; i < nodes.length / 2; i++) {
//            if (nodes[i] != null) {
//                nodes[i].left = nodes[2 * i + 1];
//                if ((2 * i + 2) <= nodes.length - 1)
//                    nodes[i].right = nodes[2 * i + 2];
//            }
//        }
//        return nodes[0];
//    }
}
