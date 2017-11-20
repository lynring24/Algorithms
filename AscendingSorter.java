
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
	
	
	protected void sort(int lowIndex, int highIndex) {
		if (lowIndex > highIndex) 
			 return ; 
		
		sortByMiddle(lowIndex, highIndex);
		
		if (lowIndex < rightIndex) 
			sort(lowIndex, rightIndex);
		
		if (leftIndex < highIndex) 
			sort(leftIndex, highIndex);
	}
	
	protected void sortByMiddle(int lowIndex, int highIndex) {
		int middle = Math.floorDiv(lowIndex+ highIndex,2);
		pivot = numbers[middle];

		leftIndex = lowIndex;
		rightIndex = highIndex;
		
		while (leftIndex <= rightIndex) {
			while (isPivotBiggerThanLeftIn(lowIndex)) 
				leftIndex++;
			
			while (isPivotSmallerThanRightIn(highIndex)) 
				rightIndex--;
			
			if (leftIndex <= rightIndex) 
				swap(leftIndex, rightIndex);	
		}
	}
	

	protected boolean isPivotBiggerThanLeftIn(int lowIndex) {
		return (numbers[leftIndex] < pivot && lowIndex < rightIndex);
	}
	
	protected boolean isPivotSmallerThanRightIn(int highIndex) {
		return (pivot < numbers[rightIndex] && leftIndex < highIndex);
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
