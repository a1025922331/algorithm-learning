public class Exercise0055_jump_game {
//    // 从后往前贪心 (1ms)
//    public boolean canJump(int[] nums) {
//        int farthestVisitable = nums.length - 1;
//        for (int i = nums.length - 1; i >= 0 ; i--) {
//            if (nums[i] + i >= farthestVisitable)
//                farthestVisitable = i;
//        }
//        return farthestVisitable == 0;
//    }

    // 从前往后贪心 (1ms)
    public boolean canJump(int[] nums) {
        int farthestVisitable = 0;
        for (int i = 0; i <= farthestVisitable; i++) {
            if (nums[i] + i > farthestVisitable)
                farthestVisitable = Math.min(nums[i] + i, nums.length - 1);
        }
        return farthestVisitable >= nums.length - 1;
    }
}
