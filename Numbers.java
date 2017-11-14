import java.util.Scanner;

public class Numbers {
	private Scanner scanner = new Scanner(System.in);
	private int[] numbers;
	private int numberOfNumbers;

	public void getInputs() {
		try {
			setNumberOfNumbers();
			setNumbers();
		} catch (Exception e) {
			System.out.println("Unappropriate inputs");
		}
	}

	private void setNumberOfNumbers() {
		System.out.print("\n> The number of numbers:");
		numberOfNumbers = scanner.nextInt();
	}

	private void setNumbers() {
		numbers = new int[numberOfNumbers];
		System.out.print("> numbers:");

		for (int i = 0; i < numberOfNumbers; i++)
			numbers[i] = scanner.nextInt();
		System.out.println("Input Completed");

	}

	public void sortAscending() {
		AscendingSort sort = new AscendingSort(numbers);
		sort.sortNumbers(0, numbers.length - 1);
		sort.printSortedNumbers();
	}

	public void sortDescending() {
		DescendingSort sort = new DescendingSort(numbers);
		sort.sortNumbers(0, numbers.length - 1);
		sort.printSortedNumbers();
	}
}
