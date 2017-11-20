
public class DescendingSorter extends Sorter {

	public DescendingSorter() {
		super();
	}

	protected void findNumberToSwapFromLeft(int lowerLimit){
		while (numbers[leftIndex] > pivot && lowerLimit < rightIndex) 
			leftIndex++;
	}
	
	protected void findNumberToSwapFromRight(int upperLimit){
		while (pivot > numbers[rightIndex] && leftIndex < upperLimit) 
			rightIndex--;
	}
}
