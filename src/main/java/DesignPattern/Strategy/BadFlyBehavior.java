package Strategy;

public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("会飞行，但是飞的不好");
    }
}
