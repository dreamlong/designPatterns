package test;

import lazy.LazyFour;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 07:39
 * @Description:针对反射破解单例进行测试，LazyFour仍然可以用过反射破解
 */
public class LazyTest2 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

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
         * 获取flag，然后修改
         */

        Field flagField = LazyFour.class.getDeclaredField("flag");
        flagField.setAccessible(true);
        flagField.set(LazyFour.class,false);
        System.out.println(flagField.get(null));

        /**
         * 直接获取单例实例
         */
        Object o2 = LazyFour.getInstance();

        System.out.println(o1 == o2);

        /**
         * 执行结果
         *  false
         *  false
         */
    }
}
