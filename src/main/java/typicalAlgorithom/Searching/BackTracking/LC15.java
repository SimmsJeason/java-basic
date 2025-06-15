package typicalAlgorithom.Searching.BackTracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//回溯做不了，做不到去重
public class LC15 {
    public static void main(String[] args) {
        LC15 lc15 = new LC15();
        int [] array = {-1, 0, 1, 2, -1, -4};
       Arrays.sort(array);
        List<List<Integer>> res = lc15.solve(array);
        for(List<Integer> l : res) {
            l.forEach(i -> System.out.print(i + " "));
        }
        System.out.println();
    }

    public List<List<Integer>> solve(int [] array){
        List<List<Integer>> res = new ArrayList<>();
        boolean [] visited = new boolean[array.length];

        backTracking(new ArrayList<>(), res, 0, array, visited);
        return  res;
    }

    public void backTracking(List<Integer> cur, List<List<Integer>> res , int start , int[] array,  boolean [] visited ){


        if(cur.size() >3 || start >= array.length ||visited[start]){
            return;
        }

        if(cur.size() == 3){
            int sum = cur.get(0);
            sum += cur.get(1);
            sum += cur.get(2);

            if(sum == 0){
                res.add(new ArrayList<>(cur));
            }

            return;
        }

        for(int i = start; i < array.length; i ++){
            if(i >0 && array[i] == array[i-1] && visited[i-1]){
                continue;
            }
            visited[i] = true;
            cur.add(array[start]);
            backTracking(cur, res, i+1, array, visited);
            visited[i] = false;
            cur.remove(cur.size()-1);
        }

    }
}
