package Strategy;

//算法使用者
public abstract class Duck {

    //属性，策略接口
    FlyBehavior flyBehavior;

    public Duck() {
    }

    //显示鸭子信息
    public abstract void display();

    public void fly(){

        if(flyBehavior != null){
            flyBehavior.fly();
        }
    };
}
