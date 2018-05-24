package lazy;

/**
 * @Author: liumenglong
 * @Date: 2018/5/23 22:32
 * @Description:懒汉模式，即当需要用到的时候才去加载
 *  优点：避免了耗费资源的可能
 *  缺点：存在线程安全问题
 */
public class LazyOne {

    private LazyOne(){}

    private static LazyOne lazyOne = null;

    /**
     *
     * 功能描述: 获取实例，存在的问题是，并发环境下，如果有两个或两个以上线程访问“lazyOne == null”的时候，会生成多个实例，违背了单例的要求
     *
     * @param:  * @param null
     * @return: LazyOne
     * @auther: liumenglong
     * @date: 2018/5/23 22:35
     */
    public static LazyOne getInstance(){
        if(lazyOne == null){
            lazyOne = new LazyOne();
        }
        return lazyOne;

    }
}
