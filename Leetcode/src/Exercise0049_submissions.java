import org.w3c.dom.stylesheets.LinkStyle;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Exercise0049_submissions {
    //    // 1.O(nklogk) 将各字符串排序作为key进行哈希分桶
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> hashMap = new HashMap<>();
//        for (String s : strs) {
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            String key = new String(chars);
//            if (!hashMap.containsKey(key))
//                hashMap.put(key, new ArrayList<String>());
//            hashMap.get(key).add(s);
//        }
//        return new ArrayList(hashMap.values());
//    }
    public void test() {
        int[] arrays = new int[4];
        System.out.println(arrays);
    }

    // 2.O(nk) 字母计数，int数组作为key
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] charCount = new int[26];
            Arrays.fill(charCount, 0);
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }
            String key = Arrays.toString(charCount);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<String>());
            }
            hashMap.get(key).add(str);
        }
        return new ArrayList(hashMap.values());
    }

    // 用质数代替字符进行编码
    public List<List<String>> groupAnagrams3(String[] strs) {
        int[] code = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        HashMap<Double, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            double key = 1;
            for (char c : str.toCharArray()) {
                key *= code[c - 'a'];
            }
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<String>());
            }
            hashMap.get(key).add(str);
        }
        return new ArrayList(hashMap.values());
    }

}
// 1.O(nklogk) 字符串排序，将各字符串排序作为key进行哈希分桶
// 2.O(nk) 字母计数，int数组作为key
// 3.在美版leetcode上看到大神的思路，用质数表示26个字母，把字符串的各个字母相乘，这样可保证字母异位词的乘积必定是相等的。其余步骤就是用map存储，和别人的一致了。（这个用质数表示真的很骚啊！！!）