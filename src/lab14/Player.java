package lab14;

public abstract class Player {

	protected String name;
	public int[] record = {0,0,0};
	
	protected abstract Roshambo generateRoshambo();
}
