package model;

import java.util.ArrayList;

public class Person extends Player {

	public Person(String name, int age) {
		super(name, age);
	}

	@Override
	public ArrayList<Player> play(TextUI textUI, SeasonType seasonType, ArrayList<Player> players) {
		String s;
		int size = this.getCards().size();
		int indexChosenCard;
		Card chosenCard;
		int actionChoice;
		
		// Check if this is the last card in hand (the player doesn't have any choice left)
		if (size > 1) {
			s = "Pick a card (between 1 and " + size + ")";
			indexChosenCard = textUI.readInt(s, 1, size);
			chosenCard = this.cards.get(indexChosenCard);
			textUI.showMessage(chosenCard);
			
			s = "Pick the action between :\n(1) Giant (2) Fertilizer (3) Goblin :";
			actionChoice = textUI.readInt(s, 1, 3);
			
			switch (actionChoice) {
				case 1 :
					this.addStones(2);
					textUI.showMessage("A giant gave you 2 stones.");
				case 2 :
					
			}
			
		} else {
			
		}
		return players;
	}

}
