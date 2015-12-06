package model;

import java.util.ArrayList;

public abstract class Game {
	protected ArrayList<Player> players;
	
	public Game(){	
	}
	
	public Game(ArrayList<Player> players) {
		this.players = players;
		this.initializePlayers();
	}
	
	public abstract void initializePlayers();
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public abstract GameFactory.GameType getGameType();
	
	public abstract void start(TextUI textUI);
}
