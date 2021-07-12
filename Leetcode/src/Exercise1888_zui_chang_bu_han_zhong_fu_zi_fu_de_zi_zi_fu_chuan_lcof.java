import java.util.Arrays;

public class Exercise1888_zui_chang_bu_han_zhong_fu_zi_fu_de_zi_zi_fu_chuan_lcof {
    // //哈希表 (7ms)
    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null || s.length() == 0)
    //         return 0;
    //     char[] chars = s.toCharArray();
    //     int begin = 0;
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     int max = Integer.MIN_VALUE;

    //     for (int i = 0; i < chars.length; i++) {
    //         if (!map.containsKey(chars[i])) { //不在map中
    //             map.put(chars[i], i);
    //         } else { //在map中
    //             // 看是否会影响
    //             if (map.get(chars[i]) >= begin)
    //                 begin = map.get(chars[i]) + 1;
    //             // 更新位置
    //             map.put(chars[i], i);
    //         }
    //         //更新最大值
    //         max = Math.max(max, i - begin + 1);
    //     }
    //     return max;
    // }

    // 直接用数组（3ms）
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int begin = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < chars.length; i++) {
            int c = chars[i];
            if (map[c] == -1) { //不在map中
                map[c] = i;
            } else { //在map中
                // 看是否会影响
                if (map[c] >= begin)
                    begin = map[c] + 1;
                // 更新位置
                map[c] = i;
            }
            //更新最大值
            max = Math.max(max, i - begin + 1);
        }
        return max;
    }
}