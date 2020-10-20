package model;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private double wheight;
	private String password;
	
	public User(String name, String password){
		this.name = name;
		this.password = password;
	}
	
	public String getUser(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public double getWheight(){
		return wheight;
	}
	public String getPassword(){
		return password;
	}
	
	
	
}
