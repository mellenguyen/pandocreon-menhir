package model;

public class Bot extends Player {
	private GameStrategy strategy;
	
	public Bot(String name, int age, GameStrategy strategy) {
		super(name, age);
		this.strategy = strategy;
	}

	@Override
	public void play() {
		this.strategy.play();
		
	}
}
