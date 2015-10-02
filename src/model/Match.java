package model;

import java.util.ArrayList;

/**
 * A match is composed of 4 rounds (seasons)
 * @author mellenguyen
 *
 */
public class Match {
	private ArrayList<Round>  rounds = new ArrayList<Round>();
	private ArrayList<Player> players;
	private Player 			  firstPlayer;
	
	public Match(ArrayList<Player> players) {
		this.players = players;
	}
		
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public void start() {
		this.rounds.add(new Round(SeasonType.SPRING));
		
		this.rounds.get(rounds.size() - 1).execute(this.firstPlayer, this.players);
	}

}