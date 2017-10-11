
public class PartitionQuickSort {
	int count;
	PartitionQuickSort (int[] numbers) {
		count=0;
		quickSort(numbers, 0,numbers.length-1);
	}
	public void quickSort(int[] numbers,int low, int high){
		if(low<high){
			int pivot = partition1(numbers,low,high);
			quickSort(numbers,low,pivot-1);
			quickSort(numbers,pivot+1,high);
		}
	}
	public int partition2(int[] numbers, int low, int high){int pivot = numbers[low];
		int left=low;
		int end=high;
		 		while(left<high){
		 			for(;left<=end && numbers[left]<=pivot;left++) 
		 				count++;
					for(;high>=low && numbers[high]>pivot;high--) 
						count++;
		 			if(left<high){
		 				int temp= numbers[left];
		 				numbers[left]=numbers[high];
		 				numbers[high]=temp;
		 				left++; high--;
		 			}
		 			else break;
		 		}
		 		numbers[low]=numbers[high];
		 		numbers[high]=pivot;
		 return high;
	}
	
	public int partition1(int[] numbers, int low, int high){
		int key = numbers[low];
		int pivot = low;
		  for(int i=low+1;i<=high;i++){
			  if(numbers[i]<key){
				pivot++; 
				int temp = numbers[i];
				numbers[i]=numbers[pivot];
				numbers[pivot]=temp;
			  }
			count++;
		  }
		  int temp = numbers[low];
		  numbers[low]=numbers[pivot];
		  numbers[pivot]=temp;
		  return pivot;
	}
	
}
