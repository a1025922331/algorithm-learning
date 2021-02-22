import jdk.jfr.StackTrace;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Stack;

import org.junit.Test;

public class Exercise0084_largest_rectangle_in_histogram {
    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{2, 5}));
    }

//    // 1. O(n^3)、O(1): 枚举左右边界，扫描中间的最小值：超出时间限制
//    public int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            // 不从 i+1 开始是因为有可能出现数组只有一个元素的情况
//            for (int j = i; j < heights.length; j++) {
//                int minHeight = Integer.MAX_VALUE;
//                for (int k = i; k <= j; k++){
//                    minHeight = Math.min(minHeight, heights[k]);
//                }
//                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
//            }
//        }
//        return maxArea;
//    }

//    // 2. O(n^2)、O(1): 枚举高度，每次找左右边界: 超出时间限制
//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        int maxArea = 0;
//        //遍历数组，枚举高度
//        for (int i = 0; i < len; i++) {
//            int lower = i - 1, upper = i + 1;
//            // 左边界
//            while (lower != -1 && heights[lower] >= heights[i]) {
//                lower--;
//            }
//            // 右边界
//            while (upper != len && heights[upper] > heights[i]) {
//                upper++;
//            }
//            //更新最大面积
//            maxArea = Math.max(maxArea, (upper - lower - 1) * heights[i]);
//        }
//        return maxArea;
//    }

      // 50ms
    // 3. O(n)、O(n): 枚举高度，遍历一次，存放信息在辅助栈中，用于求左右边界
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // 辅助栈，保持从小到大，元素为{高度，位置}
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{0, -1});
        // 遍历数组、枚举高度
        for (int i = 0; i <= heights.length; i++) {
            //当前高度
            int height = (i == heights.length) ? -1 : heights[i]; //赋值为-1是为了方便最后的边界处理,可以弹出{0，-1}
            //若当前元素小于栈顶元素，需要弹栈处理，并计算以弹出元素的高度作为高的矩形的面积
            while (stack.empty() != true && height < stack.peek()[0]) {
                int lower = 0, upper = 0;
                Integer[] pop = stack.pop();
                if (pop[1] == -1) {
                    return maxArea;
                }
                // 计算以刚弹出的这个元素的高度，向两边拓展的矩形的面积
                maxArea = Math.max(maxArea, (i - stack.peek()[1] - 1) * pop[0]);
            }
            //当前元素大于等于栈顶元素，直接入栈
            stack.push(new Integer[]{height, i});
        }
        return 0;
    }

//    // 27ms
//    // 4. O(n)、O(n): 递归，每次返回当前段的min((最矮柱 * 段宽),(最矮柱左边的矩形的最大面积),(最矮柱右边的矩形的最大面积))
//    private int maxArea(int[] heights, int lower, int upper) {
//        if (lower > upper)
//            return 0;
//        else if (lower == upper)
//            return heights[lower];
//        else {
//            // 判断是否单调
//            boolean isIncreasingSeq = true, isDecreasingSeq = true;
//            int temp = heights[lower]; //记录上一个值
//            // 记录最小值及其坐标
//            int minHeight = Integer.MAX_VALUE;
//            int minHeightIndex = -1;
//            for (int i = lower; i <= upper; i++) {
//                if (heights[i] < temp) //判断递增
//                    isIncreasingSeq = false;
//                if (heights[i] > temp) //判断递减
//                    isDecreasingSeq = false;
//                if (heights[i] < minHeight) { //记录最小
//                    minHeight = heights[i];
//                    minHeightIndex = i;
//                }
//                temp = heights[i];
//            }
//
//            if (isIncreasingSeq) {
//                int maxArea = 0;
//                for (int i = lower; i <= upper; i++) {
//                    maxArea = Math.max(maxArea, heights[i] * (upper - i + 1));
//                }
//                return maxArea;
//            } else if (isDecreasingSeq) {
//                int maxArea = 0;
//                for (int i = lower; i <= upper; i++) {
//                    maxArea = Math.max(maxArea, heights[i] * (i - lower + 1));
//                }
//                return maxArea;
//            } else
//                return Math.max(minHeight * (upper - lower + 1),
//                        Math.max(maxArea(heights, lower, minHeightIndex - 1),
//                                maxArea(heights, minHeightIndex + 1, upper)));
//        }
//    }
}
// 1. O(n^3)、O(1): 枚举左右边界，扫描中间的最小值
// 2. O(n^2)、O(1): 枚举高度，每次找左右边界
//50ms 3. O(n)、O(n): 枚举高度，遍历一次，存放信息在栈中，一次获取左右边界
//26ms 4. O(*)、O(n): 递归，每次返回当前段的min((最矮柱 * 段宽),(最矮柱左边的矩形的最大面积),(最矮柱右边的矩形的最大面积))
// 方法4的时间复杂度最优为O(n)，当数组无序时；若数组单调或有序性较高时，时间复杂度会爆炸至O(n^n)
// 5.锯木板：看了别人的答案想了半天才明白……其实可以把这个想象成锯木板，如果木板都是递增的那我很开心，如果突然遇到一块
// 木板i矮了一截，那我就先找之前最戳出来的一块（其实就是第i-1块），计算一下这个木板单独的面积，然后把它锯成次高的，这
// 是因为我之后的计算都再也用不着这块木板本身的高度了。再然后如果发觉次高的仍然比现在这个i木板高，那我继续单独计算这个
// 次高木板的面积（应该是第i-1和i-2块），再把它俩锯短。直到发觉不需要锯就比第i块矮了，那我继续开开心心往右找更高的。
// 当然为了避免到了最后一直都是递增的，所以可以在最后加一块高度为0的木板。
//这个算法的关键点是把那些戳出来的木板早点单独拎出来计算，然后就用不着这个值了。说实话真的很佩服第一个想出来的人……