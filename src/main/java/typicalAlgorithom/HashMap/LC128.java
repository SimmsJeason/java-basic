package typicalAlgorithom.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC128 {

    //方法一: 先排序， 再统计，时间复杂度 O(n log n) + O(n）= O(n log n)

    // 利用HashMap
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, 1);
        }
        for (int num : nums) {
            forward(countForNum, num);
        }
        return maxCount(countForNum);
    }

    //获取后继连续数的长度
    private int forward(Map<Integer, Integer> countForNum, int num) {
        if (!countForNum.containsKey(num)) {
            return 0;
        }

        int cnt = countForNum.get(num);
        if (cnt > 1) {
            return cnt;
        }
        cnt = forward(countForNum, num + 1) + 1;
        countForNum.put(num, cnt);
        return cnt;
    }

    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, 1);//初始化,没用重复值，所以都设为1
        }

        //因为连续数列的起点不定
        for(int num : nums){
            forward2(num, count);
        }

        return maxCount(count);
    }

    public int forward2(int num, Map<Integer, Integer> map){
        if(!map.containsKey(num)) return 0;
        int cnt = map.get(num);
        System.out.println(cnt);
        //剪枝
        if(cnt >1){
            return cnt;
        }

        cnt = forward2(num +1, map) + 1;
        map.put(num, cnt);
        return cnt;
    }

    //记录map中 value的最大值
    private int maxCount(Map<Integer, Integer> countForNum) {
        int max = 0;
        for (int num : countForNum.keySet()) {
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }


}
