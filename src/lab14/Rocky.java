package lab14;

public class Rocky extends Player{

	public Roshambo roshambo;
	
	public Rocky() {
	}
	
	public Rocky(String name) {
		this.name = name;
	}

	@Override
	protected Roshambo generateRoshambo() {
		this.roshambo = Roshambo.ROCK;
		return roshambo;
	}
	
	@Override
	public String toString() {
		return this.name + roshambo;
	}
	
}
