package com.itheima.d9_OptimisticLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        // 目标：有100份礼物 小红和小明同时发送 当剩下礼物小于10份的时候不再发送
        // 利用多线程模拟该过程并将线程的名称打印出来 并最后在控制台分别打印小红 小明各自送出多少份礼物

        // 1. 准备礼物
        List<String> gift = new ArrayList<>();
        String[] name = {"口红", "包包", "鲜花", "剃须刀", "皮带"};
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            // 随机添加礼物到列表中
            gift.add(name[r.nextInt(name.length)] + (i + 1));
        }
        System.out.println("初始礼物列表: " + gift);

        // 2. 定义线程类并创建线程对象
        SendThread xh = new SendThread(gift, "小红");

        SendThread xm = new SendThread(gift, "小明");
        xh.start();
        xm.start();
        // 等待两个线程完成
        xm.join();
        xh.join();

        // 输出每个线程送出的礼物数量
        System.out.println("小红送出的礼物数量: " + xh.getCount());
        System.out.println("小明送出的礼物数量: " + xm.getCount());
    }
}