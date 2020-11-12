package com.cognizant.theGreySwamp;

public class Player {

	private static int e;
	private static int n;

	// Constructor
	Player() {
		setE(0);
		setN(0);
	}

	// Functions
	public static void move(String direction) {

		if (direction.equals("n")) {
			n++;
		} else if (direction.equals("s")) {
			n--;
		} else if (direction.equals("e")) {
			e++;
		} else if (direction.equals("w")) {
			e--;
		} else {
			System.out.println("\nTry again.");
		}
	}

	// Getters
	public int getE() {
		return e;
	}

	public int getN() {
		return n;
	}

	// Setters
	public void setE(int e) {
		Player.e = e;
	}

	public void setN(int n) {
		Player.n = n;
	}
}
