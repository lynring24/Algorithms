
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
		
		sortByPartition(lowIndex, highIndex);
		
		if (lowIndex < rightIndex) 
			sort(lowIndex, rightIndex);
		
		if (leftIndex < highIndex) 
			sort(leftIndex, highIndex);
	}
	
	protected void sortByPartition(int lowIndex, int highIndex) {
		int middle = Math.floorDiv(lowIndex+ highIndex,2);
		pivot = numbers[middle];

		leftIndex = lowIndex;
		rightIndex = highIndex;
		
		while (leftIndex <= rightIndex) {
			while (isPivotBiggerThan(lowIndex)) 
				leftIndex++;
			
			while (isPivotSmallerThan(highIndex)) 
				rightIndex--;
			
			if (leftIndex <= rightIndex) 
				swap(leftIndex, rightIndex);	
		}
	}
	
	protected boolean isPivotBiggerThan(int lowIndex) {
		return (numbers[leftIndex] < pivot && lowIndex < rightIndex);
	}
	
	protected boolean isPivotSmallerThan(int highIndex) {
		return (pivot < numbers[rightIndex] && leftIndex < highIndex);
	}
	
	private void swap(int index1, int index2) {
		int temp = numbers[index1];
		
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
		rightIndex--;
		leftIndex++;
	}
	
	protected void printSortedNumbers() {
		for (int i = 0; i < numbers.length; i++) 
			System.out.print(numbers[i]+" ");
		
		System.out.println();
	}
}
