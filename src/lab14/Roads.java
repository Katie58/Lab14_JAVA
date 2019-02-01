package lab14;

import java.util.Random;

public class Roads extends Player{

	public Roshambo roshambo;
	
	public Roads () {
		this.roshambo = generateRoshambo();
	}
	
	public Roads(String name) {
		this.name = name;
		this.roshambo = generateRoshambo();
	}
	
	@Override
	protected Roshambo generateRoshambo() {
		Random r = new Random();
		int index = r.nextInt(3) + 1;
		switch(index) {
		case 1: this.roshambo = Roshambo.ROCK;
		break;
		case 2: this.roshambo = Roshambo.PAPER;
		break;
		case 3: this.roshambo = Roshambo.SCISSORS;
		break;
		}
		return roshambo;
	}	
	
	@Override
	public String toString() {
		return this.name + roshambo;
	}
}
