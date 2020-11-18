package mo.must.array;


import java.util.Arrays;
import java.util.Random;

/*来源：JZ-Offer P41
题目：不修改数组找出重复的数字

描述：在一个长度为n+1的数组里的所有数字都在1~n的范围内。所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，
但不能修改输入的数组。例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7},那么对应的输出是重复的数字2或者3。
 */
public class Exercise002 {
    public static void main(String[] args) {
        int size = 10;
        int array[] = randomArray(size);
        System.out.println(Arrays.toString(array));
        System.out.println(solution1(array));
    }

    private static int[] randomArray(int size) {
        Random rd = new Random();
        //size = n+1;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(size-1)+1;
        }
        return array;
    }

    //基于统计，类似二分查找的方法，统计值为m至n的元素个数，若其个数超过m-n+1，则其中必定存在重复数，再递归的二分查找，直到找到具体值
    //时间复杂度：O(nlogn)
    //空间复杂度：O(1)
    private static int solution1(int[] array) {
        if (array == null)
            return -1;

        //注意，此处的low和high表示的是数，而不是下标
        int n = array.length - 1;
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int count = count(array, low, mid);
            if (low == high && count > 1)
                return low;
            if (count > mid - low + 1) {
                //在low到mid中，包括mid也有可能
                high = mid;
            } else {
                //不在low至mid，所以从mid+1开始数
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int count(int[] array, int low, int mid) {
        int count = 0;
        for (int i : array) {
            if (i >= low && i <= mid)
                count++;
        }
        return count;
    }
}