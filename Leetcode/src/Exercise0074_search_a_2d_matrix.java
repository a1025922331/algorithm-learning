public class Exercise0074_search_a_2d_matrix {
//    //直接二分 O(log(mn))
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null)
//            return false;
//        int row = matrix.length , column = matrix[0].length;
//        int len = row * column;
//        int left = 0, right = len - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            int temp = matrix[mid / column][mid % column];
//            if (temp == target)
//                return true;
//            else if (target > temp)
//                left = mid + 1;
//            else
//                right = mid - 1;
//        }
//        return false;
//    }

    // 从右上开始 O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int row = matrix.length, column = matrix[0].length;
        int i = 0, j = column - 1;
        while (i < row && j >= 0) {
            int temp = matrix[i][j];
            if (temp == target)
                return true;
            else if (target > temp)
                i++;
            else if (target < temp)
                j--;
        }
        return false;
    }
}
