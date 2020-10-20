package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class ActivityManager {
	private List<Activity> activities = new LinkedList<>();

	
	public ActivityManager(){
		
	}
	public void addActivity(String name){
		activities.add(new Activity(name));
	}
	public void removeActivity(String name){
		for(Activity a : activities){
			if(name == a.getName()){
				activities.remove(activities.indexOf(a));
			}
		}
	}
	public List<Activity> getAllActivities(){
		return activities;
	}
	
}
