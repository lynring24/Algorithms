
public class OriginalNumbers {
<<<<<<< HEAD
	final static public int ROW=1;
	private static int [][] originalNumbers;
	OriginalNumbers(int size){
		originalNumbers=new int[ROW][size];
		for(int i=0;i<ROW;i++){
			System.out.print((i+1)+" : ");
			for(int j=0;j<size;j++){
				originalNumbers[i][j]=(int)(Math.random()*100+1);
				System.out.print(originalNumbers[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public int[] getClone(int i){
		return originalNumbers[i].clone();
=======
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
>>>>>>> 5f6cf2079fe6bdf75af04738c0d73e5174d77eb8
	}
}
