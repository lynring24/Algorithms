
public abstract class Sorter {
	protected int [] numbers;
	protected int leftIndex;
	protected int rightIndex;
	protected int pivot;
	
	public void sort(int[] numbers) {
		this.numbers = numbers;
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
		int middle = Math.floorDiv(lowerLimit+ upperLimit, 2);
		pivot = numbers[middle];

		leftIndex = lowerLimit;
		rightIndex = upperLimit;
		
		while (isSortNotFinished()) {
			findNumberToSwapFromLeft(lowerLimit);
			findNumberToSwapFromRight(upperLimit);
			
			if (isSortNotFinished()) 
				swap(leftIndex, rightIndex);	
		}
	}
	
	private boolean isSortNotFinished() {
		return leftIndex <= rightIndex;
	}
	
	abstract protected void findNumberToSwapFromLeft(int lowerLimit);
	
	abstract protected void findNumberToSwapFromRight(int upperLimit);
	
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
