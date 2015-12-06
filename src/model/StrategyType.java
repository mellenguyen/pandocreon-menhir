package model;

public enum StrategyType {
	PLANT("Plant Strategy"),
	FIGHT("Fight Strategy");
	
	private String name = "";
	
	StrategyType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
