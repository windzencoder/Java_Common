package com.imooc.entity;

import java.io.Serializable;

/*
 * 用户实体类
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String passoword;
	
	public User() {
	}

	public User(String username, String passoword) {
		super();
		this.username = username;
		this.passoword = passoword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassoword() {
		return passoword;
	}

	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}

}
