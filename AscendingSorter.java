
public class AscendingSorter extends Sorter {
	public AscendingSorter() {
		super();
	}

	protected void findNumberToSwapFromLeft(int lowerLimit){
		while (numbers[leftIndex] < pivot && lowerLimit < rightIndex) 
			leftIndex++;
	}
	
	protected void findNumberToSwapFromRight(int upperLimit){
		while (pivot < numbers[rightIndex] && leftIndex < upperLimit) 
			rightIndex--;
	}
}
