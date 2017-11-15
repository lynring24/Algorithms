
public class DescendingSorter extends AscendingSorter {
	DescendingSorter(int[] numbers){
		super(numbers);
	}
	
	protected boolean isPivotBiggerThan(int lowIndex){
		return (numbers[leftIndex] > pivot && lowIndex < rightIndex);
	}
	
	protected boolean isPivotSmallerThan(int highIndex){
		return (pivot > numbers[rightIndex] && leftIndex < highIndex);
	}
}
