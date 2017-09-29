package com.wz.thread;
/*
 * Thread类模拟买票
 * 
 */

class MyThread extends Thread
{
	private int ticketsCount = 5;//一共有5张火车票
	private String name;//窗口，也就是线程的名字
	
	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (ticketsCount > 0) {
			ticketsCount--;//卖票
			System.out.println(name+"卖了1张票，剩余票数为："+ticketsCount);
		}
	}
	
}

public class TicketsThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread mt1 = new MyThread("窗口一");
		Thread mt2 = new MyThread("窗口二");
		Thread mt3 = new MyThread("窗口三");
		mt1.start();
		mt2.start();
		mt3.start();
		
	}

}
