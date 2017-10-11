
public class OriginalNumbers {
	private static int [] originalNumbers;
	OriginalNumbers(int size){
		originalNumbers=new int[size];
			for(int j=0;j<size;j++){
				originalNumbers[j]=(int)(Math.random()*100+1);
				System.out.print(originalNumbers[j]+" ");
			}
		System.out.println();
	}
	public int[] getClone(){
		return originalNumbers.clone();
	}
}
