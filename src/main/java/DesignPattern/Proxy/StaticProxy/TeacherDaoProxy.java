package Proxy.StaticProxy;

public class TeacherDaoProxy implements ITeacherDao{
    TeacherDao target;

    public TeacherDaoProxy(TeacherDao teacherDao) {
        this.target = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("代理模式进行操作 。。。");
        target.teach();//目标对象操作
        System.out.println("提交  ！！！");
    }
}
