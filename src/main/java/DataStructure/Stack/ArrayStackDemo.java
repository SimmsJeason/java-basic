package Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.list();

        int value = stack.pop();
        System.out.println("取出的值为：  " + value);
        stack.list();
    }


}

class ArrayStack{
    private int maxSize;
    private int [] stack;
    private int top = -1;//表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int [maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，抛出异常");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");
        }
        for (int i = top; i>=0; i--){
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }


}