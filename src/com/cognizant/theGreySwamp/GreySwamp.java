package com.cognizant.theGreySwamp;

import java.util.Scanner;

public class GreySwamp {

	void start() {
			// Creates instances of Player and Treasure
			Player player = new Player();
			Treasure treasure = new Treasure();

			// For testing purposes. Keep as comments for a full game experience.
			// System.out.println("Treasure x = " + treasure.getE());
			// System.out.println("Treasure y = " + treasure.getN());

			// Messages to players stored as strings
			String intro = "\n\n\nWelcome to THE GREY SWAMP. Let the story begin..."
					+ "\n\nGrey foggy clouds float oppressively close to you,"
					+ "\nreflected in the murky grey water which reaches up your shins."
					+ "\nSome black plants barely poke out of the shallow water."
					+ "\nYou look at your hands but they look unfamiliar."
					+ "\nWhat is going on? What has happened? Who are you?"
					+ "\nYou look all around you but every horizon looks identical."
					+ "\nYou want to get out of this place so you decide to start walking...";
			String hitEnter = "\n\nPress Enter to continue...";
			String firstChoice = "Which direction would you like to go (n/s/e/w)?";
			String findDevice = " until you notice the twinkling of a small watch-like device partially submerged in the water."
					+ "\nIt has hands like a digital watch, but it's doesn't seem to tell time."
					+ "\nAttached is a compass.";
			String playerLocation = "Your current location is N%d E%d.\nWhich direction do you want to walk (n/s/e/w)?\n";
			String closer = "\nThe sky is clearing a little. You are getting closer...";
			String further = "\nThe sky is darkening a little. You are getting further away...";
			String theEnd = "\nSuddenly greyness of the sky dissolves away and is replaced by a glorious blue hue."
					+ "\nThe water is perfectly transparent but you notice an ominous treasure chest resting on the not-so-swampy swamp floor."
					+ "\nYou decide to open it... a weird swirly cloud floats out and when you squint into the centre of it,"
					+ "\nyou make out a familiar building you that reminds you of home..."
					+ "\nYou realise you're looking into a portal! You leap into it and instantly, you're home.\n\n\n THE END."
					;

			// Game starts
			System.out.println(intro + hitEnter);
			input();
			System.out.println(firstChoice);
			System.out.println("\nYou head " + fullWord() + findDevice + hitEnter);
			input();

			boolean wrongLocation = true;
			while (wrongLocation) {

				// Tells player their current location
				System.out.printf(playerLocation, player.getN(), player.getE());

				// Coordinates of player prior to making a move
				int ePrev = player.getE();
				int nPrev = player.getN();

				// Player makes a move n/s/e/w and player's coordinates update
				Player.move(input());

				// Messages to player stating how close they are to their destination
				if (Math.abs(ePrev - treasure.getE()) > Math.abs(player.getE() - treasure.getE())
						| Math.abs(nPrev - treasure.getN()) > Math.abs(player.getN() - treasure.getN())) {
					System.out.println(closer);
				} else if (Math.abs(ePrev - treasure.getE()) < Math.abs(player.getE() - treasure.getE())
						| Math.abs(nPrev - treasure.getN()) < Math.abs(player.getN() - treasure.getN())) {
					System.out.println(further);
				} else {
					System.out.println("You stood still.");
				}

				// Check if player and treasure's coordinates match.
				// If yes then the while loop is exited.
				if (player.getE() == treasure.getE() && player.getN() == treasure.getN()) {
					wrongLocation = false;
				}
			}
			// Game won.
			System.out.println(theEnd);
	}

	// Creating a scanner to use player input
	public static String input() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

	// Translates shortened direction to full word i.e. n -> north
	public static String fullWord() {
		String userDir = input();

		if (userDir.equals("n")) {
			return "north";
		} else if (userDir.equals("s")) {
			return "south";
		} else if (userDir.equals("e")) {
			return "east";
		} else if (userDir.equals("w")) {
			return "west";
		} else {
			return "in some unknown direction";
		}
	}
}

// Copyrighted intellectual property. Created by Celeste Brant.
