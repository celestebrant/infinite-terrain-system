package com.cognizant.theGreySwamp;

public class Treasure {

	private int max = 4;
	private int min = -4;
	private int e;
	private int n;

	Treasure() {
		setE((int) (Math.random() * (max - min)) + min);
		setN((int) (Math.random() * (max - min)) + min);
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
		this.e = e;
	}

	public void setN(int n) {
		this.n = n;
	}
}
