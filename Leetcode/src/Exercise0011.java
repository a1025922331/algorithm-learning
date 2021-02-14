// 11. 盛最多水的容器
// 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
// 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//

public class Exercise0011 {
    // O(n) 2.左右夹逼，双指针问题 （优化：去掉不必要的比较）
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            // 比较计算最大面积
            int minEdge = height[i] < height[j] ? height[i] : height[j];
            max = Math.max(max, minEdge * (j - i));
            // 移动短边,并跳过不必要的比较
            if (height[i] < height[j]) {
                do { i++; }
                while (height[i] <= minEdge && i < j);
            } else {
                do { j--; }
                while (height[j] <= minEdge && i < j);
            }
        }
        return max;
    }

    // O(n) 2.左右夹逼，双指针问题
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0, j = height.length - 1; i < j; ) {
//            // 计算当前最短边并移动指针待下一轮计算, 短边向内移动
//            int minEdge = (height[i] > height[j] ? height[j--] : height[i++]);
//            // 计算当前最大面积
//            max = Math.max(max, minEdge * (j - i + 1)); // 补一个1，因为前面移动了指针
//        }
//        return max;
//    }

    // O(n^2) 1.枚举方法：枚举所有可能
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = Math.min(height[i], height[j]) * (j - i);
//                max = Math.max(max, area);
//            }
//        }
//        return max;
//    }
}

// O(n^2) 1.枚举方法：枚举所有可能
// O(n) 2.左右夹逼，双指针问题