import java.util.Scanner;

public class NumberGenerator {
	private Scanner scanner;
	private int[] numbers;
	private int numberOfNumbers;

	public void getInputs() {
		scanner = new Scanner(System.in);
		try {
			setNumberOfNumbers();
			setNumbers();
		}  catch (Exception e) {
			System.out.println("Unappropriate inputs(Integers only)");
			scanner.nextLine();
		}
	}

	private void setNumberOfNumbers() {
		System.out.print("\n> The number of numbers:");
		numberOfNumbers = scanner.nextInt();
	}

	private void setNumbers() throws Exception{
		numbers = new int[numberOfNumbers];
		System.out.print("> numbers:");

		for (int i = 0; i < numberOfNumbers; i++)
			numbers[i] = scanner.nextInt();
		
		scanner.nextLine();
	}

	public int[] getNumbers() {
		return numbers;
	}
}
