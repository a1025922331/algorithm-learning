public class Exercise0367_valid_perfect_square {
//    // 二分法
//    public boolean isPerfectSquare(int num) {
//        if (num == 0 || num == 1)
//            return true;
//        int left = 1, right = num;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if ((long)mid * (long)mid > num)
//                right = mid - 1;
//            else
//                left = mid + 1;
//        }
//        return right * right == num;
//    }

    // 牛顿迭代
    public boolean isPerfectSquare(int num) {
        int r = num;
        while ((long)r * (long)r > num) {
            r = (r + num / r) / 2;
        }
        //无限逼近后几乎相等
        return r * r == num;
    }
}