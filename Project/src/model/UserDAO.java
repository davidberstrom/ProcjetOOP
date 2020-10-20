package model;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
	private static UserDAO instance;
	private List<User> users = new LinkedList<User>();
	private String file = "Users.txt";
	private String password;
	
	private UserDAO(){
		read();
	}
	public static UserDAO getInstance(){
		if (instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	
	public void addUser(User u){
		users.add(u);
	}
	public void createUser(String uName, String pass){
		addUser(new User(uName, pass));
	}
	public List<User> getUsers(){
		if (users == null)
			read();
		return users;
	}
	public void storeUsers(){
		
		if (users!= null){
			try{
				ObjectOutputStream store = new ObjectOutputStream(new FileOutputStream(file));
				store.writeObject(users);
				store.close();
			}catch(IOException e){
				System.err.println(e);
			}
		}
	}
	@SuppressWarnings("unchecked")
	public List<User> read(){
		try{
			ObjectInputStream read = new ObjectInputStream (new FileInputStream(file));
			users = (List<User>)read.readObject();
			read.close();
		}catch(IOException e){
			System.err.println(e);
		} catch (ClassNotFoundException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
		}
		return users;
	}
	

}
