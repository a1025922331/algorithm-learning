import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exercise0017_letter_combinations_of_a_phone_number {
    public List<String> letterCombinations(String digits) {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});

        ArrayList<String> list = new ArrayList<>();
        if (digits.length() == 0)
            return list;
        combination(map, list, digits, 0, "");
        return list;
    }

    // i为已经添加的位数
    private void combination(HashMap<String, String[]> map, ArrayList<String> list, String digits, int i, String s) {
        // 边界条件
        if (i == digits.length()) {
            list.add(s);
            return;
        }
        // 添加字符
        for (String bitS : map.get(String.valueOf(digits.charAt(i)))) {
            combination(map, list, digits, i + 1, s + bitS);
        }
    }
}