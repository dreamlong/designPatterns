package jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: liumenglong
 * @Date: 2018/5/26 22:01
 * @Description:jdk代理媒婆类
 */
public class JDKMeipo implements InvocationHandler {

    private Boy target;

    public Object getInstance(Boy boy){
        this.target = boy;

        Class<?> clazz = this.target.getClass();
        /**
         * 从这里可以得知：
         * 1、Proxy生成代理类需要三个入参：类加载器，目标类的接口数组，以及InvacationHandler（InvacationHandler提供代理方法的实现）
         * 2、Proxy生成代理类的步骤如下：
         *  1）代码生成代理类，获取接口数组，然后实现接口数组的各个方法
         *  2）编译代理类
         *  3）通过类加载器加载代理类
         *  4）最后生成代理类实例并返回
         *
         *  这里也可以知道JDKMeipo以及Proxy以及InvacationHandler的关系
         *  1）InvactionHandler是Proxy的成员变量，Proxy生成的代理类需要InvacationHandler提供的invoke方法来实现代理方法
         *  2）JDKMeipo实现了InvacationHandler，因此JDKMeipo提供了代理方法
         *
         *  因此可以知道jdk动态代理的实现原理：
         *  1）Proxy负责生成源码，然后编译成class文件，最后加载到jvm，然后返回代理实例
         *  2）InvacationHandler实现代理方法，Proxy通过持有该对象属性，来封装代理方法
         */
        return Proxy.newProxyInstance(clazz.getClassLoader(),boy.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：开始给你找对象，已拿到你的需求");
        System.out.println("开始物色");
        method.invoke(target,args);
        System.out.println("等待你的同意");
        return null;
    }
}
