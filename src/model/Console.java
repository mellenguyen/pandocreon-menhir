package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Console {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Card>	 cards = new ArrayList<Card>();

	public static void main(String[] args) {
		
		// Create cards
		CardFactory cardFactory = new CardFactory();
		cards.addAll(cardFactory.createCards(CardFactory.CardType.INGREDIENT));
		Iterator<Card> it = cards.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

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
