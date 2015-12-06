package model;

import java.util.ArrayList;

public class Person extends Player {

	public Person(String name, int age) {
		super(name, age);
	}

	@Override
	public void play(TextUI textUI, SeasonType seasonType, ArrayList<Player> players) {
		String s;
		int size = this.getCards().size();
		int indexChosenCard;
		Card chosenCard;
		int actionChoice;
		int value;
		int temp;	// difference between number of stones of player and the number of menhirs he can plant with his/her card
		Player p;
		
		textUI.showMessage("This is your turn for " + seasonType.toString());
		
		// Check if this is the last card in hand (the player doesn't have any choice left)
		if (size > 1) {
			s = "Pick a card (between 1 and " + size + ") : ";
			indexChosenCard = textUI.readInt(s, 1, size);
			chosenCard = this.cards.get(indexChosenCard - 1);
			textUI.showMessage(chosenCard);
		} else {
			chosenCard = this.cards.get(0);
		}
		
		s = "Pick the action between :\n(1) Giant (2) Fertilizer (3) Goblin : ";
		actionChoice = textUI.readInt(s, 1, 3);
		
		switch (actionChoice) {
			case 1 :
				value = chosenCard.getCharacter(CharacterType.GIANT).getValue(seasonType);
				this.addStones(value);
				textUI.showMessage("A giant gave you " + value + " stone(s).");
				break;
			case 2 :
				value = chosenCard.getCharacter(CharacterType.FERTILIZER).getValue(seasonType);
				temp = this.getStones() - value;
				if (temp > 0) {
					this.setStones(temp);
					this.addMenhirsMatch(value);
				} else {
					value = this.getStones();
					this.addMenhirsMatch(this.getStones());
					this.setStones(0);
				}
				textUI.showMessage("You have planted " + value + " menhir(s).");
				break;
			case 3 :
				value = chosenCard.getCharacter(CharacterType.GOBLIN).getValue(seasonType);
				temp = textUI.readInt("Who would you like to steal from ? ", 1, players.size() - 1);
				p = players.get(temp - 1);
				if (p.getStones() - value < 0) {
					value = p.getStones();
				}
				p.setStones(p.getStones() - value);
				this.setStones(this.getStones() + value);
				textUI.showMessage("You have stolen " + value + " stone(s) from " + p.getName() + ". You have now " + this.getStones()+
						" stone(s) and " + p.getName() + " has now " + p.getStones() + " stone(s).");
				break;
			default:
				break;
		}
		
		this.cards.remove(chosenCard);
	}

}
