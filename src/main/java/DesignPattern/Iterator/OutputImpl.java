package Iterator;

import java.util.Iterator;
import java.util.List;

public class OutputImpl {
    //学院集合
    List<College>  collegeList;

    public OutputImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    //遍历所有学院，调用printDepartment 输出所有系
    public void printCollege(){
        //从collegeList中取出所有学院,通过java直接获取迭代器
        Iterator iterator = collegeList.iterator();

        while (iterator.hasNext()){
            //取出一个学院
            College college = (College)iterator.next();
            System.out.println("----------------" + college.getName() + "-----------------");
            printDepartment(college.createIterator());
        }
    }

    //遍历学院输出系
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department d = (Department)iterator.next();
            System.out.println(d.getName());
        }
    }
}
