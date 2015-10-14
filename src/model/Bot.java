package model;

import java.util.ArrayList;

public class Bot extends Player {
	private GameStrategy strategy;
	
	public Bot(String name, int age, GameStrategy strategy) {
		super(name, age);
		this.strategy = strategy;
	}

	@Override
	public ArrayList<Player> play(TextUI textUI, SeasonType seasonType, ArrayList<Player> players) {
		System.out.println(this.toString() + " is going to play");
		for (Player p : players) {
			System.out.println(p.scoreToString());
		}
		return this.strategy.play(seasonType, this, players);
	}
}
