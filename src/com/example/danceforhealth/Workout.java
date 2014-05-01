package com.example.danceforhealth;

import java.text.SimpleDateFormat;
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

	public Workout() {
		type = "";
		strain = 0;
		heartrate = 0;
		steps = 0;
		weight = 0;
		Date date = new Date();
		SimpleDateFormat ft = 
				new SimpleDateFormat ("E M dd yyyy");
		this.date = ft.format(date);
	}

	public Workout(String type, int strain, int hr, int st, int wt) {
		this.type = type;
		this.strain = strain;
		this.heartrate = hr;
		this.steps = st;
		this.weight = wt;
		Date date = new Date();
		SimpleDateFormat ft = 
				new SimpleDateFormat ("E M dd yyyy");
		this.date = ft.format(date);
	}

	public Workout(Parcel p) {
		setType(p.readString());
		setStrain(p.readInt());
		setHeartrate(p.readInt());
		setSteps(p.readInt());
		setDate(p.readString());

	}

	public String getDate() {
		return date;
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
	
	public void setDate(String date) {
		this.date = date;
	}

	public String toString() {
		return (this.getType() + " on \n" + this.getDate());
	}

	public static final Parcelable.Creator<Workout> CREATOR = new Creator<Workout>() {
		public Workout createFromParcel(Parcel source) {

			return new Workout(source);
		}

		public Workout[] newArray(int size) {

			return new Workout[size];
		}

	};


	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {

		parcel.writeString(getType());
		parcel.writeInt(getStrain());
		parcel.writeInt(getHR());
		parcel.writeInt(getSteps());
		parcel.writeInt(getWeight());
		parcel.writeString(getDate());

	}

}
