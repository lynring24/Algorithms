
public class DescendingSorter extends AscendingSorter {
	DescendingSorter(int[] numbers){
		super(numbers);
	}
	
	protected boolean isPivotBiggerThanLeft(int lowIndex){
		return (numbers[leftIndex] > pivot && lowIndex < rightIndex);
	}
	
	protected boolean isPivotSmallerThanRight(int highIndex){
		return (pivot > numbers[rightIndex] && leftIndex < highIndex);
	}
}
