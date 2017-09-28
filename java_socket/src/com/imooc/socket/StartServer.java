package com.imooc.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 启动服务器
 */
public class StartServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(8800);
			Socket socket = null;
			System.out.println("***服务器即将启动，等待客户端连接***");
			//服务器循环监听客户端的连接请求
			while (true) {
				//开始监听，等待客户端连接
				socket = serverSocket.accept();
				//多线程多选
				ServerThread thread = new ServerThread(socket);
				thread.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
