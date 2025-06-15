package Proxy.DynamicProxy;

public class TeacherDao  implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师 正在授课中 。。。");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

}
