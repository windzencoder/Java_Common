package com.imooc.util;

import java.io.Serializable;
/*
 * 此类表示客户机和服务器之间传输的指令数据
 */
public class CommandTransfer implements Serializable{

	private static final long serialVersionUID = 1L;

	//当前操作的命令
	private String cmd;
	//发送的数据
	private Object data;
	//操作是否成功
	private boolean flag;
	//返回的结果
	private String result;
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
}
