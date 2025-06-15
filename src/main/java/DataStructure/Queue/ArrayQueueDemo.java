package Queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("a(add):添加数据");
            System.out.println("g(get):得到数据");
            System.out.println("s(show):显示数据");
            System.out.println("q(quit):退出程序");
            char text = s.next().charAt(0);//接收一个字符
            switch (text){
                case 'a':
                    System.out.println("请输入要添加的数据");
                    arrayQueue.addQueue(s.nextInt());
                    break;
                case 'g':
                    try{
                        System.out.println("得到的数据为");
                        arrayQueue.getQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    arrayQueue.show();
                    break;
                case 'q':
                    s.close();//关闭输入器防止异常
                    loop = false;
                    break;
            }
        }
    }
}
//创建数组队列类
class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//头指针
    private int rear;//尾指针
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建数组队列的构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列尾部，指向队列尾（即队列最后一个数据）
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }
    //判断队列是否满了
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //向队列中添加数据
    public void addQueue(int n){
        //如果满了则输出异常不添加数据
        if (isFull()){
            System.out.println("错误：队列已满不能再添加");
            return;
        }
        //没满，则指针后移，向指针所指的格子中添加数据
        rear++;
        arr[rear] = n;
    }
    //从队列中获得数据
    public int getQueue(){
        //如果队列是空的，抛出异常
        if (isEmpty()){
            throw new RuntimeException("队列是空的，不能取出数据");
        }
        //指针后移返回数据
        front++;
        return arr[front];
    }
    //将队列格式化输出
    public void show(){
        if (isEmpty()){
            System.out.println("队列是空的，没有数据");
            return;
        }

        for (int i = 0; i<arr.length;i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }
}