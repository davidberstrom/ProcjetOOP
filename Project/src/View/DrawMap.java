package View;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

import Observer.Observer;
import controller.Session;
import model.Activity;
import model.TrackPoint;
import model.User;
 
  
public class DrawMap extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private BufferedImage map;
	private Image rezizedImage;
	double maxLon=0.0;
	double minLon=0.0;
	double maxLat=0.0;
	double minLat=0.0;
	private LinkedList<TrackPoint> trackPointList;
	 public DrawMap(Activity a){
		 trackPointList = (LinkedList<TrackPoint>)a.getTracks();
		 this.setSize(800,600);
		 this.setLayout(new BorderLayout());
		
//		 try{
//			 map = ImageIO.read(new File("C:/Users/David/Desktop/OOP/Kartor/gavle.png"));
//			 rezizedImage = map.getScaledInstance(600,400, Image.SCALE_DEFAULT);
//			 
//		 }catch(IOException e){
//			 System.err.println(e);
//		 }
	 }
	 protected void paintComponent(Graphics g){
		 super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
		 findMaxMinLongLat();
		 
		 int xArr[] = new int[trackPointList.size()];
		 int yArr[] = new int[trackPointList.size()];
		 int i =0;
		 for(TrackPoint p : trackPointList){
			 xArr[i] = getXPixelValue(p);
			 yArr[i]= getYPixelValue(p);
			 i++;
		 }
		 g.drawPolyline(xArr, yArr, xArr.length);
		 //g.drawImage(rezizedImage, 0, 0, null);
		 g.setColor(Color.RED);
//		 for (int j =0; j< getWidth(); j+=10){
//			 g.drawLine(0+j, 0, 0+j, getHeight());
//			 g.drawLine(0, 0+j, getWidth(), 0+j);
//		 }
//		 
		 g.drawLine(10, 20, 10, getHeight());
		 g.drawLine(0, getHeight()-10, getWidth()-20, getHeight()-10);
		 g.drawString(""+maxLat, 5, 13);
		 Font font = new Font(null, Font.PLAIN, 10);   
		 AffineTransform affineTransform = new AffineTransform();
		 affineTransform.rotate(Math.toRadians(90), 0, 0);
		 Font rotatedFont = font.deriveFont(affineTransform);
		 g2.setFont(rotatedFont);
		 g2.drawString(""+maxLon, getWidth()-16,getHeight()-51);
		 g.setColor(Color.BLUE);
		
		 
	 }
	
	 private int getXPixelValue(TrackPoint tp){
		 int xPix= (int)(((tp.getLng()-minLon)/(maxLon-minLon))*getWidth());
		 return xPix;
	 }
	 private int getYPixelValue(TrackPoint tp){
		 int yPix = (int)(((tp.getLat()-minLat)/(maxLat-minLat))*getHeight());
		 yPix = getHeight()-yPix;
		 return yPix; 
	 }
	 
	 private void findMaxMinLongLat(){
		 minLat= trackPointList.getFirst().getLat();
		 maxLat = trackPointList.getLast().getLat();
		 minLon = trackPointList.getFirst().getLng();
		 maxLat = trackPointList.getLast().getLng();
		 for(TrackPoint p : trackPointList){
			 double lon = p.getLng();
			 double lat =p.getLat();
			 if(lon>maxLon)
				 maxLon = lon;
			 else if(lon < minLon)
				 minLon = lon;
			 if (lat > maxLat)
				 maxLat = lat;
			 else if (lat < minLat)
				 minLat = lat;
		 }
	 } 
}
