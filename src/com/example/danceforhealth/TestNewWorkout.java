package com.example.danceforhealth;

import junit.framework.TestCase;

public class TestNewWorkout extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testOnCreate() throws Exception {
		NewWorkoutActivity a = new NewWorkoutActivity();
		a.onCreate(null);
		assertEquals(a.selection, "Dance");
	}
}
