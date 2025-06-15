package typicalAlgorithom.ArrayAndMatrix;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC287 {
    /**
     *我们定义 cnt[i] 表示 nums[] 数组中小于等于 i 的数有多少个，假设我们重复的数是 target，那么 [1,target−1]里的所有数满足 cnt[i]≤i，
     * [target,n] 里的所有数满足 cnt[i]>i，具有单调性。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findDuplicate(int[] nums) {

        int l = 1;
        int h = nums.length -1 ;
        while (l <= h){
            int mid = l + (h-l) /2;
            int cnt = 0;
            for (int i =0; i< nums.length; i++){
                if(nums[i] <= mid){
                    cnt ++;
                }
            }

            if(cnt <= mid) {
                l = mid +1;
            }else {
                h = mid -1;
            }
        }

        return l;
    }
}
