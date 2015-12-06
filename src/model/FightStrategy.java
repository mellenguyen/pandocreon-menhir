package model;

import java.util.ArrayList;

public class FightStrategy implements GameStrategy {
	private static FightStrategy INSTANCE = new FightStrategy();
	
	private FightStrategy() {}
	
	public static FightStrategy getInstance() {
		return INSTANCE;
	}
	
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.FIGHT;
	}

	@Override
	public void play(TextUI textUI, SeasonType seasonType, Player p, ArrayList<Player> players){
		
	}
	

}
