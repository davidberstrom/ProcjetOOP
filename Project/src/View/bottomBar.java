package View;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Activity;
import model.User;



public class bottomBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton mapButton;
	private JPanel bottomBar;
	private JButton importActivity;
	private User u;
	private JPanel center;
	private CardLayout c1;
	private JButton showAc;
	private JComboBox<String> activityList;
	private JLabel age,height,weight,description;
	public bottomBar(User u,JPanel c,CardLayout c1,JLabel age,JLabel weight,JLabel height,JLabel description){
		this.age = age;
		this.weight=weight;
		this.height=height;
		this.description=description;
		this.c1=c1;
		center = c;
		this.u = u;
		bottomBar = new JPanel();
		mapButton = new JButton("show activity");
		importActivity = new JButton("import Activity");
		JButton editUser = new JButton("Edit user");
		bottomBar.add(editUser);
		bottomBar.add(createComboBox());
		bottomBar.add(mapButton);
		bottomBar.add(importActivity);
		ImageIcon icon = new ImageIcon("edit.png");
		Image newImage = icon.getImage();
		Image newImg = newImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newImg);
		JButton edit = new JButton(icon);
		edit.setSize(icon.getIconWidth(),icon.getIconHeight());
		
		bottomBar.add(edit);
		
		editUser.addActionListener(e->edit());
		mapButton.addActionListener(e->switchView());
		importActivity.addActionListener(e->importAc());

	}
	public JPanel getBottomBar(){
		return bottomBar;
	}
	public void importAc(){
		JFileChooser file = new JFileChooser();
		file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		file.showOpenDialog(null);
		
		u.getUserAM().removeActivity("test");
		u.getUserAM().addActivity(file.getSelectedFile(), "Activity");
		updateList();
	}
	public void switchView(){
		c1.next(center);
	}
	
	public JComboBox createComboBox(){
		 activityList= new JComboBox<String>();
		for(Activity a: u.getUserAM().getActivities()){
			activityList.addItem(a.getName());
		}
		return activityList;
	}
	public void updateList(){
		activityList.removeAll();
		for (Activity a:u.getUserAM().getActivities()){
			activityList.addItem(a.getName());
		}
	}
	public void edit(){
		new EditPerson(u,age,weight,height,description);
	}

}
