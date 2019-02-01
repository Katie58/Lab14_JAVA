package lab14;

public class User extends Player{
	
	public Roshambo roshambo;
	
	public User(String name) {
		this.name = name;
	}
	
	public Roshambo generateRoshambo() {
		boolean valid = false;
		while(!valid) {
			System.out.print("Paper, Scissors, Rock? ");
			switch(RoshamboApp.input()) {
			case "paper": this.roshambo = Roshambo.PAPER; valid = true;
			break;
			case "scissors": this.roshambo = Roshambo.SCISSORS; valid = true;
			break;
			case "rock": this.roshambo = Roshambo.ROCK; valid = true;
			break;
			default: System.out.println("What game are you playing? Try Again...");
			break;
			}
		}
		return roshambo;
	}	
	
	@Override
	public String toString() {
		return this.name + roshambo;
	}
}
