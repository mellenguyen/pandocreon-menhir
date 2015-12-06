package model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;

/**
 * This factory create cards; a card can be an ingredient which has 3 characters : giant, fertilizer and goblin, or can be a special card
 * that is used only with an advanced game.
 * @author mellenguyen
 *
 */
public class CardFactory {
	private static CardFactory INSTANCE = new CardFactory();
	
	public static enum CardType {
		INGREDIENT,
		SPECIAL_CARD;
	}
	
	private CardFactory() {}
	
	public static CardFactory getInstance() {
		return INSTANCE;
	}
	
	public ArrayList<Card> createCards(CardType cardType) {
		ArrayList<Card> cards = new ArrayList<Card>();
			
		switch (cardType) {
			case INGREDIENT:
				cards.add(createIngredient("Rayon de Lune",
						createCharacter(CharacterType.GIANT, 1, 1, 1, 1),
						createCharacter(CharacterType.FERTILIZER, 2, 0, 1, 1),
						createCharacter(CharacterType.GOBLIN, 2, 0, 2, 0)));
				
				cards.add(createIngredient("Rayon de Lune",
						createCharacter(CharacterType.GIANT, 2, 0, 1, 1),
						createCharacter(CharacterType.FERTILIZER, 1, 3, 0, 0),
						createCharacter(CharacterType.GOBLIN, 0, 1, 2, 1)));
				
				cards.add(createIngredient("Rayon de Lune",
						createCharacter(CharacterType.GIANT, 0, 0, 4, 0),
						createCharacter(CharacterType.FERTILIZER, 0, 2, 2, 0),
						createCharacter(CharacterType.GOBLIN, 0, 0, 1, 3)));
				
				cards.add(createIngredient("Champ de sirène",
						createCharacter(CharacterType.GIANT, 1, 3, 1, 0),
						createCharacter(CharacterType.FERTILIZER, 1, 2, 1, 1),
						createCharacter(CharacterType.GOBLIN, 0, 1, 4, 0)));
				
				cards.add(createIngredient("Champ de sirène",
						createCharacter(CharacterType.GIANT, 2, 1, 1, 1),
						createCharacter(CharacterType.FERTILIZER, 1, 0, 2, 2),
						createCharacter(CharacterType.GOBLIN, 3, 0, 0, 2)));
				
				cards.add(createIngredient("Champ de sirène",
						createCharacter(CharacterType.GIANT, 1, 2, 2, 0),
						createCharacter(CharacterType.FERTILIZER, 1, 1, 2, 1),
						createCharacter(CharacterType.GOBLIN, 2, 0, 1, 2)));
				
				cards.add(createIngredient("Larmes de dryade",
						createCharacter(CharacterType.GIANT, 2, 1, 1, 2),
						createCharacter(CharacterType.FERTILIZER, 1, 1, 1, 3),
						createCharacter(CharacterType.GOBLIN, 2, 0, 2, 2)));
				
				cards.add(createIngredient("Larmes de dryade",
						createCharacter(CharacterType.GIANT, 0, 3, 0, 3),
						createCharacter(CharacterType.FERTILIZER, 2, 1, 3, 0),
						createCharacter(CharacterType.GOBLIN, 1, 1, 3, 1)));
				
				cards.add(createIngredient("Larmes de dryade",
						createCharacter(CharacterType.GIANT, 1, 2, 1, 2),
						createCharacter(CharacterType.FERTILIZER, 1, 0, 1, 4),
						createCharacter(CharacterType.GOBLIN, 2, 4, 0, 0)));
				
				cards.add(createIngredient("Fontaine d'eau pure",
						createCharacter(CharacterType.GIANT, 1, 3, 1, 2),
						createCharacter(CharacterType.FERTILIZER, 2, 1, 2, 2),
						createCharacter(CharacterType.GOBLIN, 0, 0, 3, 4)));
				
				cards.add(createIngredient("Fontaine d'eau pure",
						createCharacter(CharacterType.GIANT, 2, 2, 0, 3),
						createCharacter(CharacterType.FERTILIZER, 1, 1, 4, 1),
						createCharacter(CharacterType.GOBLIN, 1, 2, 1, 3)));
				
				cards.add(createIngredient("Fontaine d'eau pure",
						createCharacter(CharacterType.GIANT, 2, 2, 3, 1),
						createCharacter(CharacterType.FERTILIZER, 2, 3, 0, 3),
						createCharacter(CharacterType.GOBLIN, 1, 1, 3, 3)));
				
				cards.add(createIngredient("Poudre d'or",
						createCharacter(CharacterType.GIANT, 2, 2, 3, 1),
						createCharacter(CharacterType.FERTILIZER, 2, 3, 0, 3),
						createCharacter(CharacterType.GOBLIN, 1, 1, 3, 3)));
				
				cards.add(createIngredient("Poudre d'or",
						createCharacter(CharacterType.GIANT, 2, 2, 2, 2),
						createCharacter(CharacterType.FERTILIZER, 0, 4, 4, 0),
						createCharacter(CharacterType.GOBLIN, 1, 3, 2, 2)));
				
				cards.add(createIngredient("Poudre d'or",
						createCharacter(CharacterType.GIANT, 3, 1, 3, 1),
						createCharacter(CharacterType.FERTILIZER, 1, 4, 2, 1),
						createCharacter(CharacterType.GOBLIN, 2, 4, 1, 1)));
				
				cards.add(createIngredient("Racines d'arc-en-ciel",
						createCharacter(CharacterType.GIANT, 4, 1, 1, 1),
						createCharacter(CharacterType.FERTILIZER, 1, 2, 1, 3),
						createCharacter(CharacterType.GOBLIN, 1, 2, 2, 2)));
				
				cards.add(createIngredient("Racines d'arc-en-ciel",
						createCharacter(CharacterType.GIANT, 2, 3, 2, 0),
						createCharacter(CharacterType.FERTILIZER, 0, 4, 3, 0),
						createCharacter(CharacterType.GOBLIN, 2, 1, 1, 3)));
				
				cards.add(createIngredient("Racines d'arc-en-ciel",
						createCharacter(CharacterType.GIANT, 2, 2, 3, 0),
						createCharacter(CharacterType.FERTILIZER, 1, 1, 1, 4),
						createCharacter(CharacterType.GOBLIN, 2, 0, 3, 2)));
				
				cards.add(createIngredient("Esprit de Dolmen",
						createCharacter(CharacterType.GIANT, 3, 1, 4, 1),
						createCharacter(CharacterType.FERTILIZER, 2, 1, 3, 3),
						createCharacter(CharacterType.GOBLIN, 2, 3, 2, 2)));
			
				cards.add(createIngredient("Esprit de Dolmen",
						createCharacter(CharacterType.GIANT, 2, 4, 1, 2),
						createCharacter(CharacterType.FERTILIZER, 2, 2, 2, 3),
						createCharacter(CharacterType.GOBLIN, 1, 4, 3, 1)));
				
				cards.add(createIngredient("Esprit de Dolmen",
						createCharacter(CharacterType.GIANT, 3, 3, 3, 0),
						createCharacter(CharacterType.FERTILIZER, 1, 3, 3, 2),
						createCharacter(CharacterType.GOBLIN, 2, 3, 1, 3)));
				
				cards.add(createIngredient("Rires de fées",
						createCharacter(CharacterType.GIANT, 1, 2, 2, 1),
						createCharacter(CharacterType.FERTILIZER, 1, 2, 3, 0),
						createCharacter(CharacterType.GOBLIN, 0, 2, 2, 2)));
				
				cards.add(createIngredient("Rires de fées",
						createCharacter(CharacterType.GIANT, 4, 0, 1, 1),
						createCharacter(CharacterType.FERTILIZER, 1, 1, 3, 1),
						createCharacter(CharacterType.GOBLIN, 0, 0, 3, 3)));
				
				cards.add(createIngredient("Rires de fées",
						createCharacter(CharacterType.GIANT, 2, 0, 1, 3),
						createCharacter(CharacterType.FERTILIZER, 0, 3, 0, 3),
						createCharacter(CharacterType.GOBLIN, 1, 2, 2, 1)));
				
				break;
			case SPECIAL_CARD:
				cards.add(new SpecialCard("Taupe géante", createSpecialCharacter(createCharacter(CharacterType.GIANT_MOLE, 1, 1, 1, 1))));
				cards.add(new SpecialCard("Taupe géante", createSpecialCharacter(createCharacter(CharacterType.GIANT_MOLE, 0, 2, 2, 0))));
				cards.add(new SpecialCard("Taupe géante", createSpecialCharacter(createCharacter(CharacterType.GIANT_MOLE, 0, 1, 2, 1))));
				cards.add(new SpecialCard("Chien de garde", createSpecialCharacter(createCharacter(CharacterType.WATCHDOG, 2, 0, 2, 0))));
				cards.add(new SpecialCard("Chien de garde", createSpecialCharacter(createCharacter(CharacterType.WATCHDOG, 1, 2, 0, 1))));
				cards.add(new SpecialCard("Chien de garde", createSpecialCharacter(createCharacter(CharacterType.WATCHDOG, 0, 1, 3, 0))));
				
				break;
			default:
				break;
			
		}
		return cards;
	}
	
	private Character createCharacter(CharacterType c, int spring, int summer, int autumn, int winter) {
		return new Character(c, spring, summer, autumn, winter);
	}
	
	private Ingredient createIngredient(String name, Character giant, Character fertilizer, Character goblin) {
		EnumMap<CharacterType, Character> characters = new EnumMap<CharacterType, Character>(CharacterType.class);
		characters.put(giant.getType(), giant);
		characters.put(fertilizer.getType(), fertilizer);
		characters.put(goblin.getType(), goblin);
		return new Ingredient(name, characters);
	}
	
	private EnumMap<CharacterType, Character> createSpecialCharacter(Character specialCharacter) {
		EnumMap<CharacterType, Character> character = new EnumMap<CharacterType, Character>(CharacterType.class);
		character.put(specialCharacter.getType(), specialCharacter);
		return character;
	}
}
