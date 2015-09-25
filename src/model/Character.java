package model;
import java.util.EnumMap;

public class Character {
	protected CharacterType name;
	protected EnumMap<Season, Integer> points = new EnumMap<Season, Integer>(Season.class);
	
}