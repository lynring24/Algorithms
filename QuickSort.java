
public class QuickSort {
	int count;
	QuickSort(int[] numbers) {
		count=0;
		quickSort(numbers, 0,numbers.length-1);
	}
	public void quickSort(int[] numbers,int low, int high){
		if(low<high){
			int pivot = partition(numbers,low,high);
			quickSort(numbers,low,pivot);
			quickSort(numbers,pivot+1,high);
		}
	}
	public int partition(int[] numbers, int low, int high){
		int key = numbers[low];
		int pivot = low;
		  for(int i=low+1;i<=high;i++){
				count++;
			  if(numbers[i]<key){
				pivot++; 
				int temp = numbers[i];
				numbers[i]=numbers[pivot];
				numbers[pivot]=temp;
			  }
		  }
		  int temp = numbers[low];
		  numbers[low]=numbers[pivot];
		  numbers[pivot]=temp;
		  return pivot;
	}
}
