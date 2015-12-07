package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * An extended game is composed of n matches, played by n players
 * @author mellenguyen
 *
 */
public class ExtendedGame extends Game {
	private ArrayList<Match> matches = new ArrayList<Match>();
	private ArrayList<Card> specialCards;
	
	public ExtendedGame(ArrayList<Player> players, ArrayList<Card> ingredientCards, ArrayList<Card> specialCards) {
		super(players, ingredientCards);
		this.specialCards = specialCards;
		for (int i = 1; i <= players.size(); i++) {
			matches.add(new Match(players, this, this.cards, this.specialCards));
		}
	}
	
	@Override
	public GameFactory.GameType getGameType() {
		return GameFactory.GameType.EXTENDED_GAME;
	}

	@Override
	public void start(TextUI textUI) {
		for (Match m : this.matches) {
			m.execute(textUI);
		}
		
	}
}