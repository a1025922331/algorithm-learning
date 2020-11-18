package mo.must.array;

import java.util.Arrays;
import java.util.Random;


/*来源：JZ-Offer P39
题目：找出数组中重复的数字

描述：在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，
但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的
数字。例如，如果输入长度为7的数组{2，3，1，0，2，5，3}，那么对应的输出是重复的
数字2或者3。
 */

public class Exercise001 {

    public static void main(String[] args) {
        Random rd = new Random();
        int size = 100000000;

        int[] array1 = new int[size];
        int[] array2 = new int[size];
        int[] array3 = new int[size];

        //设置循环次数
        int times = 1;

        long start = System.currentTimeMillis();

        for (int i = 0; i < times; i++) {
            RandomArray(rd, array1.length, array1);
            solution1(array1);
//            System.out.println(Arrays.toString(array1));
        }

        long point1 = System.currentTimeMillis();
        System.out.println("方法1用时：" + (point1 - start) + "ms");


        for (int i = 0; i < times; i++) {
            RandomArray(rd, array2.length, array2);
            solution2(array2);
        }
        long point2 = System.currentTimeMillis();
        System.out.println("方法2用时：" + (point2 - point1) + "ms");

        for (int i = 0; i < times; i++) {
            RandomArray(rd, array2.length, array3);
            solution3(array3);
        }
        long point3 = System.currentTimeMillis();
        System.out.println("方法3用时：" + (point3 - point2) + "ms");
    }

    private static void RandomArray(Random rd, int size, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(size);
        }
    }

    //方法1：先排序
    //时间复杂度：O(n*logn)
    //空间复杂度：O(1)
    private static int solution1(int[] array) {
        Arrays.sort(array);
//        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1])
                return array[i];
        }
        return -1;
    }

    //方法2：哈希表
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    private static int solution2(int[] array) {
        int[] hashTable = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (hashTable[temp] == 1) {
                return temp;
            } else {
                hashTable[temp] = 1;
            }
        }
        return -1;
    }

    //方法3：最优解
    //时间复杂度：O(n)
    //空间复杂度：O(1)
    private static int solution3(int[] array) {
        if (array == null)
            return -1;
        int m;
        int temp;
        //扫描数组
        for (int i = 0; i < array.length; i++) {
            //先判断是否在自己位置上
            //m和[m]是否相等
            //若相等则return m
            //若不相等则交换
            m = array[i];
            //判断是否符合要求

            if (m < 0 || m > array.length - 1)
                return -1;


            if (m == i) {
                continue;
            } else if (array[m] == m) {
                return m;
            } else {
                temp = array[i];
                array[i] = array[m];
                array[m] = temp;
                i--;
            }
        }
        return -1;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high)
            return;

        //备份头尾索引
        int lowCopy = low;
        int highCopy = high;
        //设置基准线
        int baseNum = array[low];
        //定义临时变量
        int temp;

        //partition
        while (low != high) {
            //从右往左找小于base number的
            while (low != high && array[high] >= baseNum) {
                high--;
            }
            //从左往右找大于base number的
            while (low != high && array[low] <= baseNum) {
                low++;
            }
            //左右交换
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        //base number归位
        temp = array[low];
        array[low] = array[lowCopy];
        array[lowCopy] = temp;

        //baseNum左边递归快排，右边递归快排
        quickSort(array, lowCopy, low - 1);
        quickSort(array, low + 1, highCopy);
    }
}

