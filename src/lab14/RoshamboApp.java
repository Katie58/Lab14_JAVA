package lab14;
import java.util.Scanner;

public class RoshamboApp {
	static Scanner scnr = new Scanner(System.in);
	static User user = new User("name");
	static Rocky rocky = new Rocky("Rocky");
	static Roads roads = new Roads("Roads");
	static String result = "";

	public static void main(String[] args) {
		boolean retry = true;
		
		greeting();
		while(retry) {
			play(player(chooseOpponent()));
			records();
			retry = retry("play again");
		}
		exit();
		scnr.close();
	}
		
	public static int chooseOpponent() {
		System.out.println("1. Rocky");
		System.out.println("2. Roads");
		while(true) {
			System.out.print("Choose your opponent: ");
			String input = scnr.nextLine().trim();
			if (input.contentEquals("1")) {
				return 1;
			} else if (input.contentEquals("2")) {
				return 2;
			} else {
				System.out.println("Sorry, that player is currently unavailable try again...");
			}
		}		
	}
	
	public static Player player(int select) {
		switch(select) {
		case 1: return rocky;
		case 2: return roads;
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
		System.out.println("\n" + player + " " + user + " " + result); 
	}
	
	public static void paper(Player player) {
		switch(user.generateRoshambo()) {
		case PAPER: result = "YOU TIED";
		player.record[2]++; user.record[2]++;
		break;
		case SCISSORS: result = "YOU WON!!!";
		player.record[1]++; user.record[0]++;
		break;
		case ROCK: result = "YOU LOST :(";
		player.record[0]++; user.record[1]++;
		break;
		}
	}
	
	public static void scissors(Player player) {
		switch(user.generateRoshambo()) {
		case PAPER: result = "YOU LOST :(";
		player.record[0]++; user.record[1]++;
		break;
		case SCISSORS: result = "YOU TIED";
		player.record[2]++; user.record[2]++;
		break;
		case ROCK: result = "YOU WON!!!";
		player.record[1]++; user.record[0]++;
		break;
		}
	}
	
	public static void rock(Player player) {
		switch(user.generateRoshambo()) {
		case PAPER: result = "YOU WON!!!";
		player.record[1]++; user.record[0]++;
		break;
		case SCISSORS: result = "YOU LOST :(";
		player.record[0]++; user.record[1]++;
		break;
		case ROCK: result = "YOU TIED";
		player.record[2]++; user.record[2]++;
		break;
		}
	}
	
	public static void printRecord(Player player) {
		System.out.println(player.name + padding((user.name.length() - player.name.length()) + 5, '.') + player.record[0] + "-" + player.record[1] + "-" + player.record[2]);
	}

	public static void records() {
		System.out.println(padding(user.name.length() + 11, '='));
		System.out.println("|" + padding((user.name.length() + 2) / 2, ' ') + "RECORDS" + padding((user.name.length() + 2) / 2, ' ') + "|");
		System.out.println(padding(user.name.length() + 11, '='));
		printRecord(user);
		printRecord(rocky);
		printRecord(roads);
	}

	public static String padding(int multiple, char character) {
		String padding = "";
		for (int i = 1; i <= multiple; i++) {
			padding += character;
		}
		return padding;
	}
	
 	public static void greeting() {
		System.out.println("Welcome to Rock Paper Scissors!");
		System.out.print("Please enter your name: ");
		user.name = scnr.nextLine();
	}
	
 	public static boolean retry(String question) {
		System.out.print("\nWould you like to " + question + "? (y/n) ");
		return validateYesNo(scnr.nextLine().charAt(0));
	}
	
	public static boolean validateYesNo(char input) {
		while (input != 'y' && input != 'Y' && input != 'n' && input != 'N') {
			System.out.print("This is a simple yes or no question, try again...");
			input = scnr.nextLine().charAt(0);
		}
		return (input == 'y' || input == 'Y');
	}
	
	public static String input() {
		return scnr.nextLine().trim();
	}
	
	public static void exit() {
		System.out.println("Goodbye " + user.name + "!");
	}
}
