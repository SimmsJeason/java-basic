package typicalAlgorithom.Sort;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC347 {

    public int[] topKFrequent1(int[] nums, int k) {
        // key: 元素，value: 出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int times = map.getOrDefault(num, 0);
            map.put(num, times + 1);
        }

        // 大顶堆
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> (map.get(o2) - map.get(o1)));
        for (int key : map.keySet()) {
            pq.add(key);
        }
        int[] ans = new int[k];
        int index = 0;
        while (index < k) {
            ans[index++] = pq.poll();
        }
        return ans;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyForNum = new HashMap<>();

        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            //以 出现的频率作为数组的下标
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            //出现相同频率的值 在一个同list中
            buckets[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();

        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }

            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }
}
