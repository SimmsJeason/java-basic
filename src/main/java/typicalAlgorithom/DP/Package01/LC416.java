package typicalAlgorithom.DP.Package01;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC416 {

    public static void main(String[] args) {
        LC416 test = new LC416();
        int [] nums = {1,2,5};
        System.out.println(test.canPartition1(nums));
    }

    public boolean canPartition(int[] nums){
        int sum = 0;
        int len = nums.length;
        for(int i = 0 ; i < len; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }

        int k = sum /2;
        boolean [][] dp = new boolean[len +1][k+1];

        /**
         * dp[i][j] = x表示，对于前i个物品，当前背包的容量为j时，若x为true，
         * 则说明可以恰好将背包装满，若x为false，则说明不能恰好将背包装满。
         */
        //base case
        for(int i = 0 ; i <= len; i++){
            dp[i][0] = true;
        }

        /**
         * dp[i][j] = dp[i-1][j]  nums[i-1]不放入是否可以恰好装满
         * dp[i][j] = dp[i-1][j - nums[i-1]]  nums[i-1] 放入是否可以恰好装满
         *
         */
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= k; j++){

                if(nums[i-1] > j){//容量为 j 的背包放不下 nums[i-1]的重量
                    dp[i][j] = dp[i-1][j];//继承上一次状态
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
    /*    for(int i = 0 ; i <= len; i ++){
            System.out.println(Arrays.toString(dp[i]));
        }*/

        return dp[len][k];
    }

    //官方答案
    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        if(n == 0) return false;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if((sum & 1) == 1) return false;

        int target = sum /2;
        boolean [][] dp = new boolean [n][target +1];

        //第一个数只能把和自身相等的填满
        if(nums[0] <= target ){
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i< n; i++){
            for(int j = 0; j<= target; j++){
                dp[i][j] = dp[i-1][j];//先将上层的拷贝下来
                if(nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i] < j) {
                    //        向下传递        j = (j - nums[j]) + nums[j]
                   dp[i][j] = dp[i-1][j] || dp[i-1][j- nums[i]];
                }

            }
        }

        return dp[n-1][target];
    }
}
