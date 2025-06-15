package typicalAlgorithom.Tree.Build;

import dto.TreeNode;

public class preAndInfix2Build {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return build(pre, 0, pre.length -1, in, 0, in.length -1);
    }

    public TreeNode build (int [] pre, int p, int q, int [] in ,int i, int j){

        if(p > q) return null;
        if(p == q) return  new TreeNode(pre[p]);

        TreeNode node = new TreeNode(pre[p]);
        int k = i;//子树在中序序列数组的起始脚标

        while(pre[p] != in[k]) k++;//求得子树结束的角标，k-i 为子树的长度
        //left tree
        node.left = build(pre, p+1, p+k-i, in, i, k-1);
        // right tree
        node.right = build(pre, p+k-i+1, q, in, k+1, j);

        return node;
    }
}
