package typicalAlgorithom.DP.Package01;

import java.util.Arrays;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 * 进阶：
 * 如果给定的数组中含有负数会怎么样？
 * 问题会产生什么变化？
 * 我们需要在题目中添加什么限制来允许负数的出现？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中。

public class LV377 {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        LV377 lv377 = new LV377();
        System.out.println(lv377.solve(nums, 4));
    }
    /**
     *dp[i] 表示 target == i 的时候, 数组中的组合情况
     * dp[i] += dp[i - nums[j]]   ( j 含于 [0, i])
     */
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return  0;

        int [] dp = new int[target+1];

        dp[0] = 1;
        Arrays.sort(nums);

        for(int i = 1; i <= target ;i++){
            for(int j = 0; j < nums.length && nums[j] <= i; j ++){
                dp[i] += dp[i- nums[j]];
            }
        }

        return dp[target];
    }

    public int solve(int [] nums, int n){
        int [] dp = new int[n + 1];
        //base case
        dp[0] = 1;

        for(int i  = 1 ; i <= n; i ++){
            int min = 0;

            for(int j = 0 ; j<nums.length; j ++){
                if(i - nums[j] < 0)continue;
                min += dp[i - nums[j]];
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
