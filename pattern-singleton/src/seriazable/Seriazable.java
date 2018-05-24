package seriazable;

import java.io.Serializable;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 09:37
 * @Description:序列化单例，当反序列化的时候，读取到内存的对象会重新生成，从而破坏单例原则
 */
public class Seriazable implements Serializable {

    private static final Seriazable INSTANCE = new Seriazable();

    public static Seriazable getInstance(){
        return INSTANCE;
    }
}
