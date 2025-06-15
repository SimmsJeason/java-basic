package Queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);//说明：设置4，但是有效数据最大是3，有一个空间是作为约定的
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("a(add):添加数据");
            System.out.println("g(get):得到数据");
            System.out.println("s(show):显示数据");
            System.out.println("q(quit):退出程序");
            System.out.println("h(head):查看队列的第一个数据");
            char text = s.next().charAt(0);
            switch (text) {
                case 'a':
                    System.out.println("请输入要添加的数据");
                    circleArrayQueue.addQueue(s.nextInt());
                    break;

                case 'g':
                    try {
                        System.out.println("得到的数据为" + circleArrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    circleArrayQueue.show();
                    break;
                case 'q':
                    s.close();//关闭输入器防止异常
                    loop = false;
                    break;
                case 'h':
                    circleArrayQueue.headQueue();
                    break;
            }
        }
    }
}

//创建数组队列类
class CircleArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//头指针
    private int rear;//尾指针
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建数组队列的构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        front = 0;//指向队列头部，即队列的第一个元素
        rear = 0;//指向队列尾部，指向队列尾的后一个数据
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列是否满了
    public boolean isFull() {
        //如果尾指针的下一个元素是front，则满了
        return (rear + 1) % maxSize == front;
    }

    //向队列中添加数据
    public void addQueue(int n) {
        //如果满了则输出异常不添加数据
        if (isFull()) {
            System.out.println("错误：队列已满不能再添加");
            return;
        }
        //没满，向当前位置所指的格子中添加数据(因为rear所指的格子是空的)
        arr[rear] = n;
        //指针后移
        rear = (rear + 1) % maxSize;//防止出界
    }

    //从队列中获得数据
    public int getQueue() {
        //如果队列是空的，抛出异常
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，不能取出数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //先输出，再后移front
        //1. 先把front对应的值保留到一个临时变量
        //2. 将front后移
        //3. 将临时变量返回
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    //将队列格式化输出
    public void show() {
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + (rear - front + maxSize) % maxSize; i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front];
    }
}
