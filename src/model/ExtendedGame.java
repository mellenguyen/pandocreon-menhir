package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An extended game is composed of n matches, played by n players
 * @author mellenguyen
 *
 */
public class ExtendedGame extends Game {
	private ArrayList<Match> matches;

	public ExtendedGame(ArrayList<Player> players) {
		super(players);
	}
	
	@Override
	public GameFactory.GameType getGameType() {
		return GameFactory.GameType.EXTENDED_GAME;
	}

	@Override
	public void initializePlayers() {
		Player p;
		
		Iterator<Player> it = players.iterator();
		while (it.hasNext()) {
			p = it.next();
			if (p instanceof Bot) {
				if (((Bot) p).getStrategy().getStrategyType() == StrategyType.PLANT) {
					p.addStones(2);
				} else if (((Bot) p).getStrategy().getStrategyType() == StrategyType.FIGHT) {
					p.addSpecialCard();
				}
			}
		}
		
	}

	@Override
	public void start(TextUI textUI) {
		// TODO Auto-generated method stub
		
	}
}