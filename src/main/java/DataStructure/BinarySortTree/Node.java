package BinarySortTree;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){
        if(node == null){
            return;
        }
        //判断传入结点的值与当前子树的根结点的关系
        if(node.value < this.value){//出入结点比当前结点小
            if(this.left == null){
                this.left = node;
            }else {
                //递归的向左子树添加结点
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    //查找要删除的结点
    public Node search(int value){

        if(this.value == value){
            return this;
        }else if(value < this.value){//如果查找的值小于当前值，向左子树递归查找
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    /***
     * 查找要删除结点的父节点
     * @param value
     * @return
     */
    public Node searchParent(int value){

        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            //如果要查找的值小于当前结点， 并且当前结点有左子节点
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);

            }else if(value >= this.value && this.right != null){//如果要查找的值大于当前结点， 并且当前结点有右子节点
                return this.right.searchParent(value);
            }else{
                return null;//没有找到父节点
            }
        }

    }

    //中序遍历
    public void infixOrder(){

        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
}
