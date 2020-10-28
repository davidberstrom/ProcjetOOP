package View;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Observer.Observable;
import Observer.Observer;
import controller.Session;
import model.Activity;


public class MainGUI extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel,card2;
	private JPanel centerPanel; 
	private CardLayout c1 = new CardLayout();
	final static String MAPPANEL ="Panel with map";
	final static String ACTIVITYPANEL = "Panel with activity";
	private JLabel totDist,startTime,stopTime,maxAlt,minAlt,avgAlt,maxHr,minHr,avgHr,
					maxSpeed,minSpeed,avgSpeed,maxCad,minCad,avgCad;
	Activity current;
	public MainGUI() {
		super("hej");
		Session.getInstance().addSubscriber(this);
		
		mainPanel= new JPanel(new BorderLayout());
		centerPanel = new JPanel(c1);
		mainPanel.add(centerPanel,BorderLayout.CENTER);
		
		JPanel card1= new JPanel(new BorderLayout());
		JPanel card1Bottom = new JPanel(new GridLayout(3,5));
		JPanel card1Center= new JPanel(new GridLayout(3,3));
	
		card1.add(card1Bottom,BorderLayout.SOUTH);
		card1.add(card1Center,BorderLayout.CENTER);
		
		card1Center.add(new PlotView("HR",Session.getInstance().getCurrActivity(),tp->tp.getHRate()));
		card1Center.add(new PlotView("ALT",Session.getInstance().getCurrActivity(),tp->tp.getAlt()));
		card1Center.add(new PlotView("Speed",Session.getInstance().getCurrActivity(),tp->tp.getSpeed()));
		

		
		
		//kadens, puls och lutning.•
		totDist = new JLabel("Total Distance");
		startTime = new JLabel("Start Time");
		stopTime = new JLabel("Stop Time");
		maxAlt = new JLabel("Max altitude");
		minAlt =new JLabel("Min altitude");
		avgAlt= new JLabel("Avg altitude");
		maxHr = new JLabel("Max heartrate");
		minHr= new JLabel("Min heartrate");
		avgHr = new JLabel("Avg heartrate");
		maxSpeed=new JLabel("Max speed");
		minSpeed= new JLabel("Min speed");
		avgSpeed = new JLabel("Avg speed");
		maxCad = new JLabel("Max cadence");
		minCad = new JLabel("Min cadence");
		avgCad = new JLabel("Avg cadence");
		card1Bottom.add(totDist);
		card1Bottom.add(startTime);
		card1Bottom.add(stopTime);
     	card1Bottom.add(maxAlt);
     	card1Bottom.add(minAlt);
     	card1Bottom.add(avgAlt);
     	card1Bottom.add(maxHr);
     	card1Bottom.add(minHr);
     	card1Bottom.add(avgHr);
//     	card1Bottom.add(maxSpeed);
//     	card1Bottom.add(minSpeed);
//     	card1Bottom.add(avgSpeed);
//     	card1Bottom.add(maxCad);
//     	card1Bottom.add(minCad);
//     	card1Bottom.add(avgCad);
		 card2= new JPanel(new BorderLayout());

		
		card2.add(new DrawMap(Session.getInstance().getCurrActivity()),BorderLayout.CENTER);
		centerPanel.add(card2,MAPPANEL);
		centerPanel.add(card1,ACTIVITYPANEL);
		
		bottomBar bottomBar = new bottomBar(c1,centerPanel,card1,card1Center);
		mainPanel.add(bottomBar,BorderLayout.SOUTH);
		this.add(mainPanel);
		this.setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void update() {
		current=Session.getInstance().getNewActivity();
		totDist.setText("Total Distance: " + current.getTotalDist());
		startTime.setText("Start Time: " + current.getStartTime());
		stopTime.setText("Stop Time: "+ current.getEndTime());
		maxAlt.setText("Max altitude: "+current.getMaxAlt());
		minAlt.setText("Min altitude: "+current.getMinAlt());
		avgAlt.setText("Avg altitude: " + current.getAvgAlt());
		maxHr.setText("Max heartrate: "+current.getMaxHR());
		minHr.setText("Min heartrate: "+current.getMinHR());
		avgHr.setText("Avg heartrate: "+current.getAvgHR());
		card2.removeAll();
		card2.add(new DrawMap(current),BorderLayout.CENTER);
		card2.repaint();

	}

}