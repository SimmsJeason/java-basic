package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {
    List<Department> departmentList;

    public InfoCollege() {
        departmentList = new ArrayList<Department>();

        departmentList.add(new Department("信息安全", "学习信息安全课程"));
        departmentList.add(new Department("网络安全", "学习网络安全课程"));
        departmentList.add(new Department("服务器安全", "学习服务器安全课程"));
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String des) {

        departmentList.add(new Department(name, des));
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
