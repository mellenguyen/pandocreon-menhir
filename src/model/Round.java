package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
	 * Play the round
	 */
	public void execute(TextUI textUI, Player firstPlayer, ArrayList<Player> players) {
		Iterator<Player> playersIteratorDisplay = players.iterator();
		PlayersIterator playersIterator = new PlayersIterator(players, firstPlayer);
		Iterator<Card> cardsIterator;
		int counterCard;
		Player p;
		
		while (playersIterator.hasNext()) {
			textUI.readContinue("Press any key to continue");
			// Displays players and their cards before each turn
			while (playersIteratorDisplay.hasNext()) {
				p = playersIteratorDisplay.next();
				textUI.showMessage(p);
				cardsIterator = p.getCards().iterator();
				counterCard = 0;
				while (cardsIterator.hasNext()) {
					textUI.showMessage("Card n°"+ ++counterCard);
					textUI.showMessage(cardsIterator.next());
				}
			}
			playersIteratorDisplay = players.iterator();
			
			p = playersIterator.next();
			p.play(textUI, this.season, players);
			
			textUI.showMessage("Score : ");
			for (Player pl : players) {
				System.out.println(pl.scoreToString());
			}
		}
	}
}
