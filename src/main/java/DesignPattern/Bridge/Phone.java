package Bridge;

public abstract class Phone {
    //聚合品牌
    private Brand brand;

    public Phone (Brand brand){
        this.brand = brand;
    }

    protected void open(){
        brand.open();
    }

    protected void close(){
        brand.close();
    }
    protected void call(){
        brand.call();
    }
}
