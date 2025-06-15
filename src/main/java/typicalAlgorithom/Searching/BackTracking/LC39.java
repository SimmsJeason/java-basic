package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * build(pre, indix, i, 0, n-1, 0);
 */
public class LC39 {

    int aim = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0 ) return res;

        aim = target;
        List<Integer> one = new ArrayList<>();

        backTracking(candidates, one, res, 0, 0);

        return res;
    }

    //为了防止重复的情况，需要加一个开始循环的下标 start ，比如 [2,3,3]和[3,2,3]是同一个结果，只需要保留一个
    public void backTracking(int [] candidates, List<Integer> one, List<List<Integer>> res, int sum, int start){
        if(sum == aim){
            res.add(new ArrayList<>(one));
            return;
        }

        if(sum > aim){
            return;
        }

        for(int i = start; i<candidates.length; i++){
            one.add(candidates[i]);
            backTracking(candidates, one, res, sum + candidates[i], i);

            one.remove(one.size() -1);//还原

        }
    }

}
