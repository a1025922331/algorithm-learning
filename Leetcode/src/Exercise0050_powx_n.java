import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exercise0050_powx_n {
    // // 递归，O(logn)、O(logn)
    // public double myPow(double x, int n) {
    //     if (n < 0)
    //         return 1 / myPow(x, -n);
    //     if (n == 0)
    //         return 1;
    //     double temp = myPow(x, n / 2);
    //     return  (n % 2 == 0)? temp * temp: temp * temp * x;

    // }

    //快速幂求解: 迭代
    public double myPow(double x, int n) {
        // int转long（因为int可表示的负数范围比正数范围大1）
        long num = (n > 0)? n: -(long)n;

        // 获取计算方法（false表示当前步骤不需要乘x，true表示需要乘x）
        List<Boolean> list = new ArrayList<>();
        for (long i = num; i > 0; i /= 2)
            list.add((i % 2 == 0)? false: true);

        // 计算（将刚刚得到的计算步骤倒过来执行）
        double result = 1;
        for (int i = list.size() - 1; i >= 0; i--)
            result *= (list.get(i))? result * x: result;

        // 返回
        return (n > 0)? result: 1 / result;
    }
}