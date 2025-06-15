package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC216 {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        if(k == 0 || n == 0) return  res;

        boolean [] visited = new boolean[9];

        backTracking(new ArrayList<>(), res, 0, n, k, visited);
        return res;
    }

    public void backTracking(List<Integer> one , List<List<Integer>> res, int start, int n, int k, boolean [] visited){
        if(n == 0 || k == 0){
            if(n == 0 && k == 0){
                res.add(new ArrayList<>(one));
            }
            return;
        }

        for(int i = start; i< 9; i++){
            if(visited[i]) continue;

            //one list 中的数之和已经大于 目标数了
            if(n -i -1 >=0){
                visited[i] = true;
                one.add(i+1);

                backTracking(one, res, i, n- i -1, k-1, visited);

                visited[i] = false;
                one.remove(one.size() -1);
            }

        }
    }

}
