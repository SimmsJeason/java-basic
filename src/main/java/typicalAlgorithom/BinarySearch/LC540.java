package typicalAlgorithom.BinarySearch;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC540 {

    /**
     * 令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。
     * 如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
     *
     * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，
     * 那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；
     * 如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
     *
     * 因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
     */

    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    public int singleNonDuplicate2(int[] nums) {

        int n = nums.length;
        int l = 0;
        int h = n-1;
        int mid = -1;

        while ( l <= h){
            mid = l + (h-l) /2;
            if(mid + 1 < n && nums[mid] == nums[mid +1]){
                if((n - mid -2) %2 == 0){
                    h = mid -1;
                }else {
                    l = mid +2;
                }
            }else if(mid - 1 >=0 && nums[mid] == nums[mid -1]){
                if((mid -2) % 2 == 0){
                    h = mid -1;
                }else {
                    l = mid+1;
                }
            }else {
                return nums[mid];
            }

        }
        return nums[mid];
    }
}
