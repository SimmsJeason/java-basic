package Factory.simpleFactory.Pizza;

public abstract class Pizza {
    private String name;

    //准备原材料，不同的pizza使用的原材料不同,所以做成抽象方法
    public abstract void prepare();

    public void bake(){
        System.out.println(name + "baking ... ");
    }

    public void cut(){
        System.out.println(name + "cutting ... ");
    }

    public void box(){
        System.out.println(name + "boxing ... ");
    }

    public void setName(String name) {
        this.name = name;
    }
}
