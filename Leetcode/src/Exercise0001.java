import java.util.Arrays;
import java.util.HashMap;

public class Exercise0001 {
    // 3. 哈希表（一次哈希）
    public int[] twoSum(int[] nums, int target) {
        if (nums != null) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (hashMap.containsKey(temp))
                    return new int[]{hashMap.get(temp), i};
                else
                    hashMap.put(nums[i], i);
            }
        }
        return null;

    }

//    // 1. O(n^2) 暴力解法
//public int[] twoSum(int[] nums, int target) {
//    if (nums != null)
//        //两层for
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target)
//                    return new int[]{i, j};
//            }
//        }
//    return null;
//}
}

// 1. O(n^2) 暴力解法
// 2. O(nlogn) 双指针  错误：题目要求返回index，而sort会打乱顺序，除非用哈希表再存一次，但重复性元素无法解决
// 3. 哈希表（一次哈希）