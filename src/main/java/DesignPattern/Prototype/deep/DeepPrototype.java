package Prototype.deep;

import java.io.*;

public class DeepPrototype implements Serializable,Cloneable {

    public String name;
    public DeepCloneableTarget deepCloneableTarget;

    public DeepPrototype() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;

        //完成对基本数据类型的克隆
        deep = super.clone();
        DeepPrototype deepPrototype = (DeepPrototype)deep;
        //对引用的类型进行单独处理
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget)deepCloneableTarget.clone();

        return deepPrototype;
    }

    public DeepPrototype deepClone (){
        ByteArrayOutputStream   bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try{

            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//当前这个对象以对象流的方式输出

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepPrototype deepPrototype = (DeepPrototype) ois.readObject();
            return deepPrototype;
        }catch (Exception e){
            return null;
        }finally {
            try {
                bos.close();
                bis.close();
                ois.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
