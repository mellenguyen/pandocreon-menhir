package model;
import java.util.EnumMap;

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
	
	/**
	 * This method allow us to change the values of all seasons in order to create the deck of cards, thus avoiding us to create
	 * a new character for every new card.
	 * @param spring value for Spring
	 * @param summer value for Summer
	 * @param autumn value for Autumn
	 * @param winter value for Winter
	 */
	public void changeSeasons(int spring, int summer, int autumn, int winter) {
		this.points.put(SeasonType.SPRING, spring);
		this.points.put(SeasonType.SUMMER, summer);
		this.points.put(SeasonType.AUTUMN, autumn);
		this.points.put(SeasonType.WINTER, winter);
	}
	
}