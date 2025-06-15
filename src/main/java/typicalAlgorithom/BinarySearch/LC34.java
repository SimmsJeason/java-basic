package typicalAlgorithom.BinarySearch;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC34 {

    /**
     *可以用二分查找找出第一个位置和最后一个位置，但是寻找的方法有所不同，需要实现两个二分查找。
     * 我们将寻找 target 最后一个位置，转换成寻找 target+1 第一个位置，再往前移动一个位置。
     * 这样我们只需要实现一个二分查找代码即可。
     */
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length; // 注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int[] searchRange2(int[] nums, int target) {

        int [] res = {-1, -1};
        if(nums == null || nums.length == 0) return res;

        int l = 0;
        int h = nums.length -1;
        while(l <= h){
            int mid = l + (h-l) /2;

            if(nums[mid] >target){
                h = mid -1;
            }else if(nums[mid] < target){
                l = mid +1 ;
            }else {
                int tmp = mid;
                while(tmp >=0 && nums[tmp] == target){
                    tmp--;
                }
                res[0] = tmp + 1;

                tmp = mid;
                while(tmp < nums.length && nums[tmp] == target){
                    tmp++;
                }

                res[1] = tmp -1;
                break;
            }
        }
        return res;
    }
}
