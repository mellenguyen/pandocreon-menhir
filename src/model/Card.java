package model;

import java.util.ArrayList;

public abstract class Card {
	private ArrayList<Character> characters;
	private String name;
	
	public Card(String name) {
		this.name = name;
	}
	
	public Card(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
	public boolean addCharacter(Character character) {
		return this.characters.add(character);
	}

}