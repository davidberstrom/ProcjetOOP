package View;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Observer.Observer;
import controller.Session;
import model.Activity;
import model.UserManager;

public class bottomBar extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private JButton importButton, selectButton, removeButton,showMap,about;
	private JComboBox<String> list;
	private JPanel card1,card1Center;
	private Activity newAcc;
	public bottomBar(CardLayout c1, JPanel parent,JPanel card1,JPanel card1Center) {
		Session.getInstance().addSubscriber(this);
		this.card1=card1;
		this.card1Center = card1Center;
		
		importButton = new JButton("Import activity");
		selectButton = new JButton("Select activity");
		removeButton = new JButton("Remove activity");
		showMap = new JButton ("show activity data");
		about = new JButton("About you");
		
		this.add(showMap);
		this.add(importButton);
		this.add(selectButton);
		this.add(about);
		this.add(removeButton);
		
		importButton.addActionListener(e -> importActivity());
		selectButton.addActionListener(e -> changeActivity());
		removeButton.addActionListener(e -> removeActivity());
		showMap.addActionListener(e->switchView(c1,parent));
		about.addActionListener(e->aboutU());
		list = new JComboBox<String>();
		for (Activity a : Session.getInstance().getUser().getUserAM().getActivities()) {
			list.addItem(a.getName());
		}
	}

	public void importActivity() {
		try {
			JFileChooser file = new JFileChooser();
			file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			file.showOpenDialog(null);
			Session.getInstance().getUser().getUserAM().addActivity(file.getSelectedFile(),
					file.getSelectedFile().getName());
			getRootPane().repaint();
			UserManager.getInstance().storeUsers();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this.getRootPane(), "You didn't select a file.");
		}
	}

	public void changeActivity() {
		if(list.getSelectedItem() != null) {
			JOptionPane.showMessageDialog(getRootPane(), list);
			Activity plot = Session.getInstance().getUser().getUserAM().getActivity(list.getSelectedItem().toString());
			Session.getInstance().setCurrActivity(plot);
			
		} else 
			JOptionPane.showMessageDialog(getRootPane(), "Det finns inga aktiviteter.");
		
	}
	
	public void removeActivity() {
		if(list.getSelectedItem() != null) {
			int test = JOptionPane.showConfirmDialog(getRootPane(), list, "Ta bort aktivitet", JOptionPane.OK_CANCEL_OPTION);
			if(test == 0) {
				int sure = JOptionPane.showConfirmDialog(getRootPane(), "Vill du verkligen ta bort " + list.getSelectedItem() + "?", "Ta bort", JOptionPane.YES_NO_OPTION);
				if(sure == 0) {
					String s = (String) list.getSelectedItem();
					Session.getInstance().getUser().removeActivity(s);
					list.removeItem(s);
				}
			}
		} else 
			JOptionPane.showMessageDialog(getRootPane(), "Det finns inga aktiviteter.");
	}
	
	public void switchView(CardLayout c1,JPanel parent){
		c1.next(parent);
	}	
	public void aboutU(){
		new UserData();
	}

	@Override
	public void update() {
		newAcc = Session.getInstance().getNewActivity();
		card1Center.removeAll();
		card1Center.add(new PlotView("HR",newAcc,tp->tp.getHRate()));
		card1Center.add(new PlotView("ALT",newAcc,tp->tp.getAlt()));
		card1Center.add(new PlotView("Speed",newAcc,tp->tp.getSpeed()));		
		card1Center.repaint();
	}
}