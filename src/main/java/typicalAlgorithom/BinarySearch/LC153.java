package typicalAlgorithom.BinarySearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC153 {
    public int findMin(int[] nums) {

        //取最小值
        int n = nums.length -1;
        int l = 0;
        int h = n;
        while(l < h){
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {//小于等于，h 赋值 m
                h = m;
            } else {
                l = m + 1;//大于就 m+1
            }
        }
        return nums[l];
    }
}
