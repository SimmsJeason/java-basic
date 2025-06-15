package Iterator;

import java.util.Iterator;

public class ComputerCollege implements College {
    Department [] departments;
    int number = 3;

    public ComputerCollege() {
        departments = new Department[5];
        departments[0] = new Department("Java专业", "学习Java课程");
        departments[1] = new Department("Python专业", "学习Python课程");
        departments[2] = new Department("PHP专业", "学习PHP课程");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String des) {

        Department department = new Department(name, des);
        departments[number] = department;
        number += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
