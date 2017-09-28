package com.wz.thread;

import java.util.concurrent.TimeUnit;

public class SyncTest02 {

	/*
	 * 2.requestStop()和stopRequested()方法被同步
	 * 可以正确停止
	 */
	private static boolean stopRequested;
	private static synchronized void requestStop() {
		stopRequested = true;
	}
	private static synchronized boolean stopRequested() {
		return stopRequested;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
		
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested()) {
					i++;
					System.out.println("i = " + i);
				}
				System.out.println("stoped");
			}
		});
		backgroundThread.start();
		//TimeUnit提供了可读性更好的线程暂停操作，通常用来替换Thread.sleep()
		TimeUnit.SECONDS.sleep(1);
		//停止另一个线程
		requestStop();
		
	}
	
}
