package lab14;

public class Rocky extends Player{

	private Roshambo roshambo;
	
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
	
}
