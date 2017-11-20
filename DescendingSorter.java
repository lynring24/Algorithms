
public class DescendingSorter extends Sorter {

	public DescendingSorter() {
		super();
	}

	protected void findNumberFromLeftWithin(int lowerLimit){
		while (numbers[leftIndex] > pivot && lowerLimit < rightIndex) 
			leftIndex++;
	}
	
	protected void findNumberFromRightWithin(int upperLimit){
		while (pivot > numbers[rightIndex] && leftIndex < upperLimit) 
			rightIndex--;
	}
}
