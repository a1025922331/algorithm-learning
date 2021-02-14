import java.util.HashMap;

public class Exercise0070 {
    // 1.归纳 => 斐波那契数列
    // F(n) = F(n-1) + F(n-2)
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

//    // 2.递归 + 缓存
//    static HashMap<Integer, Integer> hashMap = new HashMap();
//    static {
//        hashMap.put(1, 1);
//        hashMap.put(2, 2);
//    }
//
//    public int climbStairs(int n) {
//        // 查看缓存
//        if (hashMap.containsKey(n))
//            return hashMap.get(n);
//            // 计算F(n) = F(n-1) + F(n-2), 并存入缓存
//        else {
//            int count = climbStairs(n - 1) + climbStairs(n - 2);
//            hashMap.put(n, count);
//            return count;
//        }
//    }
}
// 1.归纳 => 斐波那契数列
// 2.递归 + 缓存