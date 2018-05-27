package custom;

import java.lang.reflect.Method;

/**
 * @Author: liumenglong
 * @Date: 2018/5/27 16:02
 * @Description:
 */
public class WLMeipo implements WLInvocationHandler {
    private Person target;

    public Object getInstance(Person person) throws Exception{
        target = person;
        return WLProxy.newInstance(new WLClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：拿到你的需求");
        System.out.println("开始物色");
        method.invoke(target,args);
        System.out.println("介绍结束，看自己发挥");
        return null;
    }
}
