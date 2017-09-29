package com.wz.thread;

/*
 *  应用Runnable模拟卖票
 */

class MyTicketRunnable implements Runnable
{
	private int ticketsCount = 5;//一共有5张火车票
	
	public MyTicketRunnable() {
		
	}

	@Override
	public void run() {
		while (ticketsCount > 0) {
			ticketsCount--;//卖票
			System.out.println(Thread.currentThread().getName()+"卖了1张票，剩余票数为："+ticketsCount);
		}
	}
	
}

public class TicketRunnable {

	public static void main(String[] args) {

		MyTicketRunnable mtr = new MyTicketRunnable();
		//创建3个线程，模拟3个售票线程
		Thread mt1 = new Thread(mtr, "窗口一");
		Thread mt2 = new Thread(mtr, "窗口二");
		Thread mt3 = new Thread(mtr, "窗口三");
		mt1.start();
		mt2.start();
		mt3.start();
		
	}

}
