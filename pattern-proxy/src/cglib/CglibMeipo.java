package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: liumenglong
 * @Date: 2018/5/26 22:23
 * @Description:
 */
public class CglibMeipo implements MethodInterceptor{

    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是媒婆：开始给你找对象，已拿到你的需求");
        System.out.println("开始物色");
        methodProxy.invokeSuper(o,objects);
        System.out.println("等待你的同意");

        return null;
    }
}
