package model;

import java.util.ArrayList;

public abstract class Player {
	private String 			  name;
	private static int 		  nbPlayers = 0;
	private int 			  id;
	private int 			  age;
	private int 			  stones = 0;
	protected ArrayList<Card> cards = new ArrayList<Card>();
	
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
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
		return menhirs;
	}

	public void setMenhirs(int menhirs) {
		this.menhirs = menhirs;
	}
	
	public void addMenhirs(int menhirs) {
		this.menhirs += menhirs;
	}

	public int getMenhirsMatch() {
		return menhirsMatch;
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
	
	public ArrayList<Card> getCards() {
		return this.cards;
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
	
	public abstract ArrayList<Player> play(TextUI textUI, SeasonType seasonType, ArrayList<Player> players);
}