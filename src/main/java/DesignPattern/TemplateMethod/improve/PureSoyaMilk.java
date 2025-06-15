package TemplateMethod.improve;

public class PureSoyaMilk extends SoyaMilk {
    @Override
    public void addCondiments() {
        //空实现
    }

    @Override
    boolean customWantCondiments(){
        return  false;
    }
}
