package model;

import java.util.ArrayList;

/**
 * A match is composed of 4 rounds (seasons)
 * @author Suntea
 *
 */
public class Match {
	private ArrayList<Round> rounds = new ArrayList<Round>();
	
	public void start() {
		this.rounds.add(new Round(Season.SPRING));
		
		this.rounds.get(rounds.size() - 1).execute();
	}

}