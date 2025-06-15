package Singleton;

public class SingletonType6 {
    public static void main(String[] args) {

        System.out.println("懒汉式3 ， 线程安全");
        Singleton6 singleton61 = Singleton6.getInstance();
        Singleton6 singleton62 = Singleton6.getInstance();

        System.out.println(singleton61 == singleton62);
    }
}

    //懒汉式（双重检查）
    class Singleton6 {
        private static volatile Singleton6 instance;

        private Singleton6() {
        }

    //提供一个静态公共方法，加入双重检查代码，解决线程问题，同时解决懒加载问题

        public static synchronized Singleton6 getInstance(){
            if(instance == null){
                synchronized (Singleton6.class){
                    if(instance == null){
                        instance = new Singleton6();
                    }
                }
            }
            return instance;
        }
    }