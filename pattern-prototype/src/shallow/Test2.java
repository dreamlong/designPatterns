package shallow;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 18:14
 * @Description:
 */
public class Test2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Library2 library = new Library2();
        library.name = "l1";
        library.dateOfEstablishment = new Date();
        library.books = new ArrayList<>();
        library.books.add("java编程思想");

        Library2 library1 = library.clone();

        System.out.println(library);
        System.out.println(library1);

        System.out.println(library.name);
        System.out.println(library1.name);

        System.out.println(library.dateOfEstablishment);
        System.out.println(library1.dateOfEstablishment);

        /**
         * 由于ArrayList类型实现cloneable，所以是直接复制对象，其实跟Liarbry2的clone是一样原理
         */
        library.books.add("数据结构");
        System.out.println(library.books);
        System.out.println(library1.books);

        /**
         *  shallow.Library2@4554617c
         *  shallow.Library2@74a14482
         *  l1
         *  l1
         *  Thu May 24 18:33:36 CST 2018
         *  Thu May 24 18:33:36 CST 2018
         *  [java编程思想, 数据结构]
         *  [java编程思想]
         */
    }
}
