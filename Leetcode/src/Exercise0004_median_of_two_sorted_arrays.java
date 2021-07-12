/**
 * @Author: guozexin.gzx
 * @Date: 2021/7/11
 */
public class Exercise0004_median_of_two_sorted_arrays {
    //2021/7/11
    //时间: O(n+m) 空间:O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int index1 =0, index2 = 0;
        int cur = 0;
        for (int i = 0; i < (n + m) / 2; i++) {
            if ((index1 < n) && (index2 >= m || nums1[index1] < nums2[index2])) {
                cur = nums1[index1];
                index1++;
            } else {
                cur = nums2[index2];
                index2++;
            }
        }
        int next = index1 < n ? Math.min(nums1[index1], Integer.MAX_VALUE): Integer.MAX_VALUE;
        next = index2 < m ? Math.min(nums2[index2], next): next;
        if ((n + m) % 2 == 1) {
            return next;
        } else {
            return (cur + next) / 2.0;
        }
    }
}
