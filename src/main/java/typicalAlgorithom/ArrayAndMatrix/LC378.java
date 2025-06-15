package typicalAlgorithom.ArrayAndMatrix;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC378 {
    /**
     *可以这样描述走法：
     *
     * 初始位置在 matrix[n - 1][0]matrix[n−1][0]（即左下角）；
     *
     * 设当前位置为 matrix[i][j]matrix[i][j]。若 matrix[i][j] \leq midmatrix[i][j]≤mid，则将当前所在列的不大于 midmid 的数的数量（即 i + 1i+1）累加到答案中，并向右移动，否则向上移动；
     *
     * 不断移动直到走出格子为止。
     *
     * 我们发现这样的走法时间复杂度为 O(n)O(n)，即我们可以线性计算对于任意一个 midmid，矩阵中有多少数不大于它。这满足了二分查找的性质。
     *
     * 不妨假设答案为 xx，那么可以知道 l\leq x\leq rl≤x≤r，这样就确定了二分查找的上下界。
     *
     * 每次对于「猜测」的答案 midmid，计算矩阵中有多少数不大于 midmid ：
     *
     * 如果数量不少于 kk，那么说明最终答案 xx 不大于 midmid；
     * 如果数量少于 kk，那么说明最终答案 xx 大于 midmid。
     * 这样我们就可以计算出最终的结果 xx 了。
     *
     */

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
