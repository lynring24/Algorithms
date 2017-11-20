
public class DescendingSorter extends AscendingSorter {
	DescendingSorter(int[] numbers){
		super(numbers);
	}

	protected void findNumberToChangeFromLeft(int lowIndex){
		while (numbers[leftIndex] > pivot && lowIndex < rightIndex) 
			leftIndex++;
	}
	
	protected void findNumberToChangeFromRight(int highIndex){
		while (pivot > numbers[rightIndex] && leftIndex < highIndex) 
			rightIndex--;
	}
}
