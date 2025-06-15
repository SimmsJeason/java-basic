package Singleton;

import sun.font.DelegatingShape;

public class SingletonType3 {
    public static void main(String[] args) {

    }
}

//懒汉式（线程不安全）
class Singleton3{
  private static Singleton3 instance;

  private Singleton3(){ }

  //提供一个静态公共方法，当使用该方法时才去创建instance

    public static Singleton3 getInstance(){
      if(instance == null)
          instance = new Singleton3();
        return instance;
      }
}