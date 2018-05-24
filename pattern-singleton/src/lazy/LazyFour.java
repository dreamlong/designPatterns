package lazy;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 07:04
 * @Description:通过内部类的使用，来达到单例的效果，针对反射的问题进行改良,在外部尝试通过反射去生成对象的时候，通过标志位来进行拦截
 *  缺点：标志位其实也可以通过反射进行修改，所以反射的问题依然没有解决
 *
 */
public class LazyFour {

    private static boolean flag = false;

    private LazyFour(){
        if(!flag){
            flag = !flag;
        }else{
            throw new RuntimeException("违反单例原则创建实例");
        }
    }

    private static  class LazyHolder{
        private static final LazyFour INSTANCE = new LazyFour();
    }

    public static LazyFour getInstance(){
        return LazyHolder.INSTANCE;
    }
}
