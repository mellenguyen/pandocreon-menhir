package model;

import java.util.ArrayList;
import java.util.Iterator;

public class FightStrategy implements GameStrategy {
	private static FightStrategy INSTANCE = new FightStrategy();
	
	private FightStrategy() {}
	
	public static FightStrategy getInstance() {
		return INSTANCE;
	}
	
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.FIGHT;
	}

	@Override
	public void play(TextUI textUI, SeasonType seasonType, Player p, ArrayList<Player> players) {
		Player target = null;
		Iterator<Card> cardsIterator = p.getCards().iterator();
		Card card;
		int value;
		
		Card chosenCard = null;
		int chosenValue = -1;
		
		// Does the player p has a giant mole as a special card ?
		if (p.getSpecialCard() != null) {
			Character chara= p.getSpecialCard().getCharacter(CharacterType.GIANT_MOLE);
			if (chara != null) {
				if (chara.getValue(seasonType) > 0) {
					// Looking for a potential target
					int menhirs = -1;
					for (Player player : players) {
						if (menhirs < player.getMenhirsMatch()) {
							menhirs = player.getMenhirsMatch();
							target = player;
						}
					}
					if (menhirs != 0) { // if = 0, nobody has any menhir so it's useless to use special card
						target.setMenhirsMatch(target.getMenhirsMatch() - chara.getValue(seasonType));
						p.removeSpecialCard();
						textUI.showMessage("You have destroyed " + chara.getValue(seasonType) + " that belonged to " + target + ". " + target + " now has " + target.getMenhirsMatch());
					}
				}
			}
		} else { // otherwise, trying to steal stones
			int stones = -1;
			for (Player player : players) {
				if (stones < player.getStones()) {
					stones = player.getStones();
					target = player;
				}
			}
			if (stones != 0) { // if there are stones to steal				
				while (cardsIterator.hasNext()) {
					card = cardsIterator.next();
					value = card.getCharacter(CharacterType.GOBLIN).getValue(seasonType);
					if (value == stones) {
						// we found the exact amount of stones to steal so we can get out of this loop
						chosenValue = value;
						chosenCard = card;
						break;
					} else if (value > chosenValue && chosenValue < stones) {
						chosenValue = value;
						chosenCard = card;
					}
				}
				target.removeStones(chosenValue);
				p.addStones(chosenValue);
				p.removeCard(chosenCard);
				textUI.showMessage("You have stolen " + chosenValue + " from " + target + ". " + target + " now has " + target.getStones());
				return;
			}
		}
		
		// TODO: if we can't attack other players, use plant strategy. Nasty copy/paste, will be changed
		
		int actualNbStones = p.getStones();
		cardsIterator = p.getCards().iterator();
		card = null;
		value = 0;
		
		chosenCard = null;
		chosenValue = -1;
		int nbPlantedMenhirs;
		
		// if the player has stones, he will try to plant them
		if (actualNbStones > 0) {
			while (cardsIterator.hasNext()) {
				card = cardsIterator.next();
				value = card.getCharacter(CharacterType.FERTILIZER).getValue(seasonType);
				if (value == actualNbStones) {
					// we found the exact amount of fertilizable stones so we can get out of this loop
					chosenValue = value;
					chosenCard = card;
					break;
				} else if (value > chosenValue && chosenValue < actualNbStones) {
					chosenValue = value;
					chosenCard = card;
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
				card = cardsIterator.next();
				value = card.getCharacter(CharacterType.GIANT).getValue(seasonType);
				if (value > chosenValue) {
					chosenValue = value;
					chosenCard = card;
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
