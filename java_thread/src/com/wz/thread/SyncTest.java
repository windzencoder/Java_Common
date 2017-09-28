package com.wz.thread;

import java.util.concurrent.TimeUnit;

public class SyncTest {

	private static boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1.这种停止方法是错误的
		 * 我们使用JVM -server参数执行该程序时，RunThread线程并不会终止！从而出现了死循环！！
		 * 使用这样方式，1s后，backgroundThread并不会停止
		 */
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
