package custom;

import java.lang.reflect.Method;

/**
 * @Author: liumenglong
 * @Date: 2018/5/27 14:29
 * @Description:
 */
public interface WLInvocationHandler {

    /**
     * 代理方法
     * @param proxy
     * @param method
     * @param args
     * @return 返回方法执行结果
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable ;
}
