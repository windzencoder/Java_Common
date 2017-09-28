package com.wz.thread;

import java.util.concurrent.TimeUnit;

public class SyncTest03 {

	/*
	 * 3.volatile修饰符不执行互斥访问，但它可以保证任何一个线程在读取
	 * 该域的时候都将看到最近刚刚被写入的值
	 */
	private static volatile boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
		
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
					System.out.println("i = " + i);
				}
				System.out.println("stoped");
			}
		});
		backgroundThread.start();
		//TimeUnit提供了可读性更好的线程暂停操作，通常用来替换Thread.sleep()
		TimeUnit.SECONDS.sleep(1);
		
		stopRequested = true;
		
	}
	
}
