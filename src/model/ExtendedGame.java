package model;

import java.util.ArrayList;

/**
 * An extended game is composed of n matches, played by n players
 * @author mellenguyen
 *
 */
public class ExtendedGame extends Game {

	public ExtendedGame(ArrayList<Player> players) {
		super(players);
	}
	
	@Override
	public GameFactory.GameType getGameType() {
		return GameFactory.GameType.EXTENDED_GAME;
	}

	@Override
	public void start(TextUI textUI) {
		// TODO Auto-generated method stub
		
	}

}
