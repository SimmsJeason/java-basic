package typicalAlgorithom.Tree.Build;

import java.util.ArrayList;
import java.util.List;

public class postAndInfix2pre {
    List<Integer> pre = new ArrayList<>();

    public static void main(String[] args) {
        int [] post = {4,5,2,6,3,1};
        int [] infix = {4,2,5,1,6,3};
        postAndInfix2pre p = new postAndInfix2pre();
        p.solute(post, infix);
    }

    public int[] solute(int [] post, int [] infix){

        recursion(post, 0, post.length -1, infix, 0, infix.length -1);

        for(Integer i : pre){
            System.out.print(i + " ");
        }
        return null;
    }

    public void recursion(int [] post, int p, int q,  int [] infix, int i, int j){
        if(p > q){
            return;
        }

        if(p == q){
            pre.add(post[p]);
            return;
        }

        int root = post[q];

        int k = j;


        while(root != infix[k]){
            k--;
        }

        int rightLen = j - k;

        pre.add(root);
        //left
        recursion(post, p, q-rightLen-1, infix, i, k-1);

        //right
        recursion(post, q-rightLen, q-1, infix, k+1, j);

    }
}
