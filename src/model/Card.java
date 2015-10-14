package model;

import java.util.EnumMap;
import java.util.Map.Entry;

public abstract class Card {
	protected EnumMap<CharacterType, Character> characters = new EnumMap<CharacterType, Character>(CharacterType.class);
	private String name;
	
	public Card(String name, EnumMap<CharacterType, Character> characters) {
		this.name = name;
		this.characters = characters;
	}
	
	public Character addCharacter(CharacterType characterType,Character character) {
		return this.characters.put(characterType, character);
	}
	
	public Character getCharacter(CharacterType c) {
		return this.characters.get(c);
	}
	
	public EnumMap<CharacterType, Character> getCharacters() {
		return this.characters;
	}
	
	@Override
	public String toString() {
		String s = this.name + "\n            ";
		for (SeasonType season : SeasonType.values()) {
			s += season.toString() + " ";
		}
		s += "\n";
		
		for (Entry<CharacterType, Character> entry : this.characters.entrySet())	{
			s += entry.getValue().toString() + "\n";
		}
		return s;
	}

}