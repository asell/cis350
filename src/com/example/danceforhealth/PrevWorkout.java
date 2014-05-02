package com.example.danceforhealth;

import java.util.ArrayList;
import java.util.List;

public class PrevWorkout {
	
	private static PrevWorkout singletonInstance = null;
	private List<Workout> previous;
	
	private PrevWorkout() {
		previous = new ArrayList<Workout>();
	}
	
	public static PrevWorkout getInstance() {
		if (singletonInstance == null) {
			singletonInstance = new PrevWorkout();
		}
		return singletonInstance;
	}
	
	public void add(Workout wo) {
		previous.add(wo);
	}
	
	public List<Workout> getPrevious() {
		return previous;
	}
	
	public int size() {
		return previous.size();
	}

}
