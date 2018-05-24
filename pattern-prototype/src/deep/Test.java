package deep;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 23:38
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        QiTianDaSheng o = new QiTianDaSheng();

        QiTianDaSheng o1 = o.clone();

        System.out.println(o.jinGuBang == o1.jinGuBang);
    }
}
