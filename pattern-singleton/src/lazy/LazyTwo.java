package lazy;

/**
 * @Author: liumenglong
 * @Date: 2018/5/23 23:05
 * @Description:针对第一种存在线程安全问题的懒汉模式，进行改良，加入synchronized锁
 */
public class LazyTwo {

    private static LazyTwo instance = null;

    private LazyTwo(){}

    /**
     *
     * 功能描述: 通过对类成员方法加锁，从而解决线程安全问题
     *  缺点：耗费资源，其余线程需要等待锁释放
     *
     * @param:  * @param null
     * @return: LazyTwo
     * @auther: liumenglong
     * @date: 2018/5/23 23:08
     */
    public static synchronized LazyTwo getInstance(){
        if(instance == null){
            instance = new LazyTwo();
        }
        return instance;
    }
}
