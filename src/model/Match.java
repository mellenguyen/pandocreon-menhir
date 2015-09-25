package model;

/**
 * A match is composed by 4 rounds (seasons)
 * @author Suntea
 *
 */
public class Match {
	/**
	 * Actual season of the match
	 */
	private Season season;
	
	public Match() {
		this.season = Season.SPRING;
	}

}