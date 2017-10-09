
public class ThreeMM {
	public int[] minMax(int [] numbers,int low, int high){
		int [] minMax=new int[2];
		if(low==high){
			System.out.println("g(n) 1");
			minMax[0]=numbers[low];
			minMax[1]=minMax[0];
		}
		else if (low==high-1){
			System.out.println("g(n) 2");
			if(numbers[low]<numbers[high]){
				minMax[0]=numbers[low];
				minMax[1]=numbers[high];
			}
			else{
				minMax[0]=numbers[high];
				minMax[1]=numbers[low];
			}
		}
		else{
			int mid1=low+Math.floorDiv(high-low,3);
			int mid2=low+Math.floorDiv((high-low)*2,3);
			int [] minMax1=new int[2];
			int [] minMax2=new int[2];
			int [] minMax3=new int[2];
			minMax1=minMax(numbers,low,mid1);
			minMax2=minMax(numbers,mid1+1,mid2);
			minMax3=minMax(numbers,mid2+1,high);
			minMax[0]=(minMax1[0]<minMax2[0])?minMax1[0]:minMax2[0];
			minMax[0]=(minMax[0]<minMax3[0])?minMax[0]:minMax3[0];
			minMax[1]=(minMax1[1]>minMax2[1])?minMax1[1]:minMax2[1];
			minMax[1]=(minMax[1]>minMax3[1])?minMax[1]:minMax3[1];
		}
		return minMax;
	}
}