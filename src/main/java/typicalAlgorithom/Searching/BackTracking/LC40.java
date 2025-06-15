package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0 ){
            return res;
        }
        boolean [] visited = new boolean[candidates.length];
        Arrays.sort(candidates);//排序为后面做准备
        backTracking(candidates, target, 0, new ArrayList<>(), res, visited);
        return res;
    }

    public void backTracking(int [] candidates, int target, int start, List<Integer> one, List<List<Integer>> res, boolean[] visited){
        if(target == 0){
            res.add(new ArrayList<>(one));
        }

        for(int i = start; i < candidates.length; i++){
            if(visited[i]) {
                continue;
            }

            //有重复元素时加上这一句
            if(i > 0 && candidates[i-1] == candidates[i] && !visited[i-1]) continue;

            if (candidates[i] <= target) {
                visited[i] = true;
                one.add(candidates[i]);
                backTracking(candidates, target-candidates[i], i, one, res, visited);

                visited[i] = false;
                one.remove(one.size() -1);
            }

        }
    }
}
