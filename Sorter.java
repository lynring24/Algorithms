
public abstract class Sorter {
	protected int [] numbers;
	protected int leftIndex;
	protected int rightIndex;
	protected int pivot;
	
	public void printResult(int[] numbers) {
		this.numbers = numbers;
		sort(0, numbers.length - 1);
		printSortedNumbers();
	}
	
	protected void sort(int lowerLimit, int upperLimit) {
		if (lowerLimit >= upperLimit) 
			 return ; 
		
		sortByMiddle(lowerLimit, upperLimit);
		sort(lowerLimit, rightIndex);
		sort(leftIndex, upperLimit);
	}
	
	protected void sortByMiddle(int lowerLimit, int upperLimit) {
		int middle = Math.floorDiv(lowerLimit + upperLimit, 2);
		pivot = numbers[middle];
		leftIndex = lowerLimit;
		rightIndex = upperLimit;
		
		while (isSortNotFinished()) {
			findNumberFromLeftWithin(lowerLimit);
			findNumberFromRightWithin(upperLimit);
			
			if (isSortNotFinished()) { 
				swap(leftIndex, rightIndex);		
				rightIndex--;
				leftIndex++;	
			}
		}
	}
	
	private boolean isSortNotFinished() {
		return leftIndex <= rightIndex;
	}
	
	abstract protected void findNumberFromLeftWithin(int lowerLimit);
	
	abstract protected void findNumberFromRightWithin(int upperLimit);
	
	private void swap(int left, int right) {
		int temperate = numbers[left];
		numbers[left] = numbers[right];
		numbers[right] = temperate;
	}
	
	protected void printSortedNumbers() {
		for (int i = 0; i < numbers.length; i++) 
			System.out.print(numbers[i]+" ");
		
		System.out.println();
	}
}
