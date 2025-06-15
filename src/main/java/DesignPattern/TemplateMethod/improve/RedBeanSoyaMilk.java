package TemplateMethod.improve;

public class RedBeanSoyaMilk extends SoyaMilk {
    @Override
    public void addCondiments() {
        System.out.println("第三步：加入上好的红豆");
    }
}
