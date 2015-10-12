package model;

import java.util.ArrayList;

public abstract class Card {
	private ArrayList<Character> characters;
	private String name;
	
	public Card(String name, ArrayList<Character> characters) {
		this.name = name;
		this.characters = characters;
	}
	
	public boolean addCharacter(Character character) {
		return this.characters.add(character);
	}
	
	@Override
	public String toString() {
		String s = this.name + "\n            ";
		for (SeasonType season : SeasonType.values()) {
			s += season.toString() + " ";
		}
		s += "\n";
		
		for (Character c : this.characters) {
			s += c.toString() + "\n";
		}
		return s;
	}

}