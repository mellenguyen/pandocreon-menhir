package model;

import java.util.ArrayList;

public abstract class Card {
	private ArrayList<Character> characters;
	
	public Card() {
	}
	
	public Card(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
	public boolean addCharacter(Character character) {
		return this.characters.add(character);
	}

}