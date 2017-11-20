import java.util.Scanner;
import java.util.logging.*;

public class SortingProcessor {
	private static final Logger LOGGER = Logger.getLogger(SortingProcessor.class.getName());
	private static final int TERMINATION = 4;
	private static int choice = -1;
	private Scanner scanner = new Scanner(System.in);
	private NumberGenerator generator;
	private Sorter sorter;
	
	public static void main(String[] args) {
		SortingProcessor processor = new SortingProcessor();
		processor.generator = new NumberGenerator();

		processor.printAuthorInfo();
		do {
			processor.printMenu();
			processor.operate();
		} while (choice != TERMINATION);
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

	private void operate() {
		try {
			choice = scanner.nextInt();
			operateChoice();
		} catch (Exception inputExeption) {
			LOGGER.log(Level.SEVERE, "inappropriate input", inputExeption);
			choice = TERMINATION;
		}
	}

	private void operateChoice() {
		final int INPUT = 1;
		final int ASCENDINGORDER = 2;
		final int DESCENDINGORDER = 3;

		switch (choice) {
		case INPUT:
			generator.getInputs();
			break;

		case ASCENDINGORDER:
			sortWith(new AscendingSorter());
			break;

		case DESCENDINGORDER:
			sortWith(new DescendingSorter());
			break;

		case TERMINATION:
			System.out.println("[Termination]");
			break;
		}
	}
	
	private void sortWith(Sorter input) {
		sorter = input;
		sorter.printResult(generator.getNumbers());
	}
	

}
