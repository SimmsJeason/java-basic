package Iterator;

public class Department {
    private String name;
    private String des;

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

    public Department(String name, String des) {
        this.name = name;
        this.des = des;
    }
}
