package com.wz.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * 守护线程
 */
class DeamonThread implements Runnable{
	@Override
	public void run() {
		System.out.println("进入守护线程 " + Thread.currentThread().getName());
		
		writeToFile();
		
		System.out.println("退出守护线程 " + Thread.currentThread().getName());
	}
	
	private void writeToFile(){
		File file = new File("file/demon.txt");
		try {
			OutputStream os = new FileOutputStream(file, true);//追加操作
			int count = 0;
			while(count < 999){
				os.write(("\r\nword"+count).getBytes());
				System.out.println("守护线程 " + Thread.currentThread().getName()
						+"向文件中写入了word" + count++);
				TimeUnit.SECONDS.sleep(1);//休眠1s
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class DaemonThreadDemo {

	public static void main(String[] args) {
		System.out.println("程序进入主线程 " + Thread.currentThread().getName());
		
		DeamonThread deamonThread = new DeamonThread();
		Thread thread = new Thread(deamonThread, "守护线程");
		thread.setDaemon(true);//守护线程
		thread.start();
		
		//输入后，主线程结束掉
		Scanner scanner = new Scanner(System.in);
		scanner.next();
		
		
		System.out.println("程序退出主线程 " + Thread.currentThread().getName());
	}

}
