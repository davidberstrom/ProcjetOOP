package View;
import java.awt.*;
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
		 this.setSize(600,400);
		
		 try{
			 map = ImageIO.read(new File("C:/Users/David/Desktop/OOP/Kartor/gavle.png"));
			 rezizedImage = map.getScaledInstance(600,400, Image.SCALE_DEFAULT);
			 
		 }catch(IOException e){
			 System.err.println(e);
		 }
	 }
	 protected void paintComponent(Graphics g){
		 super.paintComponent(g);
		 findMaxMinLongLat();
		 
		 int xArr[] = new int[trackPointList.size()];
		 int yArr[] = new int[trackPointList.size()];
		 int i =0;
		 for(TrackPoint p : trackPointList){
			 xArr[i] = getXPixelValue(p);
			 yArr[i]= getYPixelValue(p);
			 i++;
		 }
		 g.setColor(Color.BLUE);
		 //g.drawImage(rezizedImage, 0, 0, null);
		 g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		 g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
		 g.drawPolyline(xArr, yArr, xArr.length);
		
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
