package model;

import java.util.ArrayList;

/**
 * Each player plays his turn
 * @author mellenguyen
 *
 */
public class Round {
	private SeasonType season;
	
	public Round(SeasonType season) {
		this.season = season;
	}
	
	/**
	 * Deal cards to players
	 * @param players
	 * @param cards
	 * @return
	 */
	public ArrayList<Player> dealCards(ArrayList<Player> players, ArrayList<Card> cards) {
		
	}
	
	/**
	 * Play a round of a match
	 */
	public void execute(Player firstPlayer, ArrayList<Player> players) {
		PlayersIterator it = new PlayersIterator(players, firstPlayer);
		while (it.hasNext()) {
			System.out.println(it.next());
			
			// player.strategy.play()
		}
	}

}
