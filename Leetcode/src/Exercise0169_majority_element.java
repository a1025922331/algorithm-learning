public class Exercise0169_majority_element {
    // // 1.哈希表解法,遍历时维护最大值 15ms
    // // O(n)
    // // O(n)
    // public int majorityElement(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int maxValue = 0;
    //     int maxTimes = 0;
    //     for (int num : nums) {
    //         if (!map.containsKey(num))
    //             map.put(num, 0);
    //         int old = map.get(num);
    //         map.put(num, old + 1);
    //         if (old + 1 > maxTimes) {
    //             maxValue = num;
    //             maxTimes = old + 1;
    //         }
    //     }
    //     return maxValue;
    //     // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //     //     if (entry.getValue() > nums.length / 2)
    //     //         return entry.getKey();
    //     // }
    //     // return -1;
    // }

    // // 2.排序
    // // O(nlogn)
    // // O(nlogn)
    // // 2ms 猜测速度快的原因是由于其针对不同长度的数组采取了效率更高的排序算法
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }

    // 3.摩尔投票法
    // O(n)
    // O(1)
    // 思想：每次消掉两个不同的，那么最后剩下的最多的即为可能的major，再遍历一遍检查一下
    public int majorityElement(int[] nums) {
        int count = 0;
        int major = 1;
        for (int num : nums) {
            // count是否为0
            if (count == 0)
                major = num;
            // major是否与当前元素一致
            if (major == num)
                count++;
            else
                count--;
        }

        // //遍历检查一遍,题目说一定存在，则不需要检查
        // count = 0;
        // for (int num : nums) {
        //     if (num == major) count++;
        // }
        // return (count > nums.length / 2)? major: -1;

        return major;
    }
}
