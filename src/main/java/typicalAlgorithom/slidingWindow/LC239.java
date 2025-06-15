package typicalAlgorithom.slidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC239 {
    //大测试集 超时
    public int[] maxSlidingWindow(int[] nums, int k) {

        //建立大根堆
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int n = nums.length;
        if(n == 0) return nums;

        int[] res = new int[n-k +1];

        int index = 0;

        for(int i = 0; i< n; i++){

            //移除第一个元素
            if(max.size() >= k){
                max.remove(nums[i-k]);
            }

            max.offer(nums[i]);

            if(i >= k-1){
                res[index++] = max.peek();
            }
        }
        return res;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int result[] = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            //此时不能用 treeMap 的大小和 k 比较, 因为 nums 中有相等的元素
            //当 i >= k 的时候每次都需要删除一个元素
            if (i >= k) {
                Integer v = treeMap.get(nums[i - k]);
                if (v == 1) {
                    treeMap.remove(nums[i - k]);
                } else {
                    treeMap.put(nums[i - k], v - 1);
                }
            }
            //添加元素
            Integer v = treeMap.get(nums[i]);
            if (v == null) {
                treeMap.put(nums[i], 1);
            } else {
                treeMap.put(nums[i], v + 1);
            }
            //更新 result
            if (i >= k - 1) {
                result[index++] = treeMap.firstKey();
            }
        }
        return result;
    }

}
