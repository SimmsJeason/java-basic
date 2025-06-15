package Decorator;

public class Client {
    public static void main(String[] args) {
        //点一杯意大利咖啡
        Drink order = new EspressoCoffee();
        System.out.println(order.getDes());
        System.out.println("费用是： " + order.cost());
        // 加一杯牛奶
        order = new Milk(order);
        System.out.println("加一杯牛奶的费用：" + order.cost());
        System.out.println(order.getDes());
    }
}
