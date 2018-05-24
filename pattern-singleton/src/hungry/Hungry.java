package hungry;

/**
 * @Author: liumenglong
 * @Date: 2018/5/23 22:20
 * @Description:饥饿模式，即，在使用之前通过类加载的形式初始化（不过用不用，先喂饱了再说）
 *  优点：通过类加载的方式生成的数据，避免了线程安全问题
 *  缺点：存在浪费资源的可能（假如没有使用的话）
 */
public class Hungry {

    /**
     * 通过类成员方法的形式进行初始化
     */
    private static final Hungry instance = new Hungry();

    private Hungry(){

    }

    public static Hungry getInstance(){
        return instance;
    }
}
