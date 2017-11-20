
public class DescendingSorter extends Sorter {

	public DescendingSorter() {
		super();
	}

	protected void lookNumberToSortFromLeft() {
		while (numbers[leftIndex] > pivot)
			leftIndex++;
	}

	protected void lookNumberToSortFromRight() {
		while (pivot > numbers[rightIndex])
			rightIndex--;
	}
}
