import java.util.Scanner;

public class Algorithms {

	final static public int ROW=5;
	public static int [] copyNumbers;
	public static int [][] originalNumbers;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("size : ");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		
		generateNumber(size);
		/*
		System.out.println("\n[min max]");
		for(int i=0;i<ROW;i++){
			copyNumbers= originalNumbers[i].clone();
			int[] num=new ThreeMM().minMax(copyNumbers, 0,copyNumbers.length-1);
			System.out.println(num[0]+" "+num[1]);
		}
		
		System.out.println("\n[ExchangeSort]");
		for(int i=0;i<ROW;i++){
			copyNumbers= originalNumbers[i].clone();
			new ExchageSort(copyNumbers);
			printNumbers(copyNumbers);
		}
		
		System.out.println("\n[MergeSort]");
		for(int i=0;i<ROW;i++){
			copyNumbers= originalNumbers[i].clone();
			new MergeSort(copyNumbers);
			printNumbers(copyNumbers);
		}
		*/
		System.out.println("\n[QuickSort]");
		for(int i=0;i<ROW;i++){
			copyNumbers= originalNumbers[i].clone();
			new QuickSort(copyNumbers);
		}
	}
	public static void printNumbers(int [][] array){
		for(int i=0;i<ROW;i++){
			for(int j=0;j<array[i].length;j++)
			System.out.print(array[i][j]+" ");
		System.out.println();
		}
	}
	public static void printNumbers(int [] array){
			for(int j=0;j<array.length;j++)
			System.out.print(array[j]+" ");
		System.out.println();
	}
	public static void generateNumber(int size){
		originalNumbers= new int [ROW][size];
		for(int i=0;i<ROW;i++){
			for(int j=0;j<size;j++)
				originalNumbers[i][j]=(int)(Math.random()*100+1);
		}
		System.out.println("[BEFORE]");
		printNumbers(originalNumbers);
	}
}
