package typicalAlgorithom.Searching.BFS;

import dto.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC111 {
    public int minDepth(TreeNode root) {

        if(root == null) return 0;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ; i < size; i++){
                TreeNode cur = queue.poll();

                if(cur.left == null && cur.right == null){
                    return depth;
                }
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur. right != null){
                    queue.add(cur.right);
                }
            }
            depth ++;
        }
        return depth;
    }
}
