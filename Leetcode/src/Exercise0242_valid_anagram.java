import java.util.HashMap;

public class Exercise0242_valid_anagram {
    // 3.进阶，hashMap
    public boolean isAnagram(String s, String t) {
        if (s != null && t != null && s.length() == t.length()) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            char[] charsS = s.toCharArray();
            char[] charsT = t.toCharArray();
            for (char c : charsS) {
                if (hashMap.containsKey(c)) {
                    hashMap.put(c,hashMap.get(c)+1);
                }else
                    hashMap.put(c,1);
            }
            for (char c : charsT) {
                if (hashMap.containsKey(c)) {
                    int count = hashMap.get(c);
                    if (count == 1)
                        hashMap.remove(c);
                    else
                        hashMap.put(c,count-1);
                }else
                    return false;
            }
            if (hashMap.size() == 0)
                return true;
        }
        return false;
    }
    // // 2.哈希表
    // public boolean isAnagram(String s, String t) {
    //     if (s != null && t != null && s.length() == t.length()) {
    //         int[] count = new int[256];
    //         for (int i = 0 ; i < s.length(); i++) {
    //             count[(int)s.charAt(i)]++;
    //             count[(int)t.charAt(i)]--;
    //         }
    //         for (int i : count) {
    //             if (i != 0) {
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     return false;
    // }

    // // 1.暴力解法：先排序，再比较是否相同
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() == t.length()) {
    //         char[] str1 = s.toCharArray();
    //         char[] str2 = t.toCharArray();
    //         Arrays.sort(str1);
    //         Arrays.sort(str2);
    //         return new String(str1).equals(new String(str2));
    //         //return Arrays.equals(str1, str2);
    //     }
    //     return false;
    // }
}
// 1.暴力解法：先排序，再比较是否相同
// 2.哈希表
// 3.进阶，hashMap