
public class AscendingSorter {
	protected int [] numbers;
	protected int leftIndex;
	protected int rightIndex;
	protected int pivot;
	
	AscendingSorter(int[] numbers) {
		this.numbers = numbers;
	}
	
	public void sort() {
		sort(0, numbers.length - 1);
	}
	
	
	protected void sort(int lowerLimit, int upperLimit) {
		if (lowerLimit > upperLimit) 
			 return ; 
		
		sortByMiddle(lowerLimit, upperLimit);
		
		if (lowerLimit < rightIndex) 
			sort(lowerLimit, rightIndex);
		
		if (leftIndex < upperLimit) 
			sort(leftIndex, upperLimit);
	}
	
	protected void sortByMiddle(int lowerLimit, int upperLimit) {
		int middle = Math.floorDiv(lowerLimit+ upperLimit,2);
		pivot = numbers[middle];

		leftIndex = lowerLimit;
		rightIndex = upperLimit;
		
		while (leftIndex <= rightIndex) {
			findNumberToSwapFromLeft(lowerLimit);
			findNumberToSwapFromRight(upperLimit);
			
			if (leftIndex <= rightIndex) 
				swap(leftIndex, rightIndex);	
		}
	}
	
	protected void findNumberToSwapFromLeft(int lowerLimit){
		while (numbers[leftIndex] < pivot && lowerLimit < rightIndex) 
			leftIndex++;
	}
	
	protected void findNumberToSwapFromRight(int upperLimit){
		while (pivot < numbers[rightIndex] && leftIndex < upperLimit) 
			rightIndex--;
	}
	
	private void swap(int left, int right) {
		int temperate = numbers[left];
		
		numbers[left] = numbers[right];
		numbers[right] = temperate;
		rightIndex--;
		leftIndex++;
	}
	
	protected void printSortedNumbers() {
		for (int i = 0; i < numbers.length; i++) 
			System.out.print(numbers[i]+" ");
		
		System.out.println();
	}
}
