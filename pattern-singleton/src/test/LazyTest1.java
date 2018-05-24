package test;

import lazy.LazyFour;
import lazy.LazyThree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 07:39
 * @Description:针对反射破解单例进行测试
 */
public class LazyTest1 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<LazyFour> clazz = LazyFour.class;
        /**
         * 获取私有构造方法
         */
        Constructor<LazyFour> c =  clazz.getDeclaredConstructor(null);
        /**
         * 暴力访问
         */
        c.setAccessible(true);
        /**
         * 反射新建一个对象
         */
        Object o1 = c.newInstance(null);
        /**
         * 直接获取单例实例
         */
        Object o2 = LazyFour.getInstance();

        System.out.println(o1 == o2);

        /**
         * 执行结果
         *  Exception in thread "main" java.lang.ExceptionInInitializerError
         *  at lazy.LazyFour.getInstance(LazyFour.java:26)
         *  at test.LazyTest1.main(LazyTest1.java:34)
         *  Caused by: java.lang.RuntimeException: 违反单例原则创建实例
         *  at lazy.LazyFour.<init>(LazyFour.java:17)
         *  at lazy.LazyFour.<init>(LazyFour.java:9)
         *  at lazy.LazyFour$LazyHolder.<clinit>(LazyFour.java:22)
         *  ... 2 more
         */
    }
}
