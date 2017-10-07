//import java.util.Scanner;
public class RecursiveBinarySearch {
	//public Numbers numbers;
	public int key;
	public int position;
	RecursiveBinarySearch(int size){
		System.out.println("[RECURSIVE BINARY SEARCH]");
		//numbers = new Numbers(size);
		
		//new ExchageSort(numbers.array);

		key = (int)(Math.random()*99)+1;
		//Scanner scan = new Scanner(System.in);
		//key = scan.nextInt();
		//position = search(numbers.array, 0, numbers.array.length-1,key );
		printResult();
	}
	public int search(int [] numbers, int low, int high, int key){
		if(low>high) return -1;
		else{
			int mid = Math.floorDiv(low+high,2);
			if(numbers[mid]==key)
				return mid;
			else if(key<numbers[mid])
				return search(numbers,low, mid-1,key);
			else
				return search(numbers,mid+1,high, key);
		}
	}
	public void printResult(){
		//numbers.printNumbers();
		if(position==-1)
			System.out.println("There is no Key ("+key+")");
		else 
			System.out.println("(KEY/POSITION): ("+key+"/"+position+")");
	}
}
