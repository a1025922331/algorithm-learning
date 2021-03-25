public class Exercise0069_sqrtx {
//    //0-1是凹函数，1-∞是凸函数,二分查找
//    public int mySqrt(int x) {
//        if (x == 0 || x == 1)
//            return x;
//        int left = 1, right = x;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;  //防止超出边界
//            if ((long)mid * (long)mid > x)
//                right = mid - 1;
//            else
//                left = mid + 1; // 这里不用担心刚好等于x的情况，因为即使不小心跨过了，之后right也会跨回来
//        }
//        return right; // 边界条件记得处理
//    }

    // 牛顿迭代法（数值分析，原理简单）
    // https://leetcode-cn.com/problems/sqrtx/solution/niu-dun-die-dai-fa-by-loafer/
    public int mySqrt(int x) {
        long r = x; //随机取一个数
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}