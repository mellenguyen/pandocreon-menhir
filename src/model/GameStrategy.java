package model;

import java.util.ArrayList;

public interface GameStrategy {
	
	public void play(TextUI textUI, SeasonType seasonType, Player p, ArrayList<Player> players);
	
	public StrategyType getStrategyType();
}