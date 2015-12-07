package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.GameFactory.GameType;

/**
 * A match is composed of 4 rounds (seasons)
 * @author mellenguyen
 *
 */
public class Match {
	private Game 			  		game;
	private ArrayList<Round>  		rounds = new ArrayList<Round>();
	private ArrayList<Player> 		players;
	private Player 			  		firstPlayer;
	private ArrayList<Card>	  		cards;
	private ArrayList<Card> 		specialCards;
	
	public Match(ArrayList<Player> players, Game game, ArrayList<Card> cards) {
		this.players = players;
		this.game = game;
		this.cards = cards;
		
		this.rounds.add(new Round(SeasonType.SPRING));
		this.rounds.add(new Round(SeasonType.SUMMER));
		this.rounds.add(new Round(SeasonType.AUTUMN));
		this.rounds.add(new Round(SeasonType.WINTER));
	}
	
	public Match(ArrayList<Player> players, Game game, ArrayList<Card> cards, ArrayList<Card> specialCards) {
		this(players, game, cards);
		this.specialCards = specialCards;
	}
	
	public void initializePlayers() {
		if (this.game.getGameType() == GameType.SIMPLE_GAME) {
			Iterator<Player> it = players.iterator();
			while (it.hasNext()) {
				it.next().addStones(2);
			}
		} else if (this.game.getGameType() == GameType.EXTENDED_GAME) {
			Player p;
			Collections.shuffle(this.specialCards);
			Iterator<Card> cardsIterator = this.specialCards.iterator();
			
			Iterator<Player> it = players.iterator();
			while (it.hasNext()) {
				p = it.next();
				if (p instanceof Bot) {
					if (((Bot) p).getStrategy().getStrategyType() == StrategyType.PLANT) {
						p.addStones(2);
					} else if (((Bot) p).getStrategy().getStrategyType() == StrategyType.FIGHT) {
						p.addSpecialCard(cardsIterator.next());
					}
				} else if (p instanceof Person) {
					TextUI textUI = TextUI.getInstance();
					int choice = textUI.readInt("Choose between 1/ having 2 stones and 2/ a special card :", 1, 2);
					if (choice == 1) {
						p.setStones(2);
					} else if (choice == 2) {
						p.addSpecialCard(cardsIterator.next());
					}
				}
			}
		}
	}
	
	/**
	 * Deal cards to players. Each player has 4 ingredient cards.
	 * @param players
	 * @param cards
	 * @return
	 */
	public void dealCards() {
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
	}
		
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public void execute(TextUI textUI) {
		this.initializePlayers();
		this.dealCards();
		for (Round round : this.rounds) {
			round.execute(textUI, this.firstPlayer, this.players);
		}
		String score = "";
		// Transfer temporary menhirs in 'menhirsMatch' to 'menhirs'
		for (Player p : this.players) {
			p.setMenhirs(p.getMenhirs() + p.getMenhirsMatch());
			p.setMenhirsMatch(0);
		}
		// Sort players to display by score
		Collections.sort(this.players);
		
		for (Player p : this.players) {
			score += p.finalScoreToString() + "\n";
		}
		textUI.showMessage(score);
		// Re-sort players to have initial order by ID (very important)
		Collections.sort(this.players, Player.Comparators.ID);
		
		// Reset stones
		for (Player p : this.players) {
			p.setStones(0);
		}
	}

}