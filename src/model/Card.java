package model;

import java.util.List;

public abstract class Card {
	private List<Character> characters;
	
	public Card() {
	}
	
	public Card(List<Character> characters) {
		this.characters = characters;
	}
	
	public boolean addCharacter(Character character) {
		return this.characters.add(character);
	}

}