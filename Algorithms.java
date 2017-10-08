import java.util.Scanner;

public class Algorithms {

	final static public int ROW=100;
	public static int [][] originalNumbers;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Numbers in a set : ");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		originalNumbers= new int [ROW][size];
		
		generateNumbers(size);
		
		countExchangeSort();
		countMergeSort();
		countQuickSort();
	}
	public static void generateNumbers(int size){
		for(int i=0;i<ROW;i++){
			for(int j=0;j<size;j++){
				originalNumbers[i][j]=(int)(Math.random()*100+1);
				System.out.print(originalNumbers[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void countExchangeSort(){
		int count=0;
		for(int i=0;i<ROW;i++)
		   count+= new ExchangeSort(originalNumbers[i].clone()).count;
		System.out.println("ExchangeSort Average # Comparsion : "+(int)(count/ROW));
	}
	public static void countMergeSort(){
		int count=0;
		for(int i=0;i<ROW;i++)
			   count+=new MergeSort(originalNumbers[i].clone()).count;
			System.out.println("MergeSort Average # Comparsion : "+(int)(count/ROW));	
	}
	public static void countQuickSort(){
		int count=0;
		for(int i=0;i<ROW;i++)
			count+=new QuickSort(originalNumbers[i].clone()).count;
		System.out.println("QuickSort Average # Comparsion : "+(int)(count/ROW));	
	}
	
}