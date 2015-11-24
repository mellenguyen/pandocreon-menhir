package model;

import java.util.ArrayList;

public interface GameStrategy {
	
	public ArrayList<Player> play(TextUI textUI, SeasonType seasonType, Player p, ArrayList<Player> players);
}