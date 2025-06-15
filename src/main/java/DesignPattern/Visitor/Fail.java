package Visitor;

public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男性 评测该歌手 失败");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女性 评测该歌手 失败");
    }
}
