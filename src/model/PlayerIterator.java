package model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Chaque round/saison de jeu fait jouer tous les joueurs une seule fois
 * @author mellenguyen
 *
 */
public class PlayerIterator implements Iterator<Player> {
    private final ArrayList<Player> players;
    private int          			index;

    public PlayerIterator(ArrayList<Player> players) {
        this.players = players;
        index = 0;
    }

    @Override
    public Player next() {
        if(isLast()) {
            index = 0;
            return players.get(index);
        } else {
        	return players.get(index++);
        }
    }

    public boolean isLast() {
        return this.players.size() - 1 == index;
    }

    @Override
    public void remove() {
        if(index <= 0) {
            throw new IllegalStateException("You can't delete element before first next() method call");
        }
        players.remove(--index);
    }

	@Override
	/**
	 * There is no next player when all players have been iterated
	 */
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
}