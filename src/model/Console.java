package model;

import java.util.ArrayList;

public class Console {
	private static ArrayList<Player> players;

	public static void main(String[] args) {
		
		PlantStrategy plantStrategy = new PlantStrategy();
		PlayerFactory playerFactory = new PlayerFactory();
		players.add(playerFactory.createPlayer(PlayerFactory.PlayerType.BOT, "Bot 1", 23, plantStrategy));
		players.add(playerFactory.createPlayer(PlayerFactory.PlayerType.BOT, "Bot 2", 25, plantStrategy));
		
		GameFactory gameFactory = new GameFactory();
		Game simpleGame = gameFactory.createGame(GameFactory.GameType.SIMPLE_GAME, players);
	}

}
