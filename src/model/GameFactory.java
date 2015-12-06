package model;

import java.util.ArrayList;

/**
 * This factory create a game according to the user input. A game can be simple or with advanced rules.
 * @author mellenguyen
 *
 */
public class GameFactory {
	private static GameFactory INSTANCE = new GameFactory();
	
	public static enum GameType {
		SIMPLE_GAME("Simple Game"),
		EXTENDED_GAME("Extended Game");
		
		private String name = "";
		
		GameType(String name) {
			this.name = name;
		}
		
		public String toString() {
			return name;
		}
		
		public static String allToString() {
			String s = "";
			for (GameFactory.GameType gt : GameFactory.GameType.values()) {
				s += gt.name + "\n";
			}
			return s;
		}
	}
	
	private GameFactory() {}
	
	public static GameFactory getInstance() {
		return INSTANCE;
	}
	
	public Game createGame(GameType g, ArrayList<Player> players, ArrayList<Card> ingredientCards, ArrayList<Card> specialCards) {
		Game game = null;
		
		switch (g) {
			case SIMPLE_GAME:
				game = new SimpleGame(players, ingredientCards);
				break;
			case EXTENDED_GAME:
				game = new ExtendedGame(players, ingredientCards, specialCards);
				break;
			default:
				throw new IllegalArgumentException("Unknown type of game");
		}
		return game;
	}
}
