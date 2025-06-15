package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtracking(0, tempSubset, subsets, size, nums); // 不同的子集大小
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets,
                              final int size, final int[] nums) {

        if (tempSubset.size() == size) {
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempSubset.add(nums[i]);
            backtracking(i + 1, tempSubset, subsets, size, nums);
            tempSubset.remove(tempSubset.size() - 1);
        }
    }


    int len = 0;
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        len = nums.length;

        if(nums == null || nums.length == 0) return res;
        boolean [] visited = new boolean[len];

        return res;
    }

    public void backTracking(List<List<Integer>> res, List<Integer> one, int [] nums, int start, boolean[] visited){
        if(start == len -1){
            res.add(new ArrayList<>(one));
            return;
        }

        for(int i = start; i < len; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            one.add(nums[i]);
            backTracking(res, one, nums, i, visited);
            visited[i] = false;
            one.remove(one.size() - 1);
        }
    }

}
