package typicalAlgorithom.Tree.Build;


import java.util.ArrayList;
import java.util.List;

public class preAndInfix2post {

List<Integer> post = new ArrayList<>();

    public static void main(String[] args) {
        preAndInfix2post pa = new preAndInfix2post();
        int[] pre = {1,2,4,5,3,6};
        int[] in = {4, 2, 5, 1, 6, 3};
        preAndInfix2post preA = new preAndInfix2post();
        preA.solute(pre, in);
    }

    public void solute(int [] pre, int [] infix){
        recursion(pre, 0, pre.length -1, infix, 0, infix.length-1);
        for (Integer i : post){
            System.out.print(i + " ");
        }
    }

    public void recursion(int [] pre, int p, int q,  int [] infix, int i, int j){
        if(p > q){
            return;
        }
        int root = pre[p];
        int k = i;
        while(pre[p] != infix[k]){
            k++;
        }
        //右子树的范围是： [p + 1, p + (k-m)]


        //left tree
        recursion(pre, p + 1, p + k - i, infix, i, k-1);
        //right
        recursion(pre, p + k -i+1,  q, infix, k+1, j);
        post.add(root);
    }

}




