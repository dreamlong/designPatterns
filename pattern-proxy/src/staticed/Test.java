package staticed;

/**
 * @Author: liumenglong
 * @Date: 2018/5/26 21:20
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Person son = new Son();
        Person father = new Father(son);
        father.findLove();
    }
}
