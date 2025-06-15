package BinaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "jack");
        HeroNode node1 = new HeroNode(3, "tom");
        HeroNode node2 = new HeroNode(6, "mike");

        root.setLeftNode(node1);
        root.setRightNode(node2);
        binaryTree.setRoot(root);

        HeroNode node3 = new HeroNode(8, "林冲");
        HeroNode node4 = new HeroNode(10, "关胜");
        node1.setLeftNode(node3);
        node1.setRightNode(node4);
        HeroNode node5 = new HeroNode(14, "jerry");
        node2.setLeftNode(node5);

        System.out.println("---中序---");

//中序线索化二叉树
        binaryTree.threadNodes4infixOder();
        //binaryTree.infixOrder();
        binaryTree.preOrder();
        //binaryTree.threadNodes4preOrder();
        //HeroNode afterHeroNode10 = node4.getRightNode();
       // System.out.println(afterHeroNode10.toString());// no=1 name=jack ok了
    }}
