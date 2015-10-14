package model;

import java.util.ArrayList;

/**
 * This factory create a game according to the user input. A game can be simple or with advanced rules.
 * @author mellenguyen
 *
 */
public class GameFactory {
	
	public static enum GameType {
		SIMPLE_GAME,
		EXTENDED_GAME;
	}
	
	public GameFactory() {}
	
	public Game createGame(GameType g, ArrayList<Player> players, ArrayList<Card> cards) {
		Game game = null;
		
		switch (g) {
			case SIMPLE_GAME:
				game = new SimpleGame(players, cards);
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
