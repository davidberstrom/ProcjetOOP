	package model;

import java.io.File;
import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private int age = 0;
	private String row;
	private double wheight=0.0;
	private double height=0.0;
	private String description="....";
	private ActivityManager am = new ActivityManager();
	
	public User(String row) {
		this.row = row;
		this.userName = fixRow();
		this.passWord = fixRow();
	}
	
	public String fixRow(){
		String temp = "";
		for (int i=0; i<this.row.length();i++){
			if(this.row.charAt(i) != ';' ){
				temp += this.row.charAt(i);
			} else {
				String newRow = this.row.substring(i+1, this.row.length());
				this.row = newRow;
				break;
			}
		}
		//F�r att kunna lagra i double kr�vs . och inte ,
		temp = temp.replace(",", ".");
		return temp;
	}
	
	public void addActivity(File file, String name) {
		am.addActivity(file, name);
		UserManager.getInstance().storeUsers();
	}
	
	public void removeActivity(String name) {
		try {
			am.removeActivity(name);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage() + ": File not found.");
		}
		UserManager.getInstance().storeUsers();
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassWord() {
		return this.passWord;
	}
	
	public ActivityManager getUserAM() {
		return this.am;
	}
	public void setWeight(double wheight){
		this.wheight = wheight;
	}
	public double getWeight(){
		return wheight;
	}
	public void setHeight(double height){
		this.height=height;
	}
	public double getHeight(){
		return height;
	}
	public void setDescription(String d){
		description = d;
	}
	public String getDescription(){
		return description;
	}
	public void printActivityNames() {
		for(Activity a : am.getActivities())
			System.out.println(a.getName());
	}
}