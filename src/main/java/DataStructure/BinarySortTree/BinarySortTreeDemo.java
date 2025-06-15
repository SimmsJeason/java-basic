package BinarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int [] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i = 0; i < arr.length; i++){
            Node node = new Node(arr[i]);
            binarySortTree.add(node);
        }
        binarySortTree.delete(5);
        binarySortTree.delete(1);
        binarySortTree.infixOrder();//1,2,3,5,7,9,10,12
    }
}
