
public class DescendingSort extends AscendingSort {
	DescendingSort(Numbers numbers){
		super(numbers);
	}
	
	protected boolean isLeftElligibleWithPivot(int pivot, int lowIndex){
		return (numbers[leftIndex] > pivot && lowIndex < rightIndex);
	}
	
	protected boolean isRightElligibleWithPivot(int pivot, int highIndex){
		return (pivot > numbers[rightIndex] && leftIndex < highIndex);
	}
}
