package shallow;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 18:14
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Library library = new Library();
        library.name = "l1";
        library.dateOfEstablishment = new Date();
        library.books = new ArrayList<>();
        library.books.add("java编程思想");

        Library library1 = (Library)library.clone();

        System.out.println(library);
        System.out.println(library1);

        System.out.println(library.name);
        System.out.println(library1.name);

        System.out.println(library.dateOfEstablishment);
        System.out.println(library1.dateOfEstablishment);

        /**
         * 由于List类型没有实现cloneable，所以只是拷贝引用
         */
        library.books.add("数据结构");
        System.out.println(library.books);
        System.out.println(library1.books);

        /**
         * 执行结果：
         *  shallow.Library@4554617c
         *  shallow.Library@74a14482
         *  l1
         *  l1
         *  Thu May 24 18:31:00 CST 2018
         *  Thu May 24 18:31:00 CST 2018
         *  [java编程思想, 数据结构]
         *  [java编程思想, 数据结构]
         */
    }
}
