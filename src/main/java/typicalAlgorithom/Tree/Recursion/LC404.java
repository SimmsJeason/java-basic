package typicalAlgorithom.Tree.Recursion;

import dto.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode node){
        if (node == null) return false;
        return node.left == null && node.right == null;
    }






  /*  int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

    }

    public void calculate ( TreeNode root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            sum += root.val;
            return;
        }
        calculate(root.left);
        calculate(root.right);
    }*/

}
