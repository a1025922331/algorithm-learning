import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//无重复字符的字符串
public class Exercise0003 {

    //2021.07.11
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int index = 0;

        // Hash Map版本
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < chars.length; i++) {
//            if (map.containsKey(chars[i]) && map.get(chars[i]) >= index) {
//                index = map.get(chars[i]) + 1;
//            }
//            map.put(chars[i], i);
//            max = Math.max(max, i - index + 1);
//        }

        // 数组版
        int[] ascii = new int[128];
        Arrays.fill(ascii, -1);
        for (int i = 0; i < chars.length; i++) {
            if (ascii[chars[i]] >= index) {
                index = ascii[chars[i]] + 1;
            }
            ascii[chars[i]] = i;
            max = Math.max(max, i - index + 1);
        }

        return max;
    }

//    //思路:模拟人解题的过程,滑动窗口的思想
//    public static int lengthOfLongestSubstring(String s) {
//        //95.24% 57.60%
//        return myMethod(s);
//        //100% 96.43%
//        // return answerMethod(s);
//
//    }

    private static int myMethod(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[] ascii = new boolean[128];
        Arrays.fill(ascii, false);

        int max = 0;
        int low = 0;

        for (int high = 0; high < len; high++) {
            //当前字串未出现该字符
            if (ascii[(int) chars[high]] == false) {
                ascii[(int) chars[high]] = true;
                max = Math.max(max, high - low + 1);
                continue;
            }
            if (ascii[(int) chars[high]] == true) {
                //当前字串窗口剔除chars[low]直到重新遇到chars[high]或者low=high
                while (chars[low] != chars[high]) {
                    ascii[(int) chars[low]] = false;
                    low++;
                }
                low++;
            }
        }
        return max;
    }

    //答案的方法，思路和我一样，都采用字串窗口，但不需要标记和去标记，直接ascii数组存储最后一次出现改字符的位置，再对比即可
    private static int answerMethod(String s) {
        int len = s.length();
        char[] chars = new char[len];
        chars = s.toCharArray();
        int max = 0;

        //最后一次出现该字符的位置
        int[] ascii = new int[128];
        Arrays.fill(ascii, -1);

        //窗口边界
        int low = 0;
        int high = 0;
        //临时变量
        int charAscii;

        //遍历char数组
        for (; high < len; high++) {
            charAscii = chars[high];
            low = Math.max(low, ascii[charAscii] + 1);
            max = Math.max(max, high - low + 1);
            ascii[charAscii] = high;
        }
        return max;
    }
}
