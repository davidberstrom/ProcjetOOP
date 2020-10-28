package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import Observer.Observable;
import Observer.Observer;
import model.Activity;
import model.User;

public class Session implements Observable {
	private static Session instance;
	private User user;
	private Activity currActivity;
	private List<Observer> updates= new ArrayList<>();
	private Activity newActivity;
	private Session() {
		
	}
	
	public static Session getInstance() {
		if(instance == null)
			instance = new Session();
		return instance;
	}
	
	public void setUser(User u) {
		this.user = u;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public Activity getCurrActivity() {
		if(!user.getUserAM().getActivities().isEmpty()) {
			currActivity = user.getUserAM().getActivities().get(0); 
			newActivity = user.getUserAM().getActivities().getFirst();
		}else {
			currActivity = new Activity(new File("C:/Users/David/Desktop/OOP/csv/vildmarksmilenHemligbyGävle/activity_103378385.csv"), "Springa");
		}
		return currActivity;
	}
	
	public void setCurrActivity(Activity a) {
		this.currActivity = a;
		newActivity = a;
		notifySubscribers();
	}

	@Override
	public void addSubscriber(Observer observer) {
		updates.add(observer);
		
	}

	@Override
	public void removeSubscriber(Observer observer) {
		updates.remove(observer);
		
	}

	@Override
	public void notifySubscribers() {
		for(Observer o: updates){
			o.update();
		}
		
	}

	@Override
	public Activity getNewActivity() {
		return newActivity;
	}
}
