package typicalAlgorithom.Tree.Recursion;

import dto.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;  // 后面的操作会改变 left 指针，因此先保存下来
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    //自己写的
    public TreeNode invertTree2(TreeNode root) {
        TreeNode tmp = root;
        change(tmp);
        return root;
    }

    public void change(TreeNode root){
        if(root == null || root.left == null && root.right == null){
            return ;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        change(root.left);
        change(root.right);
    }
}
