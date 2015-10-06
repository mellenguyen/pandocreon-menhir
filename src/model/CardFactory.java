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
	
	public Card createCard(CardType cardType, ArrayList<Integer> values) {
		Card card = null;
		ArrayList<Character> characters = new ArrayList<Character>();
		
		switch (cardType) {
			case INGREDIENT:
				Character giant = new Character(CharacterType.GIANT);
				giant.addSeason(SeasonType.SPRING, 4);
				giant.addSeason(SeasonType.SUMMER, 3);
				giant.addSeason(SeasonType.AUTUMN, 5);
				giant.addSeason(SeasonType.WINTER, 2);
				characters.add(giant);
				
				Character fertilizer = new Character(CharacterType.FERTILIZER);
				fertilizer.addSeason(SeasonType.SPRING, 2);
				fertilizer.addSeason(SeasonType.SUMMER, 4);
				fertilizer.addSeason(SeasonType.AUTUMN, 1);
				fertilizer.addSeason(SeasonType.WINTER, 3);
				characters.add(fertilizer);
				
				Character goblin = new Character(CharacterType.GOBLIN);
				goblin.addSeason(SeasonType.SPRING, 3);
				goblin.addSeason(SeasonType.SUMMER, 3);
				goblin.addSeason(SeasonType.AUTUMN, 2);
				goblin.addSeason(SeasonType.WINTER, 4);
				characters.add(goblin);
						
				card = new Ingredient(characters);
				break;
			case SPECIAL_CARD:
				break;
			default:		
			
		}
		return card;
	}

}
