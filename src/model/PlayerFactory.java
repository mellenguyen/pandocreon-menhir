package model;

public class PlayerFactory {
	private static PlayerFactory INSTANCE = new PlayerFactory();
	
	public static enum PlayerType {
		PERSON,
		BOT;
	}
	
	private PlayerFactory() {}
	
	public static PlayerFactory getInstance() {
		return INSTANCE;
	}
 	
	public Player createPlayer(PlayerType playerType, String name, int age, GameStrategy strategy) {
		Player player = null;
		
		switch(playerType) {
			case PERSON:
				player = new Person(name, age);
				break;
			case BOT:
				player = new Bot(name, age, strategy);
				break;
			default:
				throw new IllegalArgumentException("Unknown type of game");				
		}
		return player;
	}

}
