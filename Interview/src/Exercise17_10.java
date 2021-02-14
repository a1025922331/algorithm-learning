import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Exercise17_10 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int majorityElement(int[] nums) {
        //摩尔投票法: On、O1
        //	在第一趟扫描结束后，如果数组中存在多数元素，那么candidate即为其值，如果原数组不存在多数元素，则candidate的值没有意义。所以需要第二趟扫描来统计candidate出现的次数来判断其是否为多数元素。
        //！相当于从头到尾每次消掉两个不一样元素的，这样剩下的即为主要元素，如果存在主要元素的话
        int candidate = 0;
        int count = 0;
        for (int element : nums) {
            if (count == 0)
                candidate = element;
            if (element == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == candidate)
                count++;
        }
        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1;
        }

        //哈希表: On、On
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int temp = nums[i];
//            if (!hm.containsKey(temp)) {
//                hm.put(temp, 1);
//            } else {
//                hm.put(temp, hm.get(temp) + 1);
//            }
//        }
//        int[] max = {0, 0};
//        Set<Integer> keySet = hm.keySet();
//        for (Integer key : keySet) {
//            int temp = hm.get(key);
//            if (temp > max[1]) {
//                max[0] = key;
//                max[1] = temp;
//            }
//        }
//        if (max[1] <= nums.length / 2) {
//            return -1;
//        }
//        return max[0];
    }
}