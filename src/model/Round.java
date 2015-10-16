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
	 * Deal cards to players. Each player has 4 ingredient cards.
	 * @param players
	 * @param cards
	 * @return
	 */
	public ArrayList<Player> dealCards(ArrayList<Player> players, ArrayList<Card> cards) {
		Iterator<Player> playersIterator = players.iterator();
		Collections.shuffle(cards);
		Iterator<Card> cardsIterator = cards.iterator();
		Player p;
		
		while (playersIterator.hasNext()) {
			p = playersIterator.next();
			for (int i = 0; i < 4; i++) {
				if (cardsIterator.hasNext()) {
					p.addCard(cardsIterator.next());
				} else {
					// Exception : pas assez de cartes
				}
			}
		}
		return players;
	}
	
	/**
	 * Play a round of a match
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
			players = p.play(textUI, this.season, players);
		}
	}
}
