import java.util.LinkedList;
import java.util.List;

public class Exercise0022_generate_parentheses {
    //这里不能用stringBuilder，否则会叠加 756358991

    // 递归生成符合规则的括号串
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        generate(n,n,n,list,"");
        return list;
    }

    // 参数说明，括号对数，剩余左括号个数，剩余右括号个数，列表，字符串
    private void generate(int n, int left, int right, List<String> list, String s) {
        //terminal
        if (left == 0 && right == 0)
            list.add(s.toString());
        //process
        //drillDown
        //只要有左括号就可以放
        if (left > 0)
            generate(n,left - 1, right, list, s +"(");
        //右括号不能比左括号用得快
        if (right > left)
            generate(n, left, right - 1, list, s + ")");
        //restore current status
    }
}