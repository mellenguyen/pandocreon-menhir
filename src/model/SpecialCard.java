package model;

import java.util.EnumMap;

/**
 * A special card is composed of only one character
 * @author Xuan-thi
 *
 */
public class SpecialCard extends Card {
	public SpecialCard(String name, EnumMap<CharacterType, Character> characters) {
		super(name, characters);
	}
}
