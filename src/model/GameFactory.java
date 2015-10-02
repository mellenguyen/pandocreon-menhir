package model;

import java.util.ArrayList;

public class GameFactory {
	
	public static enum GameType {
		SIMPLE_GAME,
		EXTENDED_GAME;
	}
	
	public GameFactory() {
		
	}
	
	public Game createGame(GameType g, ArrayList<Player> players) {
		Game game = null;
		
		switch (g) {
			case SIMPLE_GAME:
				game = new SimpleGame(players);
				break;
			case EXTENDED_GAME:
				game = new ExtendedGame(players);
				break;
			default:
				throw new IllegalArgumentException("Unknown type of game");
		}
		return game;
	}
}
