
public class QuickSort {

	QuickSort(int[] numbers) {
		quickSort(numbers,0,numbers.length-1);
		for(int j=0;j<numbers.length;j++)
			System.out.print(numbers[j]+" ");
		System.out.println();
	}
	public void quickSort(int[] numbers, int low, int high){
		if(low<high){
			int pivot = partition(numbers, low,high);
			quickSort(numbers,low,pivot);
			quickSort(numbers,pivot+1,high);
		}
	}
	public int partition(int[] numbers, int start, int end){
		int key = numbers[start];
		
		while(start<end){
			for(;numbers[start]<key;start++);
			for(;numbers[end]>key;end--);
			int temp= numbers[start];
			numbers[start]=numbers[end];
			numbers[end]=temp;
		}
		numbers[start]=key;
		return start;
	}
}
