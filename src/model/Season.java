package model;

public enum Season {
	SPRING("Spring"),
	SUMMER("Summer"),
	AUTUMN("Autumn"),
	WINTER("Winter");
	
	private String name = "";
	
	Season(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	private static Season[] seasons = values();
	
	public Season next() {
		return seasons[(this.ordinal() + 1) % seasons.length];
	}
	
	public Season previous() {
		if ((this.ordinal() - 1) < 0) {
			return seasons[seasons.length - 1];
		};
		return seasons[(this.ordinal() - 1)];
	}
}