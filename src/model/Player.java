package model;

public class Player {
	private String 		name;
	private static int 	nbPlayers = 0;
	private int 		id;
	private int 		age;
	private int 		cailloux;
	
	/**
	 * Total score
	 */
	private int menhirs;
	
	/**
	 * Actual menhirs during a match. Can be destroyed; they are temporary menhirs
	 * not immediately added to the total of menhirs.
	 */
	private int menhirsMatch;
	private GameStrategy strategy;
	
	public Player(String name, int age, GameStrategy strategy) {
		this.name = name;
		this.age = age;
		this.strategy = strategy;
		Player.nbPlayers += 1;
		this.id = Player.nbPlayers;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void play() {
		this.strategy.play();
	} 
}