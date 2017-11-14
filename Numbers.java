import java.util.Scanner;

public class Numbers {
	private  Scanner scanner = new Scanner(System.in);
	private  int [] numbers;
	private  int numberOfNumbers;

	public void getInputs() {
		System.out.print("\n> The number of numbers:");
		numberOfNumbers = scanner.nextInt();
		setNumbers();
	}
	
	private void setNumbers() {
		numbers = new int[numberOfNumbers];
		
		try {
			System.out.print("> numbers:");
			for (int i = 0; i < numberOfNumbers; i++)
				numbers [i] = scanner.nextInt();
			System.out.println("Input Completed");
		}
		catch(Exception e) {
			System.out.println("Unappropriate inputs");
		}
	}
	
	public void sortAscending() {
		AscendingSort sort = new AscendingSort(numbers);
		sort.sortNumbers(0, numbers.length-1);
		sort.printSortedNumbers();	
	}
	
	public void sortDescending() {
		DescendingSort sort = new DescendingSort(numbers);
		sort.sortNumbers(0, numbers.length-1);
		sort.printSortedNumbers();	
	}
}
