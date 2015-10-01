package model;
import java.util.EnumMap;

public class Character {
	protected CharacterType name;
	
	/**
	 * There are exactly 4 seasons, so this EnumMap must be of size = 4
	 */
	protected EnumMap<SeasonType, Integer> points = new EnumMap<SeasonType, Integer>(SeasonType.class);
	
	public Character(CharacterType name) {
		this.name = name;
	}
	
	public Integer addSeason(SeasonType season, int value) {
		return this.points.put(season, value);
	}
	
}