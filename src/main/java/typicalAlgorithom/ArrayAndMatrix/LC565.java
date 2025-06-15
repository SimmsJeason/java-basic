package typicalAlgorithom.ArrayAndMatrix;

/**
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *  
 *
 * 提示：
 *
 * N是[1, 20,000]之间的整数。
 * A中不含有重复的元素。
 * A中的元素大小在[0, N-1]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-nesting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC565 {
    public int arrayNesting(int[] nums) {
        int max = 0;

        for(int i = 0; i< nums.length; i++){
            int cur = 2;
            int j = nums[i];
            if(j == i) cur =1;

            while(nums[j] != i){
                j = nums[j];
                cur ++;
            }

            max = Math.max(max, cur);
        }

        return max;
    }

    /**
     *如果从一个位置开始嵌套查找直到找到一个重复元素，这个过程中所找过的所有元素会形成一个闭环，
     * 也就是闭环之外不会有索引指向环内元素，以[5,4,0,3,1,6,2]为例，在5这个位置按照值-索引会形成
     * 0-5,5-6,6-2,2-0，而nums包含0~N-1，加上索引，每个数都是出现两次，
     * 这就是为什么闭环之外不会有索引指向环内元素；
     * （tips:HashSet比ArrayList有更高的查找效率，时间消耗比是12ms:1125ms）
     *
     * 作者：zackqf
     * 链接：https://leetcode-cn.com/problems/array-nesting/solution/javaqiu-jie-de-si-kao-yu-gai-jin-by-zackqf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int arrayNesting2(int[] nums) {

        //找闭环
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                nums[j] = -1; // 标记该位置已经被访问
                j = t;

            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
