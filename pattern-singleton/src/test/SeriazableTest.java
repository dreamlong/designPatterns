package test;

import seriazable.Seriazable;

import java.io.*;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 09:39
 * @Description:
 */
public class SeriazableTest {

    public static void main(String[] args) {
        try{
            Seriazable o1 = Seriazable.getInstance();
            OutputStream os = new FileOutputStream("Seriazable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(o1);
            oos.flush();
            oos.close();

            InputStream is = new FileInputStream("Seriazable.obj");
            ObjectInputStream ois = new ObjectInputStream(is);
            Object o2 = ois.readObject();
            ois.close();

            System.out.println(o1==o2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
