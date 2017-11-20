
public class BinarySearch {
	//public Numbers numbers;
	public int key;
	public int position;
	BinarySearch(int size){
		System.out.println("[BINARY SEARCH]");
		//numbers = new Numbers(size);
		
		//new LinearSort(numbers.array);

		key = (int)(Math.random()*99)+1;
		//Scanner scan = new Scanner(System.in);
		//key = scan.nextInt();
		//position = search(numbers.array, 0, size-1,key );
		printResult();
	}
	public int search(int [] numbers, int low, int high, int key){	
		while(low<high){
			int mid= Math.floorDiv(low+high,2);
			if(numbers[mid]==key)
				return mid;
			else if(key<numbers[mid])
				high=mid-1;
			else
				low=mid+1;
		}
		return -1;
	}
	public void printResult(){
		//numbers.printNumbers();
		if(position==-1)
			System.out.println("There is no Key ("+key+")");
		else 
			System.out.println("(KEY/POSITION): ("+key+"/"+position+")");
	}
}
