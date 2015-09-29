package model;

import java.util.ArrayList;

/**
 * A match is composed of 4 rounds (seasons)
 * @author mellenguyen
 *
 */
public class Match {
	private ArrayList<Round>	rounds = new ArrayList<Round>();
	private ArrayList<Player> 	players;
	private Player 				firstPlayer;
	
	public Match(ArrayList<Player> players, Player firstPlayer) {
		this.setPlayers(players);
		this.firstPlayer = firstPlayer;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void start() {
		this.rounds.add(new Round(Season.SPRING));
		
		this.rounds.get(rounds.size() - 1).execute(this.firstPlayer, this.players);
	}

}