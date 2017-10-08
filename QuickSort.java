
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
	public int partition(int[] numbers, int start, int end){
		int key = numbers[start];
		int i=start;
		while(i<end){
			for(;numbers[i++]<key&&i<end;i++) count++;
			for(;numbers[end]>=key&&end>start;end--) count++;
			if(i<end){
				int temp= numbers[start];
				numbers[start]=numbers[end];
				numbers[end]=temp;
			}
		}
		numbers[start]=numbers[end];
		numbers[end]=key;
		return start;
	}
}
