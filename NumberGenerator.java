import java.util.Scanner;

public class NumberGenerator {
	private Scanner scanner = new Scanner(System.in);
	private int[] numbers;
	private int numberOfNumbers;

	public void getInputs() {
		try {
			setNumberOfNumbers();
			setNumbers();
		} catch (Exception e) {
			System.out.println("Unappropriate inputs");
			scanner.nextLine();
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

	public int [] getNumbers() {
		return numbers;
	}
}
