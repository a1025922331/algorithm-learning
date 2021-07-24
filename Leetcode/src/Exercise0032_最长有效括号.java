import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: guozexin.gzx
 * @Date: 2021/7/24
 */
public class Exercise0032_最长有效括号 {
    @Test
    public void test() {
        System.out.println(longestValidParentheses3("()(()()"));
    }

    // 1.正向逆向结合法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    // 基本思想：遍历字符串，对左右括号进行计数，遇到无效字符串计数置零，遇到左右相等维护长度最大值
    // 逆序解决"(()"问题
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 0;
        // 正向
        int left = 0, right = 0;
        for (char c : chars) {
            if (c == '(') { left++;}
            if (c == ')') { right++;}
            if (left < right) { left = right = 0;}
            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            }
        }
        // 反向: 防止出现"(()"情况的出现
        left = right = 0;
        for (int i = chars.length - 1; i >= 0 ; i--) {
            char c = chars[i];
            if (c == '(') { left++;}
            if (c == ')') { right++;}
            if (left > right) { left = right = 0;}
            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            }
        }
        return maxLength;
    }

    // 2.栈方法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    // 基本思想：①初始入栈"-1"，再遍历字符串
    //         ②遇到"(",下标入栈
    //         ③遇到")"
    //           我们先弹出栈顶元素表示匹配了当前右括号(也可能没匹配成功)：
    //           如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标,便于后续有效长度计算
    //           如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') { stack.push(i);}
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    // 3.动态规划(较为复杂)
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    // dp数组记录以当前位作为结束的最长有效括号对的长度
    // 状态转移方程：①当c为'(',dp[i]=0
    //            ②当c为')',dp[i]=基础长度2 + 内部连在一起的最长有效括号长度 + 外部连在一起的
    //            基础长度计算：判断i - dp[i - 1] - 1处是否为'(',若是，则基础长度为2,若不是，则匹配不了，则dp[i] = 0
    //            内部连在一起的最长有效括号长度：dp[i - 1]
    //            外部连在一起的最长有效括号长度：dp[i - dp[i - 1] - 2] (若存在的话)
    public int longestValidParentheses3(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')'
                    && i > 0
                    && (i - dp[i - 1] - 1) >= 0
                    && chars[i - dp[i - 1] - 1] == '(') {
                // 基本长度 + 内部有效括号字符串
                dp[i] = 2 + dp[i - 1];
                // 外部有效括号字符串
                dp[i] += ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
