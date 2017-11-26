
public class StaticRandomNumbers {
	final static public int ROW=1000;
	private static int [][] originalNumbers;
	StaticRandomNumbers(int size){
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
	}
}
