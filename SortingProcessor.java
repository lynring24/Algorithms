import java.util.Scanner;

public class SortingProcessor {
	private static final int TERMINATION = 4;
	private static int choice = -1;
	private NumberGenerator generator;
	
	public static void main(String[] args) {
		SortingProcessor processor = new SortingProcessor();
		processor.generator = new NumberGenerator();

		processor.printAuthorInfo();
		processor.execute();
	}

	private void printAuthorInfo() {
		System.out.println("[ ID: 1515386 ]");
		System.out.println("[ Name: Á¤Çý¸° ]");
	}

	private void execute() {
		do {
			printMenu();
			getInput();
			operate();
		} while (choice != TERMINATION);
	}
	
	private void printMenu() {
		System.out.println();
		System.out.println("1. Input numbers");
		System.out.println("2. Print numbers in increasing order");
		System.out.println("3. Print numbers in decreasing order");
		System.out.println("4. Quit");
		System.out.print("\n>");
	}

	private void getInput() {
		Scanner scanner = new Scanner(System.in);
		try {
			choice = scanner.nextInt();
		} catch (Exception e) {
			handleException();
		}
	}

	private void operate() {
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
	
	private void sortWith(Sorter selectedOne) {
		Sorter sorter = selectedOne;
		sorter.printResult(generator.getNumbers());
	}
	
	private void handleException() {
		System.out.println("Unappropriate inputs(Integers only)");
		choice = TERMINATION;
	}
}
