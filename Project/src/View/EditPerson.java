package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.User;

public class EditPerson extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField weight;
	private JTextField age;
	private JTextField height;
	private JTextArea description;
	private JLabel mainAge,mainWeight,mainHeight,mainDescription;
	private User u;
	private JScrollPane scrollable;
	public EditPerson(User u,JLabel mainAge,JLabel mainWeight,JLabel mainHeight,JLabel mainDescription){
		super("edit");
		this.mainAge=mainAge;
		this.mainHeight=mainHeight;
		this.mainWeight=mainWeight;
		this.mainDescription=mainDescription;
		this.u=u;
		setVisible(true);
		setSize(320,270);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		JLabel setWeight = new JLabel();
		setWeight.setBounds(10, 20, 80, 25);
		setWeight.setText("Weight:");
		
		weight = new JTextField(15); 
		weight.setBounds(100,20,165,25);
		weight.setBackground(Color.LIGHT_GRAY);
		
		JLabel err= new JLabel();
		err.setBounds(275,20,25,25);
		err.setText("");
		
		JLabel setHeight = new JLabel();
		setHeight.setBounds(10,50,80,25);
		setHeight.setText("Height:");
		
		 height = new JTextField(15);
		height.setBounds(100,50,165,25);
		height.setBackground(Color.LIGHT_GRAY);
		
		JLabel errHeight = new JLabel();
		errHeight.setText("");
		errHeight.setBounds(275,50,80,25);
		
		
		JLabel setAge = new JLabel();
		setAge.setBounds(10,80,80,25);
		setAge.setText("Age:");
		
		age = new JTextField(15);
		age.setBounds(100,80,165,25);
		age.setBackground(Color.LIGHT_GRAY);
		
		JLabel errAge = new JLabel();
		errAge.setBounds(275,80,80,25);
		errAge.setText("");
		
		JLabel setDescription = new JLabel();
		setDescription.setBounds(10,110,80,25);
		setDescription.setText("Description");
		
		description = new JTextArea();
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setBackground(Color.LIGHT_GRAY);
		scrollable = new JScrollPane(description);
		scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollable.setBounds(100,110,165,50);
		scrollable.setBackground(Color.LIGHT_GRAY);
		

		
		
		JButton submit = new JButton("submit");
		submit.setBounds(100,164,115,25);
		submit.setBackground(Color.LIGHT_GRAY);
		
		submit.addActionListener(e->editPerson());
		
		height.getDocument().addDocumentListener(new MyDocumentListener(height,errHeight));
		age.getDocument().addDocumentListener(new MyDocumentListener(age,errAge));
		weight.getDocument().addDocumentListener(new MyDocumentListener(weight,err));
		
		panel.add(errAge);
		panel.add(errHeight);
		panel.add(err);
		panel.add(setWeight);
		panel.add(weight);
		panel.add(setHeight);
		panel.add(height);
		panel.add(setAge);
		panel.add(age);
		panel.add(setDescription);
		panel.add(scrollable);
		panel.add(submit);
		add(panel);
	}
	public void editPerson(){
		String w = weight.getText();
		String h = height.getText();
		String a = age.getText();
		String d="...";
		 d = description.getText();
		
		if(isNumeric(w) == true){
			u.setWeight(Double.parseDouble(w));
			mainWeight.setText("Weight:"+w);
		}else {
			
		}
		if(isNumeric(h)==true){
			u.setHeight(Double.parseDouble(h));
			mainHeight.setText("Height:"+h);
		}else{
			
		}
		if(isNumeric(a)==true){
			u.setAge(Integer.parseInt(a));
			mainAge.setText("Age:"+a);
		}else{
			
		}
		if(isNumeric(d)==false){
			u.setDescription(d);
			mainDescription.setText("Description:"+d);
		}else{
		
		}
	}
	
	
	public boolean isNumeric(String s){
		if (s == null)
			return false;
		try {
	        double d = Double.parseDouble(s);
	    } catch (NumberFormatException e) {
	        return false;
	    }
	    return true;
	}
	
	private class MyDocumentListener implements DocumentListener{
		private JTextField j;
		private JLabel err;
		private JTextArea a;

		public MyDocumentListener(JTextField j,JLabel err){
			this.j=j;
			this.err=err;
		}
		

		@Override
		public void changedUpdate(DocumentEvent e) {
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			
			if(isNumeric(j.getText()) == false){
				j.setBackground(new Color(255,102,102));
				err.setFont(new Font("serif",Font.PLAIN,10));
				err.setText("invald");
				err.setForeground(new Color(255,102,102));
			}else{
				j.setBackground(Color.GREEN.brighter().brighter().brighter());
				err.setFont(new Font("serif",Font.PLAIN,10));
				err.setText("valid");
				err.setForeground(Color.green.brighter());
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			if(isNumeric(j.getText()) == false){
				j.setBackground(Color.RED.brighter().brighter());
			}else{j.setBackground(Color.GREEN.brighter().brighter());}
			
		}
		
		
		
	}
}
