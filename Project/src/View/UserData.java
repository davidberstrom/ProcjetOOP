package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import controller.Session;

public class UserData extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel age,weight,height,description;
	private JButton edit;
	public UserData(){
		setSize(350, 220);
		setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		age = new JLabel();
		age.setBounds(10, 20, 80, 25);
		age.setText("age: " + Session.getInstance().getUser().getAge());
		
		height = new JLabel();
		height.setBounds(10,50,80,25);
		height.setText("height: " + Session.getInstance().getUser().getHeight());
		
		weight = new JLabel("weight: " +Session.getInstance().getUser().getWeight());
		weight.setBounds(10,80,80,25);
		weight.setBackground(Color.LIGHT_GRAY);
		
		description = new JLabel("Description: " +Session.getInstance().getUser().getDescription());
		description.setBounds(10, 110, 250, 25);
		
		edit = new JButton("Edit information");
		edit.setBounds(70,140, 140, 25);
		
		this.add(age);
		this.add(height);
		this.add(weight);
		this.add(description);
		this.add(edit);
		
		edit.addActionListener(e->edit());
	}

	public void edit(){
		new EditPerson(age,weight,height,description);
	}
}
