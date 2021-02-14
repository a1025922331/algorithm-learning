//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

public class Exercise0283 {
    //交换法，更通用，也适合其它题目
    public void moveZeroes(int[] nums) {
        int index = 0; //统计非零个数，也是下一个非零元素该存放的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }
}
//补0法
// public void moveZeroes(int[] nums) {
//     int index = 0; //统计非零个数，也是下一个非零元素该存放的位置
//     for (int i = 0; i < nums.length; i++) {
//         if (nums[i] != 0) {
//             nums[index] = nums[i];
//             if (index != i) {
//                 nums[i] = 0; //修改完后置0，可以减少最后一个for循
//             }
//             index++;
//         }
//     }
// }

//    方法1：维护零个数，遍历向前移动
//    public void moveZeroes(int[] nums) {
//        int count = 0;  //此处统计零个数，但若统计非零个数会让代码更简洁
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                count++;
//            } else {
//                nums[i - count] = nums[i];
//            }
//        }
//        for (int i = nums.length - count; i < nums.length; i++)
//            nums[i] = 0;
//    }


//遍历数组，向前移动