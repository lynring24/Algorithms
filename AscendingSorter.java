
public class AscendingSorter extends Sorter {
	public AscendingSorter() {
		super();
	}

	protected void findNumberFromLeftWithin(int lowerLimit){
		while (numbers[leftIndex] < pivot && lowerLimit < rightIndex) 
			leftIndex++;
	}
	
	protected void findNumberFromRightWithin(int upperLimit){
		while (pivot < numbers[rightIndex] && leftIndex < upperLimit) 
			rightIndex--;
	}
}
