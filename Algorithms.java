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
		for(int i=0;i<ROW;i++)
		new ThreeMM(numbers.getClone(i));
		//getAverage();
	}
	public static void getAverage(){
		int totalExchange=0;
		int totalQuick=0;
		int totalMerge=0;
		for(int i=0;i<ROW;i++){
		   totalExchange+= new ExchangeSort(numbers.getClone(i)).count;
		   totalQuick+=new QuickSort(numbers.getClone(i)).count;
		   totalMerge+=new MergeSort(numbers.getClone(i)).count;
		}
		System.out.println("\nExchangeSort Average # Comparsion : "+(int)(totalExchange/ROW));
		System.out.println("MergeSort Average # Comparsion : "+(int)(totalMerge/ROW));
		System.out.println("QuickSort Average # Comparsion : "+(int)(totalQuick/ROW));	
	}
	
}