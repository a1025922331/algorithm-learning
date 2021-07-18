import java.util.*;

public class Exercise0015_三数之和 {
    // 2. O(n^2) 双指针 (加了去重)
    // 只看这个这个就好，排序 + 夹逼
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums != null && nums.length >= 3) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2;) {
                if (nums[i] > 0) {
                    return result;
                }
                //夹逼
                for (int j = i + 1, k = nums.length - 1; j < k;){
                    int target = nums[i] + nums[j] + nums[k];
                    if (target < 0 ) {
                        do {j++;} while(nums[j] == nums[j - 1] && j < k);
                    } else if (target > 0){
                        do {k--;} while(nums[k] == nums[k + 1] && j < k);
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        do {j++;} while(nums[j] == nums[j - 1] && j < k);
                        do {k--;} while(nums[k] == nums[k + 1] && j < k);
                    }
                }
                do {i++;} while (nums[i] == nums[i - 1] && i < nums.length - 2);
            }
        }
        return result;
    }

    // 3. O(n^2) 自己写的哈希方法（此处用哈希不好去重）(别看了，shi一样的代码，剪枝没剪干净，还是需要用set去重)
    public List<List<Integer>> threeSum2(int[] nums) {
        // 一遍哈希的中间存储
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        // 结果，用set来去重
        HashSet<List<Integer>> result = new HashSet<>();
        boolean isAllZero = false;
        for (int num : nums) {
            if (num != 0)
                isAllZero = false;
        }
        if (isAllZero) {
            result.add(Arrays.asList(0,0,0));
            return new ArrayList<>(result);
        }

        if (nums != null && nums.length >= 3) {
            Arrays.sort(nums);
            // target
            for (int i = 0; i < nums.length; i++) {
                if (!hashMap.containsKey(0 - nums[i])) {
                    hashMap.put(0 - nums[i], new HashSet<>());
                }
                HashSet<Integer> indexS = hashMap.get(0 - nums[i]);
                indexS.add(i);
                hashMap.put(0 - nums[i], indexS);
            }
            // 两层for
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int temp = nums[i] + nums[j];
                    if (hashMap.containsKey(temp)) {
                        HashSet<Integer> indexS = hashMap.get(temp);
                        if (indexS.contains(i)) {
                            indexS.remove(i);
                            if (indexS.isEmpty()) {
                                indexS.add(i);
                                continue;
                            }
                        }
                        if (indexS.contains(j)) {
                            indexS.remove(j);
                            if (indexS.isEmpty()) {
                                indexS.add(j);
                                continue;
                            }
                        }
                        int[] ints = {nums[i], nums[j], -temp};
                        Arrays.sort(ints);
                        ArrayList<Integer> list = new ArrayList<>();
                        for (int anInt : ints) {
                            list.add(anInt);
                        }
                        result.add(list);
                    }
                }
            }
            return new ArrayList<>(result);
        } else {
            return new ArrayList<>(result);
        }
    }

    // 1. O(n^3) 暴力解法
//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums != null){
//            Arrays.sort(nums); //防止出现{1,-1,0}和{-1,0,1}这样的重复结果，set不能去除不同顺序的list
//            Set<List<Integer>> result = new HashSet<>();
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (nums[i] + nums[j] + nums[k] == 0){
//                            ArrayList<Integer> temp = new ArrayList();
//                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                        }
//                    }
//                }
//            }
//            return new ArrayList<>(result);
//        }
//        return Collections.emptyList();
//    }
}

// 1. O(n^3) 暴力解法
// 2. O(n^2) 双指针
// 3. O(n^2) 哈希表（一次哈希/两次哈希）
// 经验：利用set来去重虽然编写简单，但是额外开销大，可以在解题过程中直接去重，当要注意别漏情况
// 华为面试最爱考的！！！