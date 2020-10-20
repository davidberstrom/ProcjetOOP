/**

 * 
 */
package model;

import java.util.List;

/**
 *
 *
 */
public class TrackPoint {
	private String row;
	private String date;
	private String time;
	private String elapsedTime;
	private String lng;
	private String lat;
	private String alt;
	private String dist;
	private String hRate;
	private String speed;
	private String cadence;
	
	public TrackPoint(String row){
		this.row = row;
		this.date = fixRow();
		this.time = fixRow();
		this.elapsedTime = fixRow();
		this.lng = fixRow();
		this.lat = fixRow();
		this.alt = fixRow();
		this.dist = fixRow();
		this.hRate = fixRow();
		this.speed = fixRow();
		this.cadence = fixRow();
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getTime(){
		return this.time;
	}
	public String getElapsedTime(){
		return this.elapsedTime;
	}
	public String getLng(){
		return this.lng;
	}
	public String getLat(){
		return this.lat;
	}
	public String getAlt(){
		return this.alt;
	}
	public String getDist(){
		return this.dist;
	}
	public double getHRate(){
		return Double.parseDouble(this.hRate);
	}
	public String getSpeed(){
		return this.speed;
	}
	public String getCadence(){
		return this.cadence;
	}
	
	
	public String fixRow(){
		String s = "";
		for (int i=0; i<this.row.length();i++){
			if(this.row.charAt(i) != ';' ){
				s += this.row.charAt(i);
			} else {
				String newRow = this.row.substring(i+1, this.row.length());
				this.row = newRow;
				break;
			}
		}
		return s.replaceAll(",", ".");
	}
	
	
	
//	public static void main(String[] args){
//		TrackPoint s = new TrackPoint("2016-09-24;11:50:57;54;18,178385;59,359623;27,2;116,8;123,0;9,3;162,0");
//		System.out.println(s.getDate());
//		System.out.println(s.getTime());
//		System.out.println(s.getElapsedTime());
//		System.out.println(s.getLng());
//		System.out.println(s.getLat());
//		System.out.println(s.getAlt());
//		System.out.println(s.getDist());
//		System.out.println(s.getHRate());
//		System.out.println(s.getSpeed());
//		System.out.println(s.getCadence());
//	}
}
