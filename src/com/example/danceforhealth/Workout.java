package com.example.danceforhealth;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Workout implements Parcelable {
	private String type;
	private int strain;
	private int heartrate;
	private int steps;
	private int weight;
	private String date;
	
	public Workout(String type, int strain, int hr, int st, int wt) {
		this.type = type;
		this.strain = strain;
		this.heartrate = hr;
		this.steps = st;
		this.weight = wt;
		Date date = new Date();
		this.date = date.toString();
		
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(int heartrate) {
		this.heartrate = heartrate;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStrain(int strain) {
		this.strain = strain;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return (this.getType() + "\n" + this.getDate());
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
