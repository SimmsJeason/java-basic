package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resL = new ArrayList<>();
        if(nums == null || nums.length == 0) return resL;

        int n = nums.length;
        boolean [] visited = new boolean[n];
        List<Integer> res = new ArrayList<>();
        backTracking(nums, res, resL, visited);

        return resL;
    }

    public void backTracking(final int [] nums, List<Integer> res, List<List<Integer>> resL, boolean [] visited){
        if(res.size() == nums.length){
            resL.add(new ArrayList<>(res));//需要新new 一个list
            return;
        }

        for(int i = 0; i < visited.length; i++){
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
