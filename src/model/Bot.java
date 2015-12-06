package model;

import java.util.ArrayList;

public class Bot extends Player {
	private GameStrategy strategy;
	
	public Bot(String name, int age, GameStrategy strategy) {
		super(name, age);
		this.strategy = strategy;
	}
	
	public GameStrategy getStrategy() {
		return this.strategy;
	}

	@Override
	public void play(TextUI textUI, SeasonType seasonType, ArrayList<Player> players) {
		textUI.showMessage(this.toString() + "'s turn for " + seasonType.toString() + " :");
		this.strategy.play(textUI, seasonType, this, players);
	}
}
