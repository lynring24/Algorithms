import java.util.Scanner;

public class Algorithms {
	public static int ROW;
	public static OriginalNumbers numbers;
	public static void main(String[] args) {
		
		System.out.print("Numbers in a set : ");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		
		numbers = new OriginalNumbers(size);
		ROW=OriginalNumbers.ROW;
		
		countExchangeSort();
		countMergeSort();
		countQuickSort();
	}
	public static void countExchangeSort(){
		int count=0;
		for(int i=0;i<ROW;i++)
		   count+= new ExchangeSort(numbers.getClone(i)).count;
		System.out.println("\nExchangeSort Average # Comparsion : "+(int)(count/ROW));
	}
	public static void countMergeSort(){
		int count=0;
		for(int i=0;i<ROW;i++)
			   count+=new MergeSort(numbers.getClone(i)).count;
			System.out.println("MergeSort Average # Comparsion : "+(int)(count/ROW));	
	}
	public static void countQuickSort(){
		int count=0;
		for(int i=0;i<ROW;i++)
			count+=new QuickSort(numbers.getClone(i)).count;
		System.out.println("QuickSort Average # Comparsion : "+(int)(count/ROW));	
	}
	
}