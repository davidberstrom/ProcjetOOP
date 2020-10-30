package app;

import javax.swing.SwingUtilities;

import View.DrawMap;
import View.LoggedInView;
import View.MainGUI;
import controller.Session;
import model.UserManager;

 class main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Session.getInstance().setUser(UserManager.getInstance().getUser("David"));
		SwingUtilities.invokeLater(() ->  new MainGUI());
	}

}
