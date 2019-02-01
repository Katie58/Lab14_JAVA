package lab14;
import java.util.Scanner;

public class User extends Player{
	
	private Roshambo roshambo;
	
	public Roshambo generateRoshambo() {
		boolean valid = false;
		Scanner scnr = new Scanner(System.in);
		while(!valid) {
			System.out.print("Paper, Scissors, Rock? ");
			switch(scnr.nextLine().trim().toLowerCase()) {
			case "paper": this.roshambo = Roshambo.PAPER; valid = true;
			case "scissors": this.roshambo = Roshambo.SCISSORS; valid = true;
			case "rock": this.roshambo = Roshambo.ROCK; valid = true;
			default: System.out.println("What game are you playing? Try Again...");
			}
		}
		scnr.close();
		return roshambo;
	}	
}
