
public class DescendingSorter extends AscendingSorter {
	DescendingSorter(int[] numbers){
		super(numbers);
	}

	protected void findNumberToSwapFromLeft(int lowIndex){
		while (numbers[leftIndex] > pivot && lowIndex < rightIndex) 
			leftIndex++;
	}
	
	protected void findNumberToSwapFromRight(int highIndex){
		while (pivot > numbers[rightIndex] && leftIndex < highIndex) 
			rightIndex--;
	}
}
