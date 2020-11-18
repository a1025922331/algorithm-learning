package mo.must.array;
import java.util.Arrays;

/*来源：JZ-Offer P44
题目：二维数组的查找

描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样
的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Exercise003 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        int[] position1 = new int[2];
        boolean isExistNum1 = solution1(array, 11, position1);
        System.out.println(Arrays.toString(position1));

        int[] position2 = new int[2];
        boolean isExistNum2 = solution2(array, 9, position2);
        System.out.println(Arrays.toString(position2));
    }


    //从右上开始找
    private static boolean solution1(int[][] array, int targetNum, int[] position) {
        boolean isFound = false;

        //判断是否空指针
        if (array == null)
            return isFound;

        //保存数组大小
        int rows = array.length;
        int columns = array[0].length;

        //从右上开始
        int row = 0;
        int column = columns - 1;

        while (row < rows && column >= 0) {
            int tempNum = array[row][column];
            if (tempNum == targetNum) {
                isFound = true;
                position[0] = row;
                position[1] = column;
                break;
            } else if (tempNum > targetNum) {
                column--;  //不可能在右下（含tempNum所在行列）
            } else {
                row++;//tempNum < targetNum, 不可能在左上（含tempNum所在行列）
            }
        }
        return isFound;
    }

    //从左下开始找
    private static boolean solution2(int[][] array, int targetNum, int[] position) {
        boolean isFound = false;
        if (array == null) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;
        int row = rows - 1;
        int column = 0;
        while (row >= 0 && column < columns) {
            int tempNum = array[row][column];
            if (tempNum == targetNum) {
                isFound = true;
                position[0] = row;
                position[1] = column;
                break;
            } else if (tempNum > targetNum) {
                row--;
            } else {
                column++;
            }
        }
        return isFound;
    }

}
