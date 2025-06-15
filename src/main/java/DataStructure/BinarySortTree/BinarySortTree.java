package BinarySortTree;

public class BinarySortTree {
    private Node root;

    public void add(Node node){
        if(root == null) {
            root = node;
        }else {
            root.add(node);
        }
    }

    //查找要删除的结点
    public Node search(int value){
        if(root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    //查找要删除结点的父节点
    public Node searchParent(int value){
        if(root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     *  删除右子树的最小结点并将最小值返回
     * @param node 传入的结点，视作是一个二叉树的根节点
     * @return 返回以node为根节点的二叉排序树的最小值
     */
    public int delRightTreeMin(Node node){
        Node tmp = node;
        while(tmp.left != null){
            tmp = tmp.left;
        }
        int min = tmp.value;
        delete(min);
        return min;
    }

    //删除结点
    public void delete(int value){

        if(root == null){
            return;
        }

        //如果只有一个根结点
        if(root.right == null && root.left == null){
            root = null;
            return;
        }

        Node targetNode = search(value);
        if(targetNode.left == null && targetNode.right == null){
            //当要删除的结点是叶子结点
            /**
             * 1. 找到要删除结点的父节点parent
             * 2. 判断该结点是父节点的左子结点还是右子结点
             * 3.根据前面的情况来删除  parent.right = null  \\ parent.left = null
             */
            Node parent = searchParent(value);
            if(parent.left != null && parent.left.value == value){
                parent.left = null;
            }else if(parent.right != null && parent.right.value == value){
                parent.right = null;
            }
        }else if(targetNode.right != null && targetNode.left != null){
            //要删除的结点左右子树都不为空
            /**
             * 1. 从targetNode的右子树找到最小值
             * 2. 用一个tmp 变量保存
             * 3. 删除最小结点， targetNode = tmp;
             */

            int min = delRightTreeMin(targetNode.right);
            targetNode.value = min;
        }else {//要删除的结点的左子树或者右子树有一个为空
            Node parent = searchParent(value);
            /**
             * 1. 判断要删除结点是父节点的左子结点还是右子结点
             * 2. 如果targetNode 有左子结点，
             * （1）如果targetNode 是parent 的左子结点 parent.left = target.left
             * （2）如果targetNode 是parent 的右子结点 parent.right = target.left
             * 3. 如果targetNode 有右子结点，
             * （1）如果targetNode 是parent 的左子结点 parent.left = target.right
             * （2）如果targetNode 是parent 的右子结点 parent.right = target.right
             */

            if(targetNode.left != null){
                if(parent != null){
                    if(parent.left != null && parent.left.value == value){
                        parent.left = targetNode.left;
                    }else if(parent.right != null && parent.right.value == value){
                        parent.right = targetNode.left;
                    }
                }else {
                    root = targetNode.left;
                }

            }else {
                if(parent != null){
                    if(parent.left != null && parent.left.value == value){
                        parent.left = targetNode.right;
                    }else if(parent.right != null && parent.right.value == value){
                        parent.right = targetNode.right;
                    }
                }else {
                    root = targetNode.right;
                }

            }
        }
    }

    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }else {
            System.out.println("当前二叉排序树为空");
        }
    }
}
