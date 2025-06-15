package Organization;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationComponent {

    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    public University(String name, String des) {
        super(name, des);
    }

    //重写add
    @Override
    protected void add(OrganizationComponent organizationComponent){
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent){
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public String getDes(){
        return super.getDes();
    }

    //输出该大学包含的学院
    protected void print() {

        System.out.println("-------------"+ getName() +"--------------");
        organizationComponents.forEach(o-> o.print());
    }
}
