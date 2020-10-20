package View;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
 
  
public class DrawMap extends JPanel {
	
	private BufferedImage map;
	private Image rezizedImage;
	 public DrawMap(){
		 try{
			 //
			 map = ImageIO.read(new File("C:/Users/David/Desktop/OOP/Kartor/gavle.png"));
			 rezizedImage = map.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
			 
		 }catch(IOException e){
			 System.err.println(e);
		 }
	 }
	 protected void paintComponent(Graphics g){
		 super.paintComponent(g);
		 g.drawImage(rezizedImage, 0,0,this);
		 
	 }
	 
}
