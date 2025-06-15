package typicalAlgorithom.Tree.Recursion;

import dto.TreeNode;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *  
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC654 {

    /**
     *伪代码
     *
     *  public TreeNode constructMaximumBinaryTree([3,2,1,6,0,5]) {
     *
     *         TreeNode root = new TreeNode(6);
     *         root.left = constructMaximumBinaryTree([3,2,1])
     *         root.right = constructMaximumBinaryTree([0,5])
     *
     *     }
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if(nums == null || nums.length == 0) return null;

        return build(nums, 0, nums.length-1);
    }
    private TreeNode build(int[] nums, int l, int h){
        if(l > h){
            return null;
        }
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i = l; i <= h; i ++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = build(nums, l, index -1);
        root.right = build(nums, index +1, h);
        return root;
    }
}
