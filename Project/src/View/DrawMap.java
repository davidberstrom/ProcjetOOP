package View;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

import model.User;
 
  
public class DrawMap extends JPanel {
	
	private BufferedImage map;
	private Image rezizedImage;
	private User u;
	private int height;
	private int width;
	 public DrawMap(User u){
		 this.u=u;
		 try{
			 height=600;
			 width=800;
			 map = ImageIO.read(new File("C:/Users/David/Desktop/OOP/Kartor/gavle.png"));
			 rezizedImage = map.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
			 
		 }catch(IOException e){
			 System.err.println(e);
		 }
	 }
	 protected void paintComponent(Graphics g){
		 super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
		
		// g.drawImage(rezizedImage, 0,0,this);
		 
		 double [] lon= u.getUserAM().getActivity(u.getUserAM().getActivityName()).getLongitude().stream().mapToDouble(i -> i).toArray();
		 double [] latitude=u.getUserAM().getActivity(u.getUserAM().getActivityName()).getLatitude().stream().mapToDouble(i->i).toArray();
		 
		
		 double[] x = new double[lon.length-1];
		 double[] y = new double[latitude.length-1];
		 
		 for (int j=0;j<lon.length-1;j++){
			 x[j] = getX(lon[j],height);
		 }
		 for(int i=0;i<latitude.length-1;i++){
			 y[i] = getY(latitude[i],height,width);
		 }
		 
		 g2.setColor(Color.red);
		 for(int k=0; k<y.length-1;k++){
		 g2.draw(new Line2D.Double(x[k], y[k], x[k+1],y[k+1]));
		 }
	 }
	 
	 public double getX(double lon, int width){
		    double x = ((width*(180+lon)/360)%(width +(width/2)));

		    return x;
	 }
	 public double getY(double lat, int height, int width){
		   double PI = 3.14159265359;
		    double latRad = lat*PI/180;

		    // get y value
		    double mercN = Math.log((Math.tan((PI/4)+(latRad/2))));
		    double y     = (height/2)-(width*mercN/(2*PI));
		    return y;
	 }
	

}
