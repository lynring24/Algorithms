
public class AscendingSorter extends Sorter {
	public AscendingSorter() {
		super();
	}

	protected void lookNumberToSortFromLeft(){
		while (numbers[leftIndex] < pivot) 
			leftIndex++;
	}
	
	protected void lookNumberToSortFromRight(){
		while (pivot < numbers[rightIndex] ) 
			rightIndex--;
	}
}
