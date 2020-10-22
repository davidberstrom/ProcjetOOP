package View;

import java.awt.Color;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import model.User;
import model.UserManager;

   

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton login;
	private JButton createUser;
	private JPanel panel;
	private JLabel uName,passw;
	private JFrame create;
	final JTextField text1,text2;

	public MainGUI(){
		super("Main");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		uName = new JLabel();
		uName.setBounds(10, 20, 80, 25);
		uName.setText("Username:");
		
		text1 = new JTextField(15);
		text1.setBounds(100,20,165,25); 
		text1.setBackground(Color.LIGHT_GRAY);
		
		passw = new JLabel();
		passw.setBounds(10,50,80,25);
		passw.setText("Password:");
		;
		text2 = new JPasswordField(15);
		text2.setBounds(100,50,165,25);  
		text2.setBackground(Color.LIGHT_GRAY);
		
		login=new JButton("LOG IN");
		login.setBounds(10,80,80,25);
		login.setBackground(Color.LIGHT_GRAY);
		
		createUser = new JButton("CREATE USER");
		createUser.setBounds(100,80,115,25);
		createUser.setBackground(Color.LIGHT_GRAY);
		panel.add(uName);
		panel.add(text1);
		panel.add(passw);
		panel.add(text2);
		panel.add(login);
		panel.add(createUser);
		
		this.add(panel);
		this.setSize(300,151);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	
		login.addActionListener(e -> onLogIn());
		createUser.addActionListener(e->createUser());
		
		
	}
	
	
	
	
	public void onLogIn(){
		String username = text1.getText();
		String password = text2.getText();

		UserManager.getInstance().addUser("David", "hej");
		UserManager.getInstance().addUser("axel", "123");
		
		 List<User> allUsers = UserManager.getInstance().getAllUsers();
		
		for(User u : allUsers){
			if(u.getPassWord().equals(password) && u.getUserName().equals(username)){
				new LoggedInView(u);
				break;
			}
			else if(username !=u.getUserName() || u.getPassWord() != password){
				JOptionPane.showMessageDialog(this, "Wrong username or user dosent exist or worng passeord");				
				break;
			}
		}
		text2.setText("");
		text1.setText("");
		this.dispose();
	
	}
	
	public void createUser(){
		create = new JFrame();
		JPanel createPanel = new JPanel();
		createPanel.setBackground(Color.WHITE);
		createPanel.setLayout(null);
		createPanel.setSize(300,151);
		create.setLocationRelativeTo(null);
		create.setResizable(false);
		
		JLabel chooseName = new JLabel();
		chooseName.setText("Select Username:");
		chooseName.setBounds(10, 20, 80, 25);
		
		
		JTextField user = new JTextField(15);
		user.setBounds(100,20,165,25); 
		user.setBackground(Color.LIGHT_GRAY);
	
		 
		JLabel selectPass= new JLabel();
		selectPass.setText("select Password:");
		selectPass.setBounds(10,50,80,25);
		selectPass.setBackground(Color.LIGHT_GRAY);
		
		JTextField pass = new JPasswordField(15);
		pass.setBounds(100,50,165,25);  
		pass.setBackground(Color.LIGHT_GRAY);
		
		JButton SUBMIT=new JButton("SUBMIT");
		SUBMIT.setBounds(10,80,80,25);
		SUBMIT.setBackground(Color.LIGHT_GRAY);
		
		createPanel.add(chooseName);
		createPanel.add(user);
		createPanel.add(selectPass);
		createPanel.add(pass);
		createPanel.add(SUBMIT);
		create.add(createPanel);
		
		create.setSize(300,151);
		create.setVisible(true);
		String name = user.getText();
		String password = pass.getText();
		
		SUBMIT.addActionListener(e->submit(name,password));
		
	
		
	
	}
	
	public void submit(String name,String password){
		
		
		List<User> allUsers =  UserManager.getInstance().getAllUsers();
	
		for(User u : allUsers){
			if (u.getUserName().equals(name)){
				JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE,"User already exist", EXIT_ON_CLOSE);
				break;
			}else{
				UserManager.getInstance().addUser(name, password);
				System.out.println("has been created");
				create.dispose();
				break;
			}
		}
	}

}
