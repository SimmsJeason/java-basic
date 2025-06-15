package typicalAlgorithom.Tree.Build;

import dto.TreeNode;

public class PostAndInfix2Build {

    public static void main(String[] args) {
        PostAndInfix2Build pa = new PostAndInfix2Build();
        int[] post = {9,3,15,20,7};
        int[] in = {9,15,7,20,3};
        TreeNode root = pa.buildTree(post, in);
        System.out.println(root.val);
    }

  /*  public TreeNode reConstructBinaryTree(int [] post, int [] in) {
        return build(post, 0, post.length -1, in , 0, in.length -1);
    }*/

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length -1, postorder , 0, postorder.length -1);
    }

   public TreeNode build (int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd){

        if(postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootVal = root.val;
        int index = 0;

       for(int k = inStart; k <= inEnd; k++){
           if(rootVal == inorder[k] ){
               index = k;
               break;
           }
       }

        //index 为根节点在中序遍历的位置
        int leftTreeLen = index - inStart;

           root.left = build(inorder, inStart, index - 1,
                   postorder, postStart, postStart + leftTreeLen - 1);

           root.right = build(inorder, index + 1, inEnd,
                   postorder, postStart + leftTreeLen, postEnd - 1);

    return root;
    }
}
