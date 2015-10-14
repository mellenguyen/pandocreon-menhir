package model;

import java.util.ArrayList;

public interface GameStrategy {
	
	public ArrayList<Player> play(SeasonType seasonType, Player p, ArrayList<Player> players);
}