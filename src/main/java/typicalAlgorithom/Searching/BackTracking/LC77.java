package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC77 {

    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new LinkedList(curr));

        for (int i = first; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }


    /*************************  该题只是找组合， [1,2] 和 [2,1] 是同一个结果  *********************************************/
    public List<List<Integer>> combine2(int n, int k) {

        List<List<Integer>> resL = new ArrayList<>();
        if(n < k|| k == 0 || n ==0) return resL;
        List<Integer> res = new ArrayList<>();
        boolean [] visited = new boolean[n];
        backTracking(n, k, res, resL, visited);
        return resL;
    }

    public void backTracking(int n, int k , List<Integer> res , List<List<Integer>> resL, boolean [] visited){
        if(res.size() == k){
            resL.add(new ArrayList<>(res));
            return;
        }

        for(int i = 0; i< n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            res.add(i+1);
            backTracking(n, k, res, resL, visited);

            visited[i] = false;

            res.remove(res.size() -1);
        }
    }
}
