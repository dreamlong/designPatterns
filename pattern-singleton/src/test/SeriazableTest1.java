package test;

import seriazable.Seriazable1;

import java.io.*;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 09:39
 * @Description:
 */
public class SeriazableTest1 {

    public static void main(String[] args) {
        try{
            Seriazable1 o1 = Seriazable1.getInstance();
            OutputStream os = new FileOutputStream("Seriazable1.obj");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(o1);
            oos.flush();
            oos.close();

            InputStream is = new FileInputStream("Seriazable1.obj");
            ObjectInputStream ois = new ObjectInputStream(is);
            Object o2 = ois.readObject();
            ois.close();

            System.out.println(o1==o2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
