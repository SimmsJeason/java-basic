package typicalAlgorithom.Tree.Recursion;

import Utils.TestUtil;
import dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC94 {
    public static void main(String[] args) {
        LC94 lc94 = new LC94();
        int [] nums = {1,2,3,4,5};
        TestUtil util = new TestUtil();
        TreeNode root = util.buildTree(nums);
        List<Integer> res = lc94.inorderTraversal2(root);
        res.forEach(r-> System.out.print(r + " "));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            res.add(node.val);
            cur = node.right;
        }

        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root){

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }

            TreeNode tmp = stack.pop();

            res.add(tmp.val);

            cur = tmp.right;
        }

        return res;
    }
}
