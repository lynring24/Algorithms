
public class AscendingSort {
	protected int [] numbers;
	protected int leftIndex;
	protected int rightIndex;
	protected int pivot;
	
	AscendingSort(int[] numbers) {
		this.numbers = numbers;
	}
	
	protected void sortNumbers(int lowIndex, int highIndex) {
		if (lowIndex > highIndex) 
			 return ; 
		
		sortByPartition(lowIndex, highIndex);
		
		if (lowIndex < rightIndex) 
			sortNumbers(lowIndex, rightIndex);
		
		if (leftIndex < highIndex) 
			sortNumbers(leftIndex, highIndex);
	}
	
	protected void sortByPartition(int lowIndex, int highIndex) {
		int middle = Math.floorDiv(lowIndex+ highIndex,2);
		pivot = numbers[middle];

		leftIndex = lowIndex;
		rightIndex = highIndex;
		
		while (leftIndex <= rightIndex) {
			while (isLeftElligibleWithPivot(pivot, lowIndex)) 
				leftIndex++;
			
			while (isRightElligibleWithPivot(pivot,highIndex)) 
				rightIndex--;
			
			if (leftIndex <= rightIndex) 
				swap(leftIndex, rightIndex);	
		}
	}
	
	protected boolean isLeftElligibleWithPivot(int pivot, int lowIndex){
		return (numbers[leftIndex] < pivot && lowIndex < rightIndex);
	}
	
	protected boolean isRightElligibleWithPivot(int pivot, int highIndex){
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
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
	}
}
