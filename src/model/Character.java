package model;
import java.util.EnumMap;
import java.util.Map.Entry;

public class Character {
	protected CharacterType name;
	
	/**
	 * There are exactly 4 seasons, so this EnumMap must be of size = 4
	 */
	protected EnumMap<SeasonType, Integer> points = new EnumMap<SeasonType, Integer>(SeasonType.class);
	
	/**
	 * 
	 * @param name name of the card
	 */
	public Character(CharacterType name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param name	 name of the card
	 * @param spring value for Spring
	 * @param summer value for Summer
	 * @param autumn value for Autumn
	 * @param winter value for Winter
	 */
	public Character(CharacterType name, int spring, int summer, int autumn, int winter) {
		this.name = name;
		this.points.put(SeasonType.SPRING, spring);
		this.points.put(SeasonType.SUMMER, summer);
		this.points.put(SeasonType.AUTUMN, autumn);
		this.points.put(SeasonType.WINTER, winter);
	}
	
	public Integer addSeason(SeasonType season, int value) {
		return this.points.put(season, value);
	}
	
	public CharacterType getType() {
		return this.name;
	}
	
	public Integer getValue(SeasonType seasonType) {
		return this.points.get(seasonType);
	}
	
	@Override
	public String toString() {
		String s = this.name.toString();
		
		switch (this.name) {
			case GIANT:
				s += "            ";
				break;
			case FERTILIZER:
				s += "       ";
				break;
			case GOBLIN:
				s += "           ";
				break;
			case GIANT_MOLE:
				s += "       ";
				break;
			case WATCHDOG:
				s += "         ";
			default:
			
		}
		
		for (Entry<SeasonType, Integer> entry : this.points.entrySet())	{
			s += entry.getValue() + "     ";
		}
		return s;
	}
	
}