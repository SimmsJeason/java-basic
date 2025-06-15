package typicalAlgorithom.ByteCalculator;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int i = 0; i< nums.length ;i++){
            diff ^= nums[i];
        }

        /**
         * 两个不相等的元素在位级表示上必定会有一位存在不同。
         *
         * 将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
         *
         * diff &= -diff 得到出 diff 最右侧不为 0 的位，
         * 也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
         */

        diff = diff & (-diff);//得到最右边的 1 的位置
        int [] res = new int[2];

        for(int i : nums){
            if((i & diff) == 0) res[0] ^= i;
            else res[1] ^= i;
        }
        return res;
    }
}
