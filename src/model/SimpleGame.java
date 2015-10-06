package model;import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple game is composed of only one match.
 * @author mellenguyen
 *
 */
public class SimpleGame extends Game {
	private Match 			match;
	private ArrayList<Card>	cards;

	public SimpleGame(ArrayList<Player> players, ArrayList<Card> cards) {
		super(players);
		this.initializePlayers();
		this.cards = cards;
		this.match = new Match(players, this, this.cards);
		this.match.setFirstPlayer(getYoungestPlayer());
	}
	
	public void initializePlayers() {
		Iterator<Player> it = players.iterator();
		while (it.hasNext()) {
			it.next().addCailloux(2);
		}
	}
	
	private Player getYoungestPlayer() {
		Iterator<Player> it = players.iterator();
		Player p = it.next();
		Player n;
		while (it.hasNext()) {
			n = it.next();
			if (n.getAge() < p.getAge()) {
				p = n;
			}
		}
		return p;
	}
	
	@Override
	public GameFactory.GameType getGameType() {
		return GameFactory.GameType.SIMPLE_GAME;
	}
	
	@Override
	public void start() {
		this.match.start();
	}
	
}
