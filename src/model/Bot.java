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
		textUI.showMessage(this.toString() + "'s turn for " + seasonType.toString() + ":");
		return this.strategy.play(textUI, seasonType, this, players);
	}
}
