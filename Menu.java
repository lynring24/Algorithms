import java.util.Scanner;

public class Menu {
	private static int choice = 4;
	private static Scanner scanner = new Scanner(System.in);
	private static int [] numbers;
	private static int numberOfNumbers;
	
	public static void main(String[] args) {
		System.out.println("[ ID: 1515386 ]");
		System.out.println("[ Name: Á¤Çı¸° ]");
		
		do {
			showBanners();
			choice = scanner.nextInt();
			operateChoice();
		} while(choice != 4);	
	}
	
	private static void showBanners() {
		System.out.println();
		System.out.println("1. Input numbers");
		System.out.println("2. Print numbers in increasing order");
		System.out.println("3. Print numbers in decreasing order");
		System.out.println("4. Quit");
		System.out.print("\n>");
	}
	
	private static void operateChoice() {
		switch (choice){
			case 1: 
				System.out.print("\n> The number of numbers:");
				numberOfNumbers = scanner.nextInt();
				checkSizeAndGetNumbers(); 
				break;
				
			case 2:
				new AscendingSort(numbers);
				break;
				
			case 3:
				new DescendingSort(numbers);
				break;
				
			case 4:
				System.out.println("[Termination]");
				break;
			
		}
	}
	
	private static void checkSizeAndGetNumbers() {
		if (numberOfNumbers > 21)
			System.out.println("Too much input");
		else 
			 getNumbers();
	}
	
	private static void getNumbers() {
		System.out.print("> numbers:");
		numbers = new int[numberOfNumbers];
		for (int i = 0; i < numberOfNumbers; i++)
			numbers [i] = scanner.nextInt();
		System.out.println("Input Completed");
	}
}
