import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Exercise0049_submissions {
    // 1.O(nklogk) 将各字符串排序作为key进行哈希分桶
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!hashMap.containsKey(key))
                hashMap.put(key, new ArrayList<String>());
            hashMap.get(key).add(s);
        }
        return new ArrayList(hashMap.values());
    }
}
// 1.O(nklogk) 将各字符串排序作为key进行哈希分桶
// 2.在美版leetcode上看到大神的思路，用质数表示26个字母，把字符串的各个字母相乘，这样可保证字母异位词的乘积必定是相等的。其余步骤就是用map存储，和别人的一致了。（这个用质数表示真的很骚啊！！!）