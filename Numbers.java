import java.util.Scanner;

public class Numbers {
	private  Scanner scanner = new Scanner(System.in);
	private  int [] numbers;
	private  int numberOfNumbers;
	
	public void setSizeAndNumbers() {
		setSize();
		checkSizeSmallerThan20(); 
		setNumbers();
	}
	
	private void setSize(){
		System.out.print("\n> The number of numbers:");
		numberOfNumbers = scanner.nextInt();
	}
	
	private void checkSizeSmallerThan20() {
		if (numberOfNumbers > 20){
			System.out.println("Too much input! Max is 20.");
			numberOfNumbers = 20;
		}
	}
	
	private void setNumbers() {
		numbers = new int[numberOfNumbers+1];
		
		try {
			setInputToNumbers();
		}
		catch(Exception e) {
			System.out.println("Unappropriate inputs");
		}
	}
	
	private void setInputToNumbers(){
		System.out.print("> numbers:");
		
		for (int i = 0; i < numberOfNumbers; i++)
			numbers [i] = scanner.nextInt();
		System.out.println("Input Completed");
	}
	
	public int [] getNumbers(){
		return numbers;
	}
}
