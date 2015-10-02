package model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Every round/Season of a match is played by each player once
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
        counter = 0;
    }
    
    public Integer getCounter() {
    	return this.counter;
    }

    @Override
    public Player next() {
    	if (hasNext()) {
    		this.counter += 1;
	        if(isLast()) {
	            index = 0;
	        }
	        return players.get(index++);
    	}
    	throw new ArrayIndexOutOfBoundsException("All players have played in this round !");
    }

    public boolean isLast() {
        return this.players.size() - 1 < index;
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