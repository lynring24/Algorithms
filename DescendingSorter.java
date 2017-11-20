
public class DescendingSorter extends Sorter {
	DescendingSorter(int[] numbers){
		super(numbers);
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
