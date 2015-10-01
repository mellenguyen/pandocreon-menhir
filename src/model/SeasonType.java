package model;

public enum SeasonType {
	SPRING("Spring"),
	SUMMER("Summer"),
	AUTUMN("Autumn"),
	WINTER("Winter");
	
	private String name = "";
	
	SeasonType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	private static SeasonType[] seasons = values();
	
	public SeasonType next() {
		return seasons[(this.ordinal() + 1) % seasons.length];
	}
	
	public SeasonType previous() {
		if ((this.ordinal() - 1) < 0) {
			return seasons[seasons.length - 1];
		};
		return seasons[(this.ordinal() - 1)];
	}
}