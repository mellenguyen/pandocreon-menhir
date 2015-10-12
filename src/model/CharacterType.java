package model;

public enum CharacterType {
	GIANT("Giant"),
	FERTILIZER("Fertilizer"),
	GOBLIN("Goblin"),
	GIANT_MOLE("Giant Mole"),
	WATCHDOG("Watchdog");
	
	private String name = "";
	
	CharacterType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
