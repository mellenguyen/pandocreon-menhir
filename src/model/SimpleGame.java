package model;import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple game is composed of only one match.
 * @author mellenguyen
 *
 */
public class SimpleGame extends Game {
	private Match match;

	public SimpleGame(ArrayList<Player> players) {
		super(players);
		this.match = new Match(players);
		this.match.setFirstPlayer(getYoungestPlayer());
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
	public void start() {
		this.match.start();
	}
	
}
