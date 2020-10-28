package app;

import javax.swing.SwingUtilities;

import View.LoggedInView;

 class main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		SwingUtilities.invokeLater(() ->  new LoggedInView());
	}

}
