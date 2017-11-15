import java.util.Scanner;
import java.util.logging.*;

public class Main {
	private static int choice = -1;
	private final static int TERMINATE = 4;
	private Scanner scanner = new Scanner(System.in);
	private NumberGenerator generator;
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		Main main = new Main();
		main.generator = new NumberGenerator();

		main.printAuthorInfo();
		do {
			main.printMenu();
			main.getInputAndOperate();
		} while (choice != TERMINATE);
	}

	private void printAuthorInfo() {
		System.out.println("[ ID: 1515386 ]");
		System.out.println("[ Name: Á¤Çý¸° ]");
	}

	private void printMenu() {
		System.out.println();
		System.out.println("1. Input numbers");
		System.out.println("2. Print numbers in increasing order");
		System.out.println("3. Print numbers in decreasing order");
		System.out.println("4. Quit");
		System.out.print("\n>");
	}

	private void getInputAndOperate() {
		try {
			choice = scanner.nextInt();
			operateChoice();
		} catch (Exception inputExeption) {
			LOGGER.log(Level.SEVERE, "inappropriate input", inputExeption);
			choice = TERMINATE; 
		}
	}
	
	private void operateChoice() throws Exception {
		switch (choice) {
		case 1:
			generator.getInputs();
			break;

		case 2:
			AscendingSorter ascendingSorter = new AscendingSorter(generator.getNumbers());
			ascendingSorter.sort();
			ascendingSorter.printSortedNumbers();
			break;

		case 3:
			DescendingSorter descendingSorter = new DescendingSorter(generator.getNumbers());
			descendingSorter.sort();
			descendingSorter.printSortedNumbers();
			break;

		case TERMINATE:
			System.out.println("[Termination]");
			break;
		}
	}

}
