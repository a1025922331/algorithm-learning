import java.util.*;

public class Exercise0015_3sum {
    // 3. O(n^2) 哈希表（此处用哈希不好去重）
    public List<List<Integer>> threeSum(int[] nums) {
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
                if (hashMap.containsKey(0 - nums[i])) {
                    HashSet<Integer> integers = hashMap.get(0 - nums[i]);
                    integers.add(i);
                    hashMap.put(0 - nums[i], integers);
                } else {
                    HashSet<Integer> integers = new HashSet<Integer>();
                    integers.add(i);
                    hashMap.put(0 - nums[i], integers);
                }
            }
            // 两层for
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int temp = nums[i] + nums[j];
                    if (hashMap.containsKey(temp)) {
                        HashSet<Integer> integers = hashMap.get(temp);
                        if (integers.contains(i)) {
                            integers.remove(i);
                            if (integers.isEmpty()) {
                                integers.add(i);
                                continue;
                            }
                        }
                        if (integers.contains(j)) {
                            integers.remove(j);
                            if (integers.isEmpty()) {
                                integers.add(j);
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


    // 2. O(n^2) 双指针
//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums != null || nums.length < 3) {
//            List<List<Integer>> result = new ArrayList<>();
//            //先排序
//            Arrays.sort(nums);
//            //夹逼
//            for (int targetIndex = 0; targetIndex <= nums.length - 3;) {
//                if (nums[targetIndex] > 0)
//                    return result;
//                for (int i = targetIndex + 1, j = nums.length - 1; i < j ;) {
//                    int temp = nums[targetIndex] + nums[i] + nums[j];
//                    if (temp < 0)
//                            i++;
//                    else if (temp > 0)
//                            j--;
//                    else{
//                        result.add(Arrays.asList(nums[targetIndex], nums[i], nums[j]));
//                        do {
//                            i++;
//                        } while (i < j && nums[i] == nums[i - 1]);
//                        do {
//                            j--;
//                        } while (i < j && nums[j] == nums[j + 1]);
//                    }
//                }
//                do {
//                    targetIndex++;
//                } while (targetIndex <= nums.length - 2 && nums[targetIndex] == nums[targetIndex - 1]);
//            }
//            return result;
//        }
//        return Collections.emptyList();
//    }

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