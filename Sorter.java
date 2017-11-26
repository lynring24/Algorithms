
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
		if (lowerLimit >= upperLimit) 
			 return ; 
		
		sortByMiddle( lowerLimit, upperLimit );
		sort(lowerLimit, rightIndex);
		sort(leftIndex, upperLimit);
	}
	
	protected void sortByMiddle(int lowerLimit, int upperLimit) {
		int middle = Math.floorDiv(lowerLimit + upperLimit, 2);
		pivot = numbers[middle];
		leftIndex = lowerLimit;
		rightIndex = upperLimit;
		
		while (isSortNotFinished()) {
			lookNumberToSortFromLeft();
			lookNumberToSortFromRight();
			exchange(); 
		}
	}
	
	private boolean isSortNotFinished() {
		return leftIndex <= rightIndex;
	}
	
	abstract protected void lookNumberToSortFromLeft();
	
	abstract protected void lookNumberToSortFromRight();
	
	private void exchange() { 
		if (isSortNotFinished()) { 
			swap();		
			rightIndex--;
			leftIndex++;	
		}
	}
	
	private void swap() {
		int temperate = numbers[leftIndex];
		numbers[leftIndex] = numbers[rightIndex];
		numbers[rightIndex] = temperate;
	}
	
	protected void printResult() {
		for (int i = 0; i < numbers.length; i++) 
			System.out.print(numbers[i]+" ");
		
		System.out.println();
	}
}
