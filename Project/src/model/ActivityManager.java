package model;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;

public class ActivityManager implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<Activity> list = new LinkedList<>();
	String name;
	public ActivityManager() {
	}

	public void addActivity(File file, String name) {
		this.name=name;
		list.add(new Activity(file,name));
	}
	
	public void removeActivity(String name) {
		for(Activity a : list) {
			if(a.getName().equalsIgnoreCase(name)) {
				list.remove(a);
				a = null;
			}
		}
	}
	
	public Activity getActivity(String name) {
		for(Activity a : list) {
			if(a.getName().equalsIgnoreCase(name)) {
				return a;
			}
		}
		return null;
	}
	
	public LinkedList<Activity> getActivities(){
		return list;
	}
	public String getActivityName(){
		return name;
	}
}
