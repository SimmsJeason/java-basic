package LinkedList;

public class Josephu {
    public static void main(String[] args) {

        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoys(5);
        //linkedList.showList();
        linkedList.josephu(1, 2, 5);
    }


}
//环形链表类
class CircleSingleLinkedList{

    //创建一个first节点，没有值
    private Boy first = null;

    //添加小孩节点
    public void addBoys (int number){
        if(number <1){
            System.out.println("Number 不合法");
            return;
        }

        //当前小孩
        Boy current = null;//是个地址指针，并不开辟新的地址，因为它不是基本数据类型，它是引用数据类型
        for(int i = 1; i<=number; i++){
            Boy newBoy = new Boy(i);
            //第一个小孩特别
            if( i == 1){
                first = newBoy;
                first.setNext(first);//构成环状
                current = first;//让current 指向第一个小孩
            }else {
                current.setNext(newBoy);
                newBoy.setNext(first);
                current = newBoy;
            }
        }
    }

    //遍历链表
    public void showList(){
        if (first == null){
            System.out.println("没有任何小孩");
            return;
        }
        //first不能动，只能通过辅助指针来遍历
        Boy current = first;

        while (true){
            System.out.printf("小孩的编号为%d \n", current.getNo());
            if(current.getNext() == first){
                break;
            }
            current = current.getNext();
        }

    }

    public void josephu(int start, int num){
        Boy tmp = first;
        Boy pre = null;

        //从start号开始
        while(true){
            if (tmp.getNo() == start){
                break;
            }else {
                pre = tmp;
                tmp = tmp.getNext();
            }
        }

        int flag = 1;
        while(true){
            if(tmp.getNext() == tmp){
                System.out.printf("小孩编号为： %d \n", tmp.getNo());
                break;
            }
            if(flag == num){
                System.out.printf("小孩编号为： %d \n", tmp.getNo());
                tmp = tmp.getNext();
                pre.setNext(tmp);
                flag = 1;

            }else {
                flag ++;
                pre = tmp;
                tmp = tmp.getNext();
            }
        }
    }

    public void josephu(int startNo, int countNum, int numbers){
        if(first == null || startNo<1 || startNo > numbers){
            System.out.println("输入参数有误 ---");
            return;
        }

        //lastNode ,最后一个节点，由于是环状的，其实就是first的前一个节点
        Boy last = first;
        while (true){
            if(last.getNext() == first){
                break;
            }
            last = last.getNext();
        }

        //先将first和last都移动到开始地址：startNo
        for(int i = 0; i<startNo-1; i++){
            first = first.getNext();
            last = last.getNext();
        }

        //开始报数
        while(true){
            if(last == first){//此时圈中只有一个小孩,即最后出圈的小孩
                System.out.printf("小孩编号为： %d \n", first.getNo());
                break;
            }

            for(int i = 0; i< countNum-1; i++){

                first = first.getNext();
                last = last.getNext();
            }

            //此时first指向的为要出圈的小孩
            System.out.printf("小孩编号为： %d \n", first.getNo());

            first =first.getNext();
            last.setNext(first);
        }
    }
}

//节点类
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

