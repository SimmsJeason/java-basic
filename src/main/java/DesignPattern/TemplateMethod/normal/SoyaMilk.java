package TemplateMethod.normal;

//抽象类 表示豆浆
public abstract class SoyaMilk {

    //模板方法 make, 模板方法可以做成final,不让子类去覆盖
    public final void make(){

        select();
        addCondiments();
        soak();
        beat();
    }

    //选材料
    public void select(){
        System.out.println("第一步：选取上好的黄豆");
    }
    //添加不同的配料，抽象方法，子类具体实现
    public abstract void addCondiments();

    //浸泡
    public void soak (){
        System.out.println("第三步：黄豆和配料浸泡3小时");
    }

    //打碎
    public void beat (){
        System.out.println("第四步：将浸泡好的黄豆和配料打碎成浆");
    }
}
