package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Activity {
	private List<Object> temp = new LinkedList<>();
	private LinkedList<TrackPoint> list= new LinkedList<>();
	private String file;
	private String name;
	
	public Activity(String name){
		this.file = file;
		this.name = name;
		temp = FileReaderDAO.getInstance().createActivity("C:/Users/David/Desktop/OOP/csv/lidingöloppetStockholm/20190928_112002AH.csv");
		for(int i=0;i<temp.size();i++){
			list.add((TrackPoint)temp.get(i));
		}
	}
	
	public double getDist(){
		String dist = list.get(list.size()-1).getDist();
		return Double.parseDouble(dist);
	}
	
	public double getAverageHRate(){
		double agr=0.0;
		for(TrackPoint p : list ){
			agr+= p.getHRate();
		}
		return agr/list.size();
	}
	
	public double getMinHRate(){
		double [] heartRate = new double[list.size()];
		
		
		for (int j = 0; j<list.size();j++){
			heartRate[j] = list.get(j).getHRate();
			}
		double min=heartRate[0];
		
		for(int i=0; i<heartRate.length;i++){
			if(heartRate[i]<min){
				min =heartRate[i];
			}
		}
		return min;
	}
	
	public double getMaxHRate(){
		double [] heartRate = new double[list.size()];
		double max = heartRate[0];
		for (int j = 0; j<list.size();j++){
			heartRate[j] = list.get(j).getHRate();
			}
		for (int i= 1;i<heartRate.length;i++){
			if(heartRate[i]>max){
				max = heartRate[i];
			}
		}
		return max;
	}
	
	public void getAllTimes(){
		String[] times = new String[list.size()];
		for (int j = 0; j<list.size();j++){
			times[j] = list.get(j).getTime();
			System.out.println(times[j]);
		}
	}
	
	public double getAverageSpeed(){
		double agr=0.0;
		for(TrackPoint p : list ){
			agr+= Double.parseDouble(p.getSpeed());
		}
		return agr/list.size();
	}
	
	public double getMaxSpeed(){
		double [] speed = new double[list.size()];
		double max = speed[0];
		for (int j = 0; j<list.size();j++){
			speed[j] = Double.parseDouble(list.get(j).getSpeed());
			}
		for (int i= 1;i<speed.length;i++){
			if(speed[i]>max){
				max = speed[i];
			}
		}
		return max;
	}
	
	public double getMinSpeed(){
		double [] speed= new double[list.size()];
		
		
		for (int j = 0; j<list.size();j++){
			speed[j] = Double.parseDouble(list.get(j).getSpeed());
			}
		double min=speed[0];
		
		for(int i=0; i<speed.length;i++){
			if(speed[i]<min){
				min =speed[i];
			}
		}
		return min;
	}

	public double getMaxAlt(){
		double [] alt = new double[list.size()];
		double max = alt[0];
		for (int j = 0; j<list.size();j++){
			alt[j] = Double.parseDouble(list.get(j).getAlt());
			}
		for (int i= 1;i<alt.length;i++){
			if(alt[i]>max){
				max = alt[i];
			}
		}
		return max;
	}
	
	public double getMinAlt(){
		double [] alt= new double[list.size()];
		
		
		for (int j = 0; j<list.size();j++){
			alt[j] = Double.parseDouble(list.get(j).getAlt());
			}
		double min=alt[0];
		
		for(int i=0; i<alt.length;i++){
			if(alt[i]<min){
				min =alt[i];
			}
		}
		return min;
	}
	
	public double getAverageAlt(){
		double agr=0.0;
		for(TrackPoint p : list ){
			agr+= Double.parseDouble(p.getAlt());
		}
		return agr/list.size();
	}
	
	public double getMaxCad(){
		double [] cad = new double[list.size()];
		double max = cad[0];
		for (int j = 0; j<list.size();j++){
			cad[j] = Double.parseDouble(list.get(j).getCadence());
			}
		for (int i= 1;i<cad.length;i++){
			if(cad[i]>max){
				max = cad[i];
			}
		}
		return max;
	}
	
	public double getMinCad(){
		double [] cad= new double[list.size()];
		
		
		for (int j = 0; j<list.size();j++){
			cad[j] = Double.parseDouble(list.get(j).getCadence());
			}
		double min=cad[0];
		
		for(int i=0; i<cad.length;i++){
			if(cad[i]<min){
				min =cad[i];
			}
		}
		return min;
	}

	public double getAverageCad(){
		double agr=0.0;
		for(TrackPoint p : list ){
			agr+= Double.parseDouble(p.getCadence());
		}
		return agr/list.size();
	}
	
	public String getName(){
		return name;
	}

	public LinkedList<TrackPoint> getTrackPoints(){
		return list;
		
	}
//	public static void main(String[] args) {
//		Activity a = new Activity("");
//		TrackPoint p ;
//		System.out.println(a.getMaxAlt());
//		System.out.println(a.getMinAlt());
//		System.out.println(a.getAverageAlt());
//		System.out.println(a.getMaxSpeed());
//		System.out.println(a.getMinSpeed());
//		System.out.println(a.getAverageSpeed());
//		System.out.println(a.getMaxCad());
//		System.out.println(a.getMinCad());
//		System.out.println(a.getAverageCad());
//		System.out.println(a.getMaxHRate());
//		System.out.println(a.getMinHRate());
//		System.out.println(a.getAverageHRate());
//	
//   }
}
