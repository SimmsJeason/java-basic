package typicalAlgorithom.Tree.Recursion;

import dto.TreeNode;

import java.util.HashMap;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC437 {

    //方法一： 双层DFS

    int ans = 0;
    public  int pathSum1(TreeNode root, int sum){

        if(root == null){
            return ans;
        }
        dfs(root, sum);

        pathSum1(root.left, sum);
        pathSum1(root.right, sum);
        return ans;
    }

    public void dfs(TreeNode root, int sum){
        if(root == null){
            return ;
        }
        sum -= root.val;
        if(sum == 0) ans ++;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    //方法二 : 单层递归，通过Map计数

    /**
     *DFS遍历，在遍历的过程中每搜寻一个新结点，都计算一次从根节点到当前结点的路径和，并使用一个哈希表存储该数值。
     * 寻找子路径只需要作如下判断：（当前路径和-sum）是否曾在哈希表中存储过，存储过几次就说明存在几条路径。
     *
     * 作者：zhou-fu
     * 链接：https://leetcode-cn.com/problems/path-sum-iii/solution/jie-jian-zi-shu-zu-wen-ti-chang-yong-de-si-lu-jie-/
     */

    public int pathSum(TreeNode root, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return dfs(root,map,sum,0);
    }

    int dfs(TreeNode root, HashMap<Integer,Integer> map, int sum, int i){
        if (root == null) return 0;
        i+=root.val;
        int cnt = map.getOrDefault(i - sum, 0);
        map.put(i,map.getOrDefault(i , 0)+1);
        cnt+= dfs(root.left,map,sum,i);
        cnt+= dfs(root.right,map,sum,i);
        map.put(i,map.get(i)-1);
        return cnt;
    }

/*
    int count = 0;
    public int pathSum2(TreeNode root, int sum) {
        if(root == null) return  count;

        if(sum - root.val == 0){
            count ++;
        }

        pathSum2(root.left, sum-root.val);
        pathSum2(root.right, sum - root.val);

        return count;
    }*/
}
