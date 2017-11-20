import java.util.Scanner;

public class Algorithms {
	final static public int ROW=1000;
	public static OriginalNumbers numbers;
	static int totalExchange=0;
	static int totalQuick=0;
	static int totalMerge=0;
	public static void main(String[] args) {
		
		System.out.print("Numbers in a set : ");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();

		calculateComplexity(size);
		getAverage();
	}
	public static void calculateComplexity(int size){
		for(int i=0;i<ROW;i++){
			System.out.print((i+1)+" : ");
			numbers = new OriginalNumbers(size);
			totalExchange+= new ExchangeSort(numbers.getClone()).count;
			totalQuick+=new QuickSort(numbers.getClone()).count;
			totalMerge+=new MergeSort(numbers.getClone()).count;
		}
	}
	public static void getAverage(){
		System.out.println("\nExchangeSort Average # Comparsion : "+(int)(totalExchange/ROW));
		System.out.println("MergeSort Average # Comparsion : "+(int)(totalMerge/ROW));
		System.out.println("QuickSort Average # Comparsion : "+(int)(totalQuick/ROW));	
	}
	
}