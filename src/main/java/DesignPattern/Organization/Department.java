package Organization;

public class Department extends OrganizationComponent{

    public Department(String name, String des) {
        super(name, des);
    }

    //add ,remove方法不用再重写，因为这个是叶子节点
    @Override
    protected void print() {
        System.out.println(getName());
    }


}
