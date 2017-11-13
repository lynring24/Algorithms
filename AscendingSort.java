
public class AscendingSort {
	protected int [] numbers;
	protected int leftIndex;
	protected int rightIndex;
	
	AscendingSort(int [] numbers) {
		this.numbers = numbers;
		sortQuick(0, numbers.length-1);
		printSortedNumbers();
	}
	
	protected void sortQuick(int lowIndex, int highIndex) {
		if (lowIndex > highIndex) 
			 return ; 
		
		sortByPartition(lowIndex, highIndex);
		
		if (lowIndex < rightIndex) 
			sortQuick(lowIndex, rightIndex);
		
		if (leftIndex < highIndex) 
			sortQuick(leftIndex, highIndex);
	}
	
	protected void sortByPartition(int lowIndex, int highIndex) {
		int middle = Math.floorDiv(lowIndex+ highIndex,2);
		int pivot = numbers[middle];

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
