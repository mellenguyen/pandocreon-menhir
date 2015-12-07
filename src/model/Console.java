package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Console {
	private static ArrayList<Player> players			= new ArrayList<Player>();
	private static ArrayList<Card>	 ingredientCards	= new ArrayList<Card>();
	private static ArrayList<Card>	 specialCards		= new ArrayList<Card>();
	private static CardFactory cardFactory 				= CardFactory.getInstance();
	private static PlayerFactory playerFactory 			= PlayerFactory.getInstance();
	private static PlantStrategy plantStrategy 			= PlantStrategy.getInstance();
	private static FightStrategy fightStrategy 			= FightStrategy.getInstance();
	private static TextUI textUI						= TextUI.getInstance();
	
	public static void main(String[] args) {
		int choice = textUI.readInt("Choose the type of game you want :\n" + GameFactory.GameType.allToString(), 1, 2);
		int nbBots = textUI.readInt("Choose the number of players (bots) you want in your game : ", 2, 6);
				
		// Create cards		
		ingredientCards.addAll(cardFactory.createCards(CardFactory.CardType.INGREDIENT));
		specialCards.addAll(cardFactory.createCards(CardFactory.CardType.SPECIAL_CARD));

		// Randomize age of players
		Random randomGenerator = new Random();
		
		for (int i = 1; i <= nbBots; i++) {
			if (i % 2 == 0) {
				players.add(playerFactory.createPlayer(PlayerFactory.PlayerType.BOT, "Bot "  + i, randomGenerator.nextInt(100 - 8) + 8, plantStrategy));
			} else {
				players.add(playerFactory.createPlayer(PlayerFactory.PlayerType.BOT, "Bot "  + i, randomGenerator.nextInt(100 - 8) + 8, fightStrategy));
			}
		}
		
		String name = textUI.readString("What is your name ? ");
		int age = textUI.readInt("How old are you ? ", 8, 100);
		
		Person player = new Person(name, age);
		players.add(player);
		
		GameFactory gameFactory = GameFactory.getInstance();
		Game game = null;
		
		switch(choice) {
			case 1:
				game = gameFactory.createGame(GameFactory.GameType.SIMPLE_GAME, players, ingredientCards, null);
				break;
			case 2:
				game = gameFactory.createGame(GameFactory.GameType.EXTENDED_GAME, players, ingredientCards, specialCards);
				break;
			default:
				// Choice filtered with the textUI function, it should not execute here
				break;	
		}
		
		game.start(textUI);
	}
}
