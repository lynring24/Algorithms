
public class DescendingSort extends AscendingSort {
	DescendingSort(int[] numbers){
		super(numbers);
	}
	
	protected boolean isLeftSmallerThanPivot(int lowIndex){
		return (numbers[leftIndex] > pivot && lowIndex < rightIndex);
	}
	
	protected boolean isRightBiggerThanPivot(int highIndex){
		return (pivot > numbers[rightIndex] && leftIndex < highIndex);
	}
}
