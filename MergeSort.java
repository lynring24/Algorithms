
public class MergeSort {
	MergeSort(int[] numbers) {
		mergeSort(numbers,0,numbers.length-1);
	}
	
	public void mergeSort(int[] numbers,int low, int high){
		if(low<high){
			int mid=Math.floorDiv(low+high,2);
			mergeSort(numbers,low,mid);
			mergeSort(numbers,mid+1,high);
			merge(numbers,low,mid,high);
		}
	}
	public void merge(int[] numbers,int low, int mid, int high){
		int leftIndex=low;
		int rightIndex=mid+1;
		int tempIndex=0;
		int [] tempArray = new int [numbers.length];
		while(leftIndex<=mid&&rightIndex<=high){
			if(numbers[leftIndex]<numbers[rightIndex])
				tempArray[tempIndex++]=numbers[leftIndex++];
			else
				tempArray[tempIndex++]=numbers[rightIndex++];
		}
		if(leftIndex>mid){
			while(rightIndex<=high)
				tempArray[tempIndex++]=numbers[rightIndex++];
		}
		else{
			while(leftIndex<=mid)
				tempArray[tempIndex++]=numbers[leftIndex++];
		}
		for(tempIndex=0; low<=high;tempIndex++){
			numbers[low++]=tempArray[tempIndex];
		}
			
	}
}
