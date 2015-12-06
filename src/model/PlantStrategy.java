package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The player tries to plant has much Menhirs as possible
 * @author mellenguyen
 *
 */
public class PlantStrategy implements GameStrategy {
	private static PlantStrategy INSTANCE = new PlantStrategy();
	
	private PlantStrategy() {}
	
	public static PlantStrategy getInstance() {
		return INSTANCE;
	}
	
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.PLANT;
	}

	@Override
	public void play(TextUI textUI, SeasonType seasonType, Player p, ArrayList<Player> players) {
		int actualNbStones = p.getStones();
		Iterator<Card> cardsIterator = p.getCards().iterator();
		Card c;
		int value;
		
		Card chosenCard = null;
		int chosenValue = -1;
		int nbPlantedMenhirs;
		
		// if the player has stones, he will try to plant them
		if (actualNbStones > 0) {
			while (cardsIterator.hasNext()) {
				c = cardsIterator.next();
				value = c.getCharacter(CharacterType.FERTILIZER).getValue(seasonType);
				if (value == actualNbStones) {
					// we found the exact amount of fertilizable stones so we can get out of this loop
					chosenValue = value;
					chosenCard = c;
					break;
				} else if (value > chosenValue && chosenValue < actualNbStones) {
					chosenValue = value;
					chosenCard = c;
				}
			}
			// remove the amount of stones and turn them in menhirs
			if (actualNbStones <= chosenValue) {
				p.addMenhirsMatch(actualNbStones);
				p.removeStones(actualNbStones);
				nbPlantedMenhirs = actualNbStones;
			} else {
				p.addMenhirsMatch(chosenValue);
				p.removeStones(chosenValue);
				nbPlantedMenhirs = chosenValue;
			}
			p.removeCard(chosenCard);
			String menhirs = "";
			if (nbPlantedMenhirs > 1) {
				menhirs = " menhirs. ";
			} else {
				menhirs = " menhir.";
			}
			textUI.showMessage(p.toString() + " has planted " + nbPlantedMenhirs + menhirs);
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
			String stones = "";
			if (chosenValue > 1) {
				stones = " stones";
			} else {
				stones = " stone";
			}
			textUI.showMessage(p.toString() + " has received " + chosenValue + stones + " from the Giant.");
		}
	}

}
