package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class bottomBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton mapButton;
	private JPanel bottomBar;
	
	public bottomBar(){
		bottomBar = new JPanel(new GridLayout(1,4));
		mapButton = new JButton("show activityMap");
		bottomBar.add(mapButton);
		
		
	}
	public JPanel getBottomBar(){
		return bottomBar;
	}

}
