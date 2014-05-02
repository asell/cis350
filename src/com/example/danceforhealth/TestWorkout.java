package com.example.danceforhealth;

import junit.framework.TestCase;

public class TestWorkout extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	
	public void testConstructor() throws Exception {
		Workout w = new Workout("Allegra", 4, 6, 4, 27);
		assertEquals(w.getType(), "Allegra");
		assertEquals(w.getStrain(), 4);
		assertEquals(w.getHR(), 6);
		assertEquals(w.getSteps(), 4);
		assertEquals(w.getWeight(), 27);
	}
	
	public void testToString() throws Exception {
		Workout w = new Workout("Dance", 3, 5, 9, 11);
		//w.setDate("5");
		assertEquals("Dance\n5", w.toString());
		
	}
}
