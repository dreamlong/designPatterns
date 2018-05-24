package test;

import lazy.LazyThree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 07:39
 * @Description:针对反射破解单例进行测试
 */
public class LazyTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<LazyThree> clazz = LazyThree.class;
        /**
         * 获取私有构造方法
         */
        Constructor<LazyThree> c =  clazz.getDeclaredConstructor(null);
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
        Object o2 = LazyThree.getInstance();

        System.out.println(o1 == o2);

        /**
         * 执行结果
         * false
         */
    }
}
