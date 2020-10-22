 /**
 * 
 */
package View;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Activity;
import model.User;


/**
 * @author David
 *
 */
public class LoggedInView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel centerPanel; 
	private CardLayout c1 = new CardLayout();
	final static String MAPPANEL ="Panel with map";
	final static String ACTIVITYPANEL = "Panel with activity";
	
	public LoggedInView(User u){
		
		super("hej");
		mainPanel= new JPanel(new BorderLayout());
		centerPanel = new JPanel(c1);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		
		JPanel card1= new JPanel(new GridLayout(3,3));
		card1.add(new PlotView("HR",u.getUserAM().getActivity(u.getUserAM().getActivityName()),tp->tp.getHRate()));
		card1.add(new PlotView("ALT",u.getUserAM().getActivity(u.getUserAM().getActivityName()),tp->tp.getAlt()));
		card1.add(new PlotView("Speed",u.getUserAM().getActivity(u.getUserAM().getActivityName()),tp->tp.getSpeed()));
		
		JLabel age = new JLabel("Age:"+u.getAge());
		card1.add(age);
		JLabel weight = new JLabel("Weight:"+u.getWeight());
		card1.add(weight);
		JLabel height = new JLabel("Height:"+u.getHeight());
		card1.add(height);
		JLabel description = new JLabel("Description:"+u.getDescription());
		card1.add(description);
		
		card1.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createTitledBorder("Information"), 
		        BorderFactory.createEmptyBorder(1, 5, 1, 1)));

		
		JPanel card2= new JPanel(new BorderLayout());
		card2.add(new DrawMap(u),BorderLayout.CENTER);
		
		centerPanel.add(card2,MAPPANEL);
		centerPanel.add(card1,ACTIVITYPANEL);
		for(Activity a : u.getUserAM().getActivities())
			System.out.println(a.getName());
//		JButton next = new JButton("show activity");
//		next.addActionListener(e->switchView());
		bottomBar bottomBar = new bottomBar(u,centerPanel,c1,age,weight,height,description);
		mainPanel.add(bottomBar.getBottomBar(),BorderLayout.SOUTH);
		this.add(mainPanel);
		this.setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

}
