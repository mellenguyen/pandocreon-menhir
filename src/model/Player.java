package model;

public class Player {
	private String name;
	private int cailloux;
	/**
	 * Total score
	 */
	private int menhirs;
	
	/**
	 * Actual menhirs during a match. Can be destroyed; they are temporary menhirs
	 * not immediately added to the total of menhirs.
	 */
	private int menhirsMatch;
	
	public Player(String name) {
		this.name = name;
	}
 

}