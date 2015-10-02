package model;

public class CharacterFactory {
	public static enum CharacterType {
		GIANT,
		FERTILIZER,
		GOBLIN,
		GIANT_MOLE,
		WATCHDOG;
	}
	
	public CharacterFactory() {}
	
	public Character createCharacter(CharacterType characterType) {
		Character c = null;
		
		switch (characterType) {
		case GIANT:
			c = new Character(characterType)
		}
	}
	
}
