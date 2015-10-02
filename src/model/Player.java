package model;

import java.util.ArrayList;

public abstract class Player {
	private String 			name;
	private static int 		nbPlayers = 0;
	private int 			id;
	private int 			age;
	private int 			cailloux;
	private ArrayList<Card> cards;
	
	/**
	 * Total score
	 */
	private int menhirs;

	/**
	 * Actual menhirs during a match. Can be destroyed; they are temporary menhirs
	 * not immediately added to the total of menhirs.
	 */
	private int menhirsMatch;
	
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
	
	public int getCailloux() {
		return cailloux;
	}

	public void setCailloux(int cailloux) {
		this.cailloux = cailloux;
	}

	public int getMenhirs() {
		return menhirs;
	}

	public void setMenhirs(int menhirs) {
		this.menhirs = menhirs;
	}

	public int getMenhirsMatch() {
		return menhirsMatch;
	}

	public void setMenhirsMatch(int menhirsMatch) {
		this.menhirsMatch = menhirsMatch;
	}
	
	public boolean addCard(Card card) {
		return this.cards.add(card);
	}
	
	public boolean removeCard(Card card) {
		return this.cards.remove(card);
	}
	
	public String toString() {
		return "Player n° " + this.id + ": " + this.name;
	}
	
	public abstract void play(); 
}