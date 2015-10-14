package model;

import java.util.EnumMap;

/**
 * An Ingredient has 3 specific characters
 * @author mellenguyen
 *
 */
public class Ingredient extends Card {
	public Ingredient(String name, EnumMap<CharacterType, Character> characters) {
		super(name, characters);
	}
}