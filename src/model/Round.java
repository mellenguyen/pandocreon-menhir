package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Each player plays his turn
 * @author mellenguyen
 *
 */
public class Round {
	private Season season;
	
	public Round(Season season) {
		this.season = season;
	}
	
	/**
	 * Play a round of a match
	 */
	public void execute(Player firstPlayer, ArrayList<Player> players) {
		Iterator<Player> PlayersIterator = players.iterator();
		while (PlayersIterator.hasNext()) {
			System.out.println(PlayersIterator.next());
		}
	}

}
