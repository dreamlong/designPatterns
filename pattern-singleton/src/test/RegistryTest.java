package test;

import registry.SingleRegistryManager;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 09:26
 * @Description:
 */
public class RegistryTest {

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

                    Object obj = SingleRegistryManager.getInstance("registry.pojo");
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
