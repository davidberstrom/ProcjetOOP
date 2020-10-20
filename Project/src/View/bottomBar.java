package View;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import model.Activity;
import model.User;
import model.UserManager;



public class bottomBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton mapButton;
	private JPanel bottomBar;
	private JButton importActivity;
	private User u;
	private JPanel center;
	private CardLayout c1;
	public bottomBar(User u,JPanel c,CardLayout c1){
		this.c1=c1;
		center = c;
		this.u = u;
		bottomBar = new JPanel(new GridLayout(1,4));
		mapButton = new JButton("show activity");
		importActivity = new JButton("import Activity");
		bottomBar.add(mapButton);
		bottomBar.add(importActivity);
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
		
	}
	public void switchView(){
		c1.next(center);
	}

}
