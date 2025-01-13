package com.itheima.d9_OptimisticLock;

import java.util.List;
import java.util.Random;

public class SendThread extends Thread {
    private final List<String> gift; // 礼物列表
    private int count; // 记录送出的礼物数量

    public int getCount() {
        return count; // 获取送出的礼物数量
    }

    public SendThread(List<String> gift, String name) {
        super(name); // 设置线程名称
        this.gift = gift; // 初始化礼物列表
    }

    @Override
    public void run() {
        // 发礼物
        String name = Thread.currentThread().getName(); // 获取当前线程名称
        Random random = new Random();
        while (true) {
            synchronized (gift) { // 同步访问礼物列表
                if (gift.size() < 10) {
                    break; // 如果剩下的礼物少于10个，则停止发送
                }
                // 随机移除一个礼物
                String rs = gift.remove(random.nextInt(gift.size()));
                System.out.println(name + "发出了" + rs); // 打印发送的礼物
                count++; // 计数
            }
        }
    }
}