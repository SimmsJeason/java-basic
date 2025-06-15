package BinaryTree;

public class HeroNode {
    private String name;
    private int no;
    
    private HeroNode leftNode;
    private HeroNode rightNode;

    private int leftType;//如果leftType == 0, 表示指向的是左子树，如果leftType == 1表示指向前驱节点
    private int rightType;//如果rightType == 0, 表示指向的是右子树，如果rightType == 1表示指向后继节点

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public HeroNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HeroNode leftNode) {
        this.leftNode = leftNode;
    }

    public HeroNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(HeroNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
