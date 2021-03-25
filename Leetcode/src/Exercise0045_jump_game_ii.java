public class Exercise0045_jump_game_ii {
//    // 深度优先搜索
//    // 超时
//    public int jump(int[] nums) {
//        int minStep[] = {Integer.MAX_VALUE};
//        dfs(nums, 0, minStep, 0);
//        return minStep[0];
//    }
//
//    private void dfs(int[] nums, int curIndex, int[] minStep, int curStep) {
//        if (curStep >= minStep[0])
//            return;
//        if (curIndex == nums.length - 1)
//            minStep[0] = curStep;
//        int temp = nums[curIndex];
//        if (temp == 0)
//            return;
//        // 从最远的开始
//        for (int i = Math.min(curIndex + temp, nums.length - 1); i > curIndex; i--) {
//            dfs(nums, i, minStep, curStep + 1);
//        }
//    }

    // 反向查找
    // 贪心地选择距离最后一个位置最远的那个位置。然后找到最后一步跳跃前所在的位置，继续贪心地寻找倒数第二步跳跃前所在的位置，以此类推，直到找到数组的开始位置
    // 时间复杂度：O(n^2) (全是1的情况)
    // 空间复杂度：O(1)
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    step++;
                }
            }
        }
        return position == 0? step: -1;
    }
}