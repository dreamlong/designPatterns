package test;

import lazy.LazyOne;
import lazy.LazyTwo;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: liumenglong
 * @Date: 2018/5/23 22:39
 * @Description:对于第二种懒汉模式的测试
 */
public class LazyTwoTest {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000000;i ++) {
            Object obj = LazyTwo.getInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));

        /**
         * 执行结果
         *总耗时：4152
         *  。。。
         */

    }
}
