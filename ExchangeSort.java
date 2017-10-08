
public class ExchangeSort {
	public int count;
	ExchangeSort(int [] numbers) {
		count=0;
		for(int i=0; i <numbers.length-1;i++){
			count++;
			for(int j=i+1;j<numbers.length;j++){
				count++;
				if(numbers[i]>numbers[j]){
					count++;
					int temp = numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
	}
}
