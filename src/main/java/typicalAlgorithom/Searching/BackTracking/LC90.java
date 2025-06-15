package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) return res;

        Arrays.sort(nums);//排序
        boolean [] visited = new boolean[len];

        for(int size = 0; size <= len; size++){
            backTracking(res, new ArrayList<>(), size, 0, nums, visited);
        }

        return res;
    }

    public void backTracking(List<List<Integer>> res , List<Integer> one, int size, int start, int [] nums, boolean[] visited){
        if(one.size() == size){
            res.add(new ArrayList<>(one));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            one.add(nums[i]);
            visited[i] = true;
            backTracking(res, one, size, i + 1, nums, visited);
            one.remove(one.size() -1);
            visited[i] = false;
        }
    }
}
