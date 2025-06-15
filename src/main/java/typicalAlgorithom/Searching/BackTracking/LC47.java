package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resL = new ArrayList<>();
        if(nums == null || nums.length == 0) return resL;

        int n = nums.length;
        Arrays.sort(nums);//排序

        boolean [] visited = new boolean[n];
        List<Integer> res = new ArrayList<>();
        backTracking(nums, res, resL, visited);

        return resL;
    }

    /**
     *在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，判断这个元素是否等于前一个元素
     * ，如果等于，并且前一个元素还未访问，那么就跳过这个元素。
     */
    public void backTracking(final int [] nums, List<Integer> res, List<List<Integer>> resL, boolean [] visited){
        if(res.size() == nums.length){
            resL.add(new ArrayList<>(res));
            return;
        }

        for(int i = 0; i < visited.length; i++){
            if(i != 0 && nums[i] == nums[i - 1] && !visited[i]){
                continue;
            }

            if(visited[i]){
                continue;
            }

            visited[i] = true;
            res.add(nums[i]);
            backTracking(nums, res, resL, visited );

            //还原
            visited[i] = false;
            res.remove(res.size() -1);
        }
    }
}
