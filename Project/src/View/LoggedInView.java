/**
 * 
 */
package View;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Activity;


/**
 * @author David
 *
 */
public class LoggedInView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private CardLayout c1 = new CardLayout();
	Activity test = new Activity("hej");
	
	public LoggedInView(){
		super("hej");
		JPanel borderlayout = new JPanel(new GridLayout(4,1));
		//mapButton = new JButton("Show activity map");
		borderlayout.add(new PlotView("HR",test,tp->tp.getHRate()));
		borderlayout.add(new PlotView("ALT",test,tp->Double.parseDouble(tp.getAlt())));
		
		
		this.add(borderlayout);
		this.setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}
}
