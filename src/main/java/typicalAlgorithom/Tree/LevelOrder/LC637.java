package typicalAlgorithom.Tree.LevelOrder;

import dto.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();//重点
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ret.add(sum / cnt);
        }
        return ret;
    }

    public List<Double> averageOfLevels2(TreeNode root) {

        List<Double> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<TreeNode> curLevel = new ArrayList<>();
            Double sum = 0.0;
            while (!queue.isEmpty()){
                curLevel.add(queue.poll());
            }

            for(TreeNode curNode : curLevel){
                sum += curNode.val;

                if(curNode.left != null){
                    queue.add(curNode.left);
                }

                if (curNode.right != null){
                    queue.add(curNode.right);
                }
            }

            Double tmp = sum / curLevel.size();
            res.add(tmp);
        }

        return res;
    }
}
