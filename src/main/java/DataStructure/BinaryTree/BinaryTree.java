package BinaryTree;

class BinaryTree {
    private HeroNode root;
    private HeroNode pre=null;//保留前一个节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadNodes4infixOder() {
        threadNodes4infixOder(root);
    }

    public void threadNodes4preOrder() {threadNodes4preOrder(root);}

    //中序线索化
    public void threadNodes4infixOder(HeroNode node) {
        if(node==null) {
            return;
        }

        //线索化左子树
        threadNodes4infixOder(node.getLeftNode());

        //处理当前节点的前驱节点
        if(node.getLeftNode()==null){
            node.setLeftNode(pre);
            node.setLeftType(1);
        }

        //处理后继节点，实际上是在递归的下一次才进行处理
        if(pre!=null && pre.getRightNode() == null) {
            //让前驱节点的的右指针指向当前节点
            pre.setRightNode(node);
            pre.setRightType(1);
        }
        //！！！！ 每处理一个节点后，让当前结点是下一个结点的前去结点
        pre=node;
        //线索化右子树
        threadNodes4infixOder(node.getRightNode());
    }

    //中序遍历
    public void infixOrder(){
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;

        while (node != null){

            //1. 循环的找到 leftType == 1的结点，即为中序遍历的第一个结点
            while(node.getLeftType() == 0){
                node = node.getLeftNode();
            }

            System.out.println(node.toString());

            //2. 如果当前结点的右指针指向的是后继结点，就一直输出
            while(node.getRightType() == 1){
                node = node.getRightNode();
                System.out.println(node.toString());
            }

            //3. 替换这个遍历的结点,因为是中序遍历，通过步骤2 ，可将所有的父节点找到并输出，只剩右节点还没涉及到
            node = node.getRightNode();
        }
    }

    //前序线索化
    public void threadNodes4preOrder(HeroNode node){
        if(node == null){
            return;
        }

        //处理当前结点
        if(node.getLeftNode() == null){
            node.setLeftNode(pre);
            node.setLeftType(1);
        }

        if(pre != null && pre.getRightNode() == null){
         pre.setRightNode(node);
         pre.setRightType(1);
        }

        pre = node;

        //如果左子结点不是前驱结点，递归向下，否则会死循环，导致栈溢出
        if(node.getLeftType() != 1){
            threadNodes4preOrder(node.getLeftNode());
        }

        if(node.getRightType() != 1){
            threadNodes4preOrder(node.getRightNode());
        }
    }

    public void preOrder(){

        HeroNode node = root;

        while (node != null){
            while (node.getLeftType() == 0 ){
                System.out.println(node.toString());
                node = node.getLeftNode();
            }

            while(node.getRightType() == 1){
                System.out.println(node.toString());
                node = node.getRightNode();
            }

            node = node.getRightNode();
        }
    }
}
