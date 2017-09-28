package com.wz.thread;
/**
 * 线程同步例子
 * @author Miller
 *
 */
public class SynchronizedDemo {

	public static void main(String[] args) {
		/*
		 * 1.输出结果如下，不合理
		 * 
		 * Thread-A : 当前foo对象的x值= 40
			Thread-B : 当前foo对象的x值= 40
				Thread-A : 当前foo对象的x值= -20
					Thread-B : 当前foo对象的x值= -20
						Thread-A : 当前foo对象的x值= -80
							Thread-B : 当前foo对象的x值= -80
		 * 
		 */
		MyRunnable r = new MyRunnable(); 
        Thread ta = new Thread(r, "Thread-A"); 
        Thread tb = new Thread(r, "Thread-B"); 
        ta.start(); 
        tb.start(); 
		
	}
	
}

class MyRunnable implements Runnable { 
    private Foo foo = new Foo(); 

    public void run() { 
        for (int i = 0; i < 3; i++) { 
            this.fix(30); 
            try { 
                Thread.sleep(1); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + foo.getX()); 
        } 
    } 

    public int fix(int y) { 
        return foo.fix(y); 
    } 
}

class Foo { 
    private int x = 100; 
    public int getX() { 
    	synchronized (this) {
            return x;
        }
    } 
    public int fix(int y) { 
    		//修改
    		synchronized (this) {
    			 x = x - y; 
		}
        return x; 
    } 
} 
