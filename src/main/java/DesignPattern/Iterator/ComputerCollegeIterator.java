package Iterator;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator {

    //这里需要department,区别是以怎样的形式存放=>数组
    Department [] departments;

    //遍历的位置
    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(position >= departments.length || departments[position] == null){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    @Override
    public void remove() {

    }
}
