package model;

import java.util.ArrayList;

public abstract class Game {
	protected ArrayList<Player> players;
	protected ArrayList<Card> cards;
	
	public Game(){	
	}
	
	public Game(ArrayList<Player> players, ArrayList<Card> cards) {
		this.players = players;
		this.cards = cards;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public abstract GameFactory.GameType getGameType();
	
	public abstract void start(TextUI textUI);
}
