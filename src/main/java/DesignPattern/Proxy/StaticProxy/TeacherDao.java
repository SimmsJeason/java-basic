package Proxy.StaticProxy;

public class TeacherDao  implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("老师 正在授课中 。。。");
    }

}
