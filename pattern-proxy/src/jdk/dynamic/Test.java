package jdk.dynamic;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: liumenglong
 * @Date: 2018/5/26 22:09
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Boy boy = new Boy();
//        Object obj = new JDKMeipo().getInstance(boy);
//        /**
//         * 这里代理类执行了obj的toString方法，toString方法也被代理
//         */
//        System.out.println(obj);
//        Boy obj = (Boy)new JDKMeipo().getInstance(boy);
//        System.out.println(obj);

        /**
         * 执行结果：
         * Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to jdk.dynamic.Boy
         * at jdk.dynamic.Test.main(Test.java:17)
         * 由此可见，代理类并没有继承boy，而只是实现了Object的方法，从这里也引出了一个点：jdk动态代理的类需实现相关接口
         * 那么将Boy实现接口Person
         */
        Person obj = (Person)new JDKMeipo().getInstance(boy);
        obj.findLove();
        /**
         * 执行结果：
         * 我是媒婆：开始给你找对象，已拿到你的需求
         * 开始物色
         * 肤白貌美大长腿
         * 等待你的同意
         *
         * 代理成功
         */

        System.out.println(obj.getClass());

        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
        os.write(bytes);
        os.close();
    }
}
