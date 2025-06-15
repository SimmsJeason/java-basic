package TemplateMethod.improve;

public class Client {
    public static void main(String[] args) {

        //制作红豆豆浆

        System.out.println("----------制作红豆豆浆-----------");
        SoyaMilk soyaMilk = new RedBeanSoyaMilk();
        soyaMilk.make();

        //制作纯豆浆

        System.out.println("---------纯豆浆---------");
        SoyaMilk pureSoya  = new PureSoyaMilk();
        pureSoya.make();
    }
}
