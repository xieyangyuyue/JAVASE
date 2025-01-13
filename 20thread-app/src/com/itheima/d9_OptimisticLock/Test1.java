package com.itheima.d9_OptimisticLock;


public class Test1 {
    public static void main(String[] args) {
        /**
         * 目标：拓展悲观锁 乐观锁原理
         * 悲观锁：一上来就加锁 没有安全感 每次只能一个线程进入访问完毕 再解锁 线程安全 性能差
         * 乐观锁：一开始不上锁 认为是安全的 等要出线程安全问题的时候才开始控制 线程安全 性能好
         */
        Runnable target = new MyRunnable();
        for (int i = 0; i < 100; i++) {
            new Thread(target).start();
        }
    }
}
