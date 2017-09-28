package com.imooc.entity;

import java.io.Serializable;

/*
 * 文件实体类
 */
public class File implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int fid;
	private String fname;
	private byte[] fcontent;
	
	public File() {
		
	}

	public File(String fname, byte[] fcontent) {
		super();
		this.fname = fname;
		this.fcontent = fcontent;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public byte[] getFcontent() {
		return fcontent;
	}

	public void setFcontent(byte[] fcontent) {
		this.fcontent = fcontent;
	}
	
	
	
	
	
}
