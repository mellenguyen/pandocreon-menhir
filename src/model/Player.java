package model;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Player implements Comparable<Player> {
	private String 			  name;
	private static int 		  nbPlayers = 0;
	private int 			  id;
	private int 			  age;
	private int 			  stones = 0;
	protected ArrayList<Card> cards = new ArrayList<Card>();
	protected Card specialCard;
	
	/**
	 * Total score
	 */
	private int menhirs = 0;

	/**
	 * Actual menhirs during a match. Can be destroyed; they are temporary menhirs
	 * not immediately added to the total of menhirs.
	 */
	private int menhirsMatch = 0;
	
	public Player(String name, int age) {
		this.name = name;
		this.age = age;
		Player.nbPlayers += 1;
		this.id = Player.nbPlayers;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getStones() {
		return this.stones;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}
	
	public void addStones(int stones) {
		this.stones += stones;
	}
	
	public void removeStones(int stones) {
		this.stones -= stones;
	}

	public int getMenhirs() {
		return this.menhirs;
	}

	public void setMenhirs(int menhirs) {
		this.menhirs = menhirs;
	}
	
	public void addMenhirs(int menhirs) {
		this.menhirs += menhirs;
	}

	public int getMenhirsMatch() {
		return this.menhirsMatch;
	}

	public void setMenhirsMatch(int menhirsMatch) {
		this.menhirsMatch = menhirsMatch;
	}

	public void addMenhirsMatch(int menhirsMatch) {
		this.menhirsMatch += menhirsMatch;
	}
	
	public boolean addCard(Card card) {
		return this.cards.add(card);
	}
	
	public boolean removeCard(Card card) {
		int index = cards.indexOf(card) + 1;
		System.out.println("Player n°" + id + " is playing Card n°" + index);
		return this.cards.remove(card);
	}
	
	public void addSpecialCard(Card card) {
		this.specialCard = card;
	}
	
	public void removeSpecialCard() {
		System.out.println("Player n°" + id + " is playing its Special Card !");
		System.out.println(this.specialCard.toString());
		this.specialCard = null;
	}	
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public Card getSpecialCard() {
		return this.specialCard;
	}
	
	public String toString() {
		return "Player n° " + this.id + ": " + this.name;
	}
	
	/**
	 * Display the actual score of a player, for a match
	 * @return String Concatenation of numbers of stones and menhirs
	 */
	public String scoreToString() {
		return this.toString() + " has " + this.stones + " stone(s) and " + this.menhirsMatch + " menhir(s) planted";
	}
	
	/**
	 * Display the score of a player aka the number of menhirs
	 * @return
	 */
	public String finalScoreToString() {
		return this.toString() + " has " + this.menhirs + " menhirs.";
	}
	
	public abstract void play(TextUI textUI, SeasonType seasonType, ArrayList<Player> players);
	
	// compareTo should return < 0 if this is supposed to be
    // less than p, > 0 if this is supposed to be greater than 
    // p and 0 if they are supposed to be equal
	@Override
	public int compareTo(Player p) {
		return ((Player) p).getMenhirs() - this.getMenhirs();
	}
	
	public static class Comparators {

        public static Comparator<Player> ID = new Comparator<Player>() {
			@Override
			public int compare(Player p0, Player p1) {
				return p0.getId() - p1.getId();
			}
        };
    }
}