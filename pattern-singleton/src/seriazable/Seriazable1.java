package seriazable;

import java.io.Serializable;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 09:37
 * @Description:
 */
public class Seriazable1 implements Serializable {

    private static final Seriazable1 INSTANCE = new Seriazable1();

    public static Seriazable1 getInstance(){
        return INSTANCE;
    }

    /**
     * 读取序列化对象到内存时，直接返回单例实例，而不是重新生成对象
     * @return
     */
    private Object readResolve(){
        return INSTANCE;
    }
}
