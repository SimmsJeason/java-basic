package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {

    //信息工程学院以 List 的形式存放
    List<Department> departmentList;

    //索引
    int index = -1;
    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    //判断List中是否还有下一个
    @Override
    public boolean hasNext() {
        if(index >= departmentList.size()-1){
            return false;
        }else{
            index += 1;//为获取下一个作准备
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    @Override
    public void remove() {

    }
}
