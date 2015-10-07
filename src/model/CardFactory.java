package model;

import java.util.ArrayList;

/**
 * This factory create cards; a card can be an ingredient which has 3 characters : giant, fertilizer and goblin, or can be a special card
 * that is used only with an advanced game.
 * @author mellenguyen
 *
 */
public class CardFactory {
	public static enum CardType {
		INGREDIENT,
		SPECIAL_CARD;
	}
	
	public CardFactory() {}
	
	public ArrayList<Card> createCards(CardType cardType) {
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Character> characters = new ArrayList<Character>();
		
		switch (cardType) {
			case INGREDIENT:
				Character giant = new Character(CharacterType.GIANT, 1, 1, 1, 1);
				characters.add(giant);
				Character fertilizer = new Character(CharacterType.FERTILIZER, 2, 0, 1, 1);
				characters.add(fertilizer);
				Character goblin = new Character(CharacterType.GOBLIN, 2, 0, 2, 0);
				characters.add(goblin);
				cards.add(new Ingredient(characters));
				
				characters.get(0).changeSeasons(2, 0, 1, 1);
				characters.get(1).changeSeasons(1, 3, 0, 0);
				characters.get(2).changeSeasons(0, 1, 2, 1);
				cards.add(new Ingredient(characters));
				
				characters.get(0).changeSeasons(0, 0, 4, 0);
				characters.get(1).changeSeasons(0, 2, 2, 0);
				characters.get(2).changeSeasons(0, 0, 1, 3);
				cards.add(new Ingredient(characters));
				
				break;
			case SPECIAL_CARD:
				break;
			default:		
			
		}
		return cards;
	}

}
