
public class AscendingSorter extends Sorter {
	public AscendingSorter() {
		super();
	}

	protected void findLeftToSortWithin(int lowerLimit){
		while (numbers[leftIndex] < pivot && lowerLimit < rightIndex) 
			leftIndex++;
	}
	
	protected void findRightToSortWithin(int upperLimit){
		while (pivot < numbers[rightIndex] && leftIndex < upperLimit) 
			rightIndex--;
	}
}
