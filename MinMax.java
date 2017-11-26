
public class MinMax {
	public int[] minMax(int [] numbers,int low, int high){
		int [] minMax=new int[2];
		if(low==high){
			minMax[0]=numbers[low];
			minMax[1]=minMax[0];
		}
		else if (low==high-1){
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
			int mid=Math.floorDiv(low+high,2);
			int [] minMax1=new int[2];
			int [] minMax2=new int[2];
			minMax1=minMax(numbers,low,mid);
			minMax2=minMax(numbers,mid+1,high);
			minMax[0]=(minMax1[0]<minMax2[0])?minMax1[0]:minMax2[0];
			minMax[1]=(minMax1[1]>minMax2[1])?minMax1[1]:minMax2[1];
		}
		return minMax;
	}
}
