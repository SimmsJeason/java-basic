package Decorator;

public class Decorator extends Drink {

    private Drink obj;

    public Decorator(Drink obj) {//组合进来
        this.obj = obj;
    }

    public float cost() {

        //自身价格(配料价格)加上饮品加个
        return super.getPrice() + obj.getPrice();
    }

    @Override
    public String getDes() {
        return super.getDes() + " " + super.getPrice() + "&&" + obj.getDes();
    }
}
