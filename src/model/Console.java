package model;

import java.util.ArrayList;

public class Console {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Card>	 cards = new ArrayList<Card>();

	public static void main(String[] args) {
		
		// Create cards
		CardFactory cardFactory = new CardFactory();
		ArrayList<Integer> values = new ArrayList<Integer>;
		
		values.add(4);
		values.add(3);
		values.add(5);
		values.add(2);
		cards.add(cardFactory.createCard(CardFactory.CardType.INGREDIENT));
		
		// Create players
		PlantStrategy plantStrategy = new PlantStrategy();
		PlayerFactory playerFactory = new PlayerFactory();
		players.add(playerFactory.createPlayer(PlayerFactory.PlayerType.BOT, "Bot 1", 23, plantStrategy));
		players.add(playerFactory.createPlayer(PlayerFactory.PlayerType.BOT, "Bot 2", 25, plantStrategy));
		players.add(playerFactory.createPlayer(PlayerFactory.PlayerType.BOT, "Bot 3", 19, plantStrategy));
		
		GameFactory gameFactory = new GameFactory();
		Game simpleGame = gameFactory.createGame(GameFactory.GameType.SIMPLE_GAME, players);
		
		simpleGame.start();
	}

}
