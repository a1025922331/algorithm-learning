import java.util.Map;
import java.util.Stack;

public class Exercise0020_valid_parentheses {
//    // 1、O(n^2)、O（1）：暴力解法：
//    public boolean isValid(String s) {
//        if (s == null)
//            return false;
//        while (!"".equals(s)) {
//            int length = s.length();
//            s = s.replace("{}", "");
//            s = s.replace("[]", "");
//            s = s.replace("()", "");
//            if (s.length() == length) {
//                return false;
//            }
//        }
//        return true;
//    }

    // 2、O(n)、O（n）: 栈1
    public boolean isValid(String s) {
        if (s == null)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (c == '(')
                stack.push(')');
            else if (stack.empty() || stack.pop() != c)
                return false;
        }
        return stack.empty();
    }

//    // 2、O(n)、O（n）: 栈2（配合哈希表）
//    public boolean isValid(String s) {
//        if (s != null) {
//            Stack<Character> stack = new Stack<>();
//            Map<Character, Character> map = Map.ofEntries(
//                    Map.entry('[', ']'), Map.entry('{', '}'), Map.entry('(', ')'));
//            for (char c : s.toCharArray()) {
//                if (map.containsKey(c))
//                    stack.push(map.get(c));
//                else if (map.containsValue(c))
//                    if (stack.empty() || stack.pop() != c) {
//                        return false;
//                    }
//            }
//            return stack.empty();
//        } else {
//            return false;
//        }
//    }
}

// 1、O(n^2)、O（1）：暴力解法：使用replace方法去除成对的括号
// 2、O(n)、O（n）: 栈1（向栈中存与之匹配的反向括号来简化代码）
// 2、O(n)、O（n）: 栈2（配合哈希表）

