package com.example.danceforhealth;

public class Workout {
	private String type;
	private int strain;
	private int heartrate;
	private int steps;
	private int weight;
	
	public Workout(String type, int strain, int hr, int st, int wt) {
		this.type = type;
		this.strain = strain;
		this.heartrate = hr;
		this.steps = st;
		this.weight = wt;
	}
	
	public String getType() {
		return type;
	}
	
	public int getStrain() {
		return strain;
	}
	
	public int getHR() {
		return heartrate;
	}
	
	public int getSteps() {
		return steps;
	}
	
	public int getWeight() {
		return weight;
	}

}
