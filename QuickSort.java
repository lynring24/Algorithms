public class QuickSort {
	int count;
	QuickSort(int[] numbers) {
		count=0;
		sort(numbers, 0,numbers.length-1);
		for(int i=0;i<numbers.length;i++)
			System.out.print(numbers[i]+" ");
		System.out.println();
	}
	public void sort(int[] data, int low, int high){
        int left = low;
        int right = high;
        int pivot = data[(low+high)/2];
        
        while (left <= right){
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
           }
        }
        
        if(low < right) sort(data, low, right);
        if(high > left) sort(data, left, high);
    }

}
