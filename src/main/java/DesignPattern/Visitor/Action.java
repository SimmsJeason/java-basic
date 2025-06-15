package Visitor;

public abstract class Action  {
    //得到男性的评测结果
    public abstract void getManResult(Man man);

    //得到女性的评测结果
    public abstract void getWomanResult(Woman woman);
}
