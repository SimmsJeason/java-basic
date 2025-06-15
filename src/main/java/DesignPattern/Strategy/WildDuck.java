package Strategy;

public class WildDuck extends Duck {

    //构造器，传入FlyBehavior 对象

    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {

        System.out.println("野生鸭");
    }
}
