package Proxy.DynamicProxy;

public class Client {
    public static void main(String[] args) {

        //创建目标对象
        ITeacherDao target = new TeacherDao();

        //给目标对象创建代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        System.out.println("proxyInstance " + proxyInstance.getClass());

        //通过代理方法，调用目标对象的方法

        proxyInstance.sayHello("Tom");
    }
}
