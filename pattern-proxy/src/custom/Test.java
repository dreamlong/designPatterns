package custom;


import java.io.IOException;

/**
 * @Author: liumenglong
 * @Date: 2018/5/26 22:09
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Person p = (Person)new WLMeipo().getInstance(new Boy());
        p.findLove();
    }
}
