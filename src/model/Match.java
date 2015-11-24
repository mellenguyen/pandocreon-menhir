package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * A match is composed of 4 rounds (seasons)
 * @author mellenguyen
 *
 */
public class Match {
	private Game 			  game;
	private ArrayList<Round>  rounds = new ArrayList<Round>();
	private ArrayList<Player> players;
	private Player 			  firstPlayer;
	private ArrayList<Card>	  cards;
	
	public Match(ArrayList<Player> players, Game game, ArrayList<Card> cards) {
		this.players = players;
		this.game = game;
		this.cards = cards;
		
		this.rounds.add(new Round(SeasonType.SPRING));
		this.rounds.add(new Round(SeasonType.SUMMER));
		this.rounds.add(new Round(SeasonType.AUTUMN));
		this.rounds.add(new Round(SeasonType.WINTER));
	}
	
	/**
	 * Deal cards to players. Each player has 4 ingredient cards.
	 * @param players
	 * @param cards
	 * @return
	 */
	public ArrayList<Player> dealCards() {
		Iterator<Player> playersIterator = this.players.iterator();
		Collections.shuffle(this.cards);
		Iterator<Card> cardsIterator = this.cards.iterator();
		Player p;
		
		while (playersIterator.hasNext()) {
			p = playersIterator.next();
			for (int i = 0; i < 4; i++) {
				if (cardsIterator.hasNext()) {
					p.addCard(cardsIterator.next());
				} else {
					// Exception : pas assez de cartes
				}
			}
		}
		return players;
	}
		
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public void execute(TextUI textUI) {
		this.dealCards();
		for (Round round : this.rounds) {
			round.execute(textUI, this.firstPlayer, this.players);
		}
	}

}