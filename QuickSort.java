public class QuickSort {
	int count;
	QuickSort(int[] numbers) {
		count=0;
		quickSort(numbers, 0,numbers.length-1);
	}
	public void quickSort(int[] numbers,int low, int high){
		if (low >= high) return;
		int mid = (low + high) / 2;
		int left = low, right = high;
		while (left < right) {
			while (numbers[left] > numbers[mid]) {left++; count++;}
			while (numbers[right] < numbers[mid]) {right--; count++;}
			if (left<right) {
				int temp= numbers[left];
 				numbers[left]=numbers[right];
 				numbers[right]=temp;
				left++; right--;
			}
		}

		quickSort(numbers, low, mid);
		quickSort(numbers,mid+1,high);
	}
}
