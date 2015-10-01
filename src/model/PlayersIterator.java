package model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Chaque round/saison de jeu fait jouer tous les joueurs une seule fois
 * @author mellenguyen
 *
 */
public class PlayersIterator implements Iterator<Player> {
    private final ArrayList<Player> players;
    private int          			index;
    private int 					counter;

    public PlayersIterator(ArrayList<Player> players) {
        this.players = players;
        index = 0;
        counter = 1;
    }

    @Override
    public Player next() {
    	if (hasNext()) {
    		this.counter += 1;
	        if(isLast()) {
	            index = 0;
	            return players.get(index);
	        } else {
	        	return players.get(index++);
	        }
    	}
    	throw new ArrayIndexOutOfBoundsException("All players have played in this turn !");
    }

    public boolean isLast() {
        return this.players.size() - 1 == index;
    }

	@Override
	/**
	 * There is no next player when all players have been iterated
	 */
	public boolean hasNext() {
		if (this.counter < this.players.size()) {
			return true;
		} else {
			return false;
		}
	}
}