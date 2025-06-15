package Visitor;

import java.util.LinkedList;
import java.util.List;

//数据结构，管理了很多人(man, woman)
public class ObjectStructure {

    //维护了一个集合
    private List<Person> persons = new LinkedList<>();

    //添加到list
    public void attach(Person p){
        persons.add(p);
    }

    //删除
    public void detach(Person p){
        persons.remove(p);
    }

    //显示评测情况
    //Action 为访问者
    public void display(Action action){
        persons.forEach(p->p.accept(action));
    }

}
