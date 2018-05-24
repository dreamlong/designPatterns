package test;

import lazy.LazyOne;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: liumenglong
 * @Date: 2018/5/23 22:39
 * @Description:对于第一种懒汉模式的测试
 */
public class LazyOneTest {

    public static void main(String[] args) {

        int count = 200;

        CountDownLatch countDownLatch = new CountDownLatch(count);

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run() {

                    try {
                        /**
                         * 进入线程之后先暂停执行，等到countDownLatch为0的时候释放锁，再执行
                         */
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Object obj = LazyOne.getInstance();
                    System.out.println(System.currentTimeMillis()+":"+obj);
                }
            }.start();
            countDownLatch.countDown();
        }

        long end = System.currentTimeMillis();

        System.out.println("总共耗时："+(end-start));
        /**
         * 执行结果
         * 总共耗时：18
         *  1527087868299:lazy.LazyOne@3945e031
         *  1527087868299:lazy.LazyOne@18cf86d9
         *  。。。
         */

    }
}
