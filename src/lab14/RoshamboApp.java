package lab14;
import java.util.Scanner;

public class RoshamboApp {
	static Scanner scnr = new Scanner(System.in);
	static String name = "";
	static User user = new User();

	public static void main(String[] args) {
		boolean retry = true;
		
		greeting();
		while(retry) {///////////////////////////need to print results
			play(player(chooseOpponent()));
			retry = retry("play again");
		}
		exit();
		scnr.close();
	}
		
	public static int chooseOpponent() {
		System.out.println("1. Rocky");
		System.out.println("2. Roads");
		while(true) {
			System.out.println("Choose your opponent: ");
			char input = scnr.nextLine().charAt(0);
			if (input == '1') {
				return 1;
			} else if (input == '2') {
				return 2;
			} else {
				System.out.println("Sorry, that player is currently unavailable try again...");
			}
		}		
	}
	
	public static Player player(int select) {
		switch(select) {
		case 1: return new Rocky("Rocky");
		case 2: return new Roads("Roads");
		default: return null;
		}
	}
	
	public static void play(Player player) {
		switch(player.generateRoshambo()) {
		case PAPER: paper(player);
		break;
		case SCISSORS: scissors(player);
		break;
		case ROCK: rock(player);
		break;
		}
	}
	
	public static void paper(Player player) {
		switch(user.generateRoshambo()) {
		case PAPER: System.out.println("YOU TIED");
		player.record[2]++; user.record[2]++;
		break;
		case SCISSORS: System.out.println("YOU WON!!!");
		player.record[1]++; user.record[0]++;
		break;
		case ROCK: System.out.println("YOU LOST :(");
		player.record[0]++; user.record[1]++;
		break;
		}
	}
	
	public static void scissors(Player player) {
		switch(user.generateRoshambo()) {
		case PAPER: System.out.println("YOU WON!!!");
		player.record[0]++; user.record[1]++;
		break;
		case SCISSORS: System.out.println("YOU TIED");
		player.record[2]++; user.record[2]++;
		break;
		case ROCK: System.out.println("YOU LOST :(");
		player.record[0]++; user.record[1]++;
		break;
		}
	}
	
	public static void rock(Player player) {
		switch(user.generateRoshambo()) {
		case PAPER: System.out.println("YOU LOST :(");
		player.record[0]++; user.record[1]++;
		break;
		case SCISSORS: System.out.println("YOU WON!!!");
		player.record[1]++; user.record[0]++;
		break;
		case ROCK: System.out.println("YOU TIED");
		player.record[2]++; user.record[2]++;
		break;
		}
	}
	
 	public static void greeting() {
		System.out.println("Welcome to Rock Paper Scissors!");
		System.out.print("Please enter your name: ");
		name = scnr.nextLine();
	}
	
 	public static boolean retry(String question) {
		System.out.print("\n" + name + ", would you like to " + question + "? (y/n) ");
		return validateYesNo(scnr.nextLine().charAt(0));
	}
	
	public static boolean validateYesNo(char input) {//validate yes/no user input
		while (input != 'y' && input != 'Y' && input != 'n' && input != 'N') {
			System.out.print("This is a simple yes or no question, try again...");
			input = scnr.nextLine().charAt(0);
		}
		return (input == 'y' || input == 'Y');
	}
	
	public static void exit() {
		System.out.println("Goodbye " + name + "!");
	}
}
