package typicalAlgorithom.Tree.Recursion;

import dto.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC110 {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) result = false;// 求深度的过程可以顺便完成判断操作
        return 1 + Math.max(l, r);
    }

    //自己写的
    public boolean isBalanced2(TreeNode root) {
        if(root == null || root.right == null && root.left == null){
            return true;
        }

        int depthLeft = depth(root.left);
        int depthRight = depth(root.right);

        if(Math.abs( depthLeft - depthRight ) >1){
            return false;
        }

        return isBalanced2(root.left) && isBalanced2(root.right);

    }

    public int depth(TreeNode root){
        if(root == null) return 0;

        return Math.max(depth(root.left), depth(root.right) ) + 1;
    }
}
