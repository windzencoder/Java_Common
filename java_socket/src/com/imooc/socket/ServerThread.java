package com.imooc.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.imooc.entity.File;
import com.imooc.entity.User;
import com.imooc.service.FileService;
import com.imooc.service.UserService;
import com.imooc.util.CommandTransfer;

/*
 * 服务器端线程处理类
 */
public class ServerThread extends Thread {

    private Socket socket = null;
    //对象输入流
    private ObjectInputStream ois = null;
    //对象输出流
    private ObjectOutputStream oos = null;
    private UserService us = new UserService();
    private FileService fs = new FileService();
    
    //构造方法，初始化socket
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
        	
        		ois = new ObjectInputStream(socket.getInputStream());
        		oos = new ObjectOutputStream(socket.getOutputStream());
        		//读取指令
        		CommandTransfer transfer = (CommandTransfer) ois.readObject();
        		//执行客户端发送到服务端的指令
            transfer = execute(transfer);
            //响应客户端
            oos.writeObject(transfer);
        		
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        		e.printStackTrace();
		}

    }
    
    /*
     * 执行客户端发送到服务器的指令操作
     */
    public CommandTransfer execute(CommandTransfer transfer) {
    		String cmd = transfer.getCmd();//获取当前的操作指令
    		if (cmd.equals("login")) {//用户登录
			User user = (User) transfer.getData();
			boolean flag = us.login(user);
			transfer.setFlag(flag);
			if (flag) {
				transfer.setResult("登录成功");
			}else {
				transfer.setResult("用户名和密码不正确，请重新登录！");
			}
		}else if(cmd.equals("register")){//用户注册
			User user = (User) transfer.getData();
			boolean flag = us.register(user);//注册用户
			transfer.setFlag(flag);
			if (flag) {
				transfer.setResult("注册成功");
			}else {
				transfer.setResult("注册失败");
			}
		}else if(cmd.equals("uploadFile")){//上传文件
			File file = (File) transfer.getData();
			boolean flag = fs.save(file);
			transfer.setFlag(flag);
			if (flag) {
				transfer.setResult("上传成功");
			}else {
				transfer.setResult("上传失败");
			}
		}
    		return transfer;
    }
    

}
