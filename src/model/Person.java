package model;

import java.util.ArrayList;

public class Person extends Player {

	public Person(String name, int age) {
		super(name, age);
	}

	@Override
	public ArrayList<Player> play(TextUI textUI, SeasonType seasonType, ArrayList<Player> players) {
		return players;
	}

}
