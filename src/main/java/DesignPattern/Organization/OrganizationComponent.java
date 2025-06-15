package Organization;

public abstract class OrganizationComponent {
    private String name;
    private String des;//说明

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    protected void add(OrganizationComponent organizationComponent){
        throw  new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent){
        throw  new UnsupportedOperationException();
    }

    //抽象方法，打印信息
    protected abstract void print();
}
