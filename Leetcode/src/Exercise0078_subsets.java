import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exercise0078_subsets {
//    //递归生成所有可能的子集
//    //时间复杂度O(n * 2^n)
//    //空间复杂度O(n)
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        add(nums, 0, result, new ArrayList<Integer>());
//        return result;
//    }
////
////    // i表示当前已经考虑了i个元素
////    private void add(int[] nums, int i, List<List<Integer>> result, List<Integer> list) {
////        // 边界
////        if (i == nums.length) {
////            result.add(list);
////            return;
////        }
////        // 当前层逻辑与下探层
////        add(nums, i + 1, result, new ArrayList<Integer>(list)); //不加
////        list.add(nums[i]);
////        add(nums, i + 1, result, new ArrayList<Integer>(list)); //加
////    }
//
//    // 在空间上进行一点优化，每次递归调用不创建新的arraylist对象，节省空间
//    // 每次回退，在边界处再创建新新对象
//    private void add(int[] nums, int i, List<List<Integer>> result, List<Integer> list) {
//        // 边界
//        if (i == nums.length) {
//            result.add(new ArrayList<Integer>(list));
//            return;
//        }
//        // 当前层逻辑与下探层
//        add(nums, i + 1, result, list); //不加
//        list.add(nums[i]);
//        add(nums, i + 1, result, list); //加
//        // 返回
//        list.remove(list.size() - 1);
//    }

    // 迭代法 + 位运算 : 速度略慢一些
    // 时间复杂度O(n * 2^n)
    // 空间复杂度O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //生成所有可能情况对应的二进制数
        for (int num = 0; num < (1 << nums.length); num++) {
            List<Integer> list = new ArrayList<>();
            // 根据改二进制数的每一位去添加元素
            for (int i = 0; i < nums.length; i++) {
                if ((num & (1 << i)) != 0)
                    list.add(nums[i]);
            }
            result.add(list);
        }
        return result;
    }
}