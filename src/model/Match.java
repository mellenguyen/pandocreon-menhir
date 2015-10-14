package model;

import java.util.ArrayList;

/**
 * A match is composed of 4 rounds (seasons)
 * @author mellenguyen
 *
 */
public class Match {
	private Game game;
	private ArrayList<Round>  rounds = new ArrayList<Round>();
	private ArrayList<Player> players;
	private Player 			  firstPlayer;
	private ArrayList<Card>	  cards;
	
	public Match(ArrayList<Player> players, Game game, ArrayList<Card> cards) {
		this.players = players;
		this.game = game;
		this.cards = cards;
	}
		
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public void start(TextUI textUI) {
		this.rounds.add(new Round(SeasonType.SPRING));
		this.rounds.get(rounds.size() - 1).dealCards(this.players, this.cards);
		this.rounds.get(rounds.size() - 1).execute(textUI, this.firstPlayer, this.players);
	}

}