
public class DescendingSorter extends AscendingSorter {
	DescendingSorter(int[] numbers){
		super(numbers);
	}
	
	protected boolean isPivotBiggerThanLeftIn(int lowIndex){
		return (numbers[leftIndex] > pivot && lowIndex < rightIndex);
	}
	
	protected boolean isPivotSmallerThanRightIn(int highIndex){
		return (pivot > numbers[rightIndex] && leftIndex < highIndex);
	}
}
