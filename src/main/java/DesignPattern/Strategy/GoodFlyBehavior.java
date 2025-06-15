package Strategy;

public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("很擅长飞行");
    }
}
