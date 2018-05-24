package lazy;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 07:04
 * @Description:通过内部类的使用，来达到单例的效果
 *  优点：内部类在 方法调用的时候才会被加载,巧妙的解决了线程安全问题以及内存浪费问题
 *  缺点：通过反射可以破解
 */
public class LazyThree {

    private LazyThree(){}

    private static  class LazyHolder{
        private static final LazyThree INSTANCE = new LazyThree();
    }

    public static LazyThree getInstance(){
        return LazyHolder.INSTANCE;
    }
}
