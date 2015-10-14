package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The player tries to plant has much Menhirs as possible
 * @author mellenguyen
 *
 */
public class PlantStrategy implements GameStrategy {

	@Override
	public ArrayList<Player> play(SeasonType seasonType, Player p, ArrayList<Player> players) {
		int nbStones = p.getStones();
		Iterator<Card> cardsIterator = p.getCards().iterator();
		Card c;
		int value;
		
		Card chosenCard = null;
		int chosenValue = 0;
		
		// if the player has stones, he will try to plant them
		if (nbStones > 0) {
			while (cardsIterator.hasNext()) {
				c = cardsIterator.next();
				value = c.getCharacter(CharacterType.FERTILIZER).getValue(seasonType);
				if (value > chosenValue) {
					chosenValue = value;
					chosenCard = c;
				}
				if (chosenValue == nbStones) {
					chosenCard = c;
					break;
				}
			}
			if (nbStones <= chosenValue) {
				p.addMenhirsMatch(nbStones);
				p.removeStones(nbStones);
			} else {
				p.addMenhirsMatch(chosenValue);
				p.removeStones(chosenValue);
			}
			p.removeCard(chosenCard);
		} else {
			// ... otherwise, he will try to get as much stones as possible
			while (cardsIterator.hasNext()) {
				c = cardsIterator.next();
				value = c.getCharacter(CharacterType.GIANT).getValue(seasonType);
				if (value > chosenValue) {
					chosenValue = value;
					chosenCard = c;
				}
			}
			p.addStones(chosenValue);
			p.removeCard(chosenCard);
		}
		players.set(players.indexOf(p), p);
		return players;		
	}

}
