
public class ThreeMM {
	public int count3=0;
	ThreeMM(int[] numbers){
		minMax(numbers,0,numbers.length-1);
		System.out.println("count3 : "+count3);
		System.out.println();
	}
	public int[] minMax(int [] numbers,int low, int high){
		int [] minMax=new int[2];
		if(low==high){
			minMax[0]=numbers[low];
			minMax[1]=minMax[0];
		}
		else if (low==high-1){
			count3++;
			if(numbers[low]<numbers[high]){
				minMax[0]=numbers[low];
				minMax[1]=numbers[high];
			}
			else{
				minMax[0]=numbers[high];
				minMax[1]=numbers[low];
			}
		}
		else if (low==high-2){
			count3++;
			if(numbers[low]<numbers[low+1]){
				minMax[0]=numbers[low];
				minMax[1]=numbers[low+1];
			}
			else{
				minMax[0]=numbers[low+1];
				minMax[1]=numbers[low];
			}
			count3++;
			if(minMax[1]<numbers[high])
				minMax[1]=numbers[high];
			
			else{ 
				count3++;
				if(minMax[0]>numbers[high])
					minMax[0]=numbers[high];
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
			count3++;
			minMax[0]=(minMax[0]<minMax3[0])?minMax[0]:minMax3[0];
			count3++;
			minMax[1]=(minMax1[1]>minMax2[1])?minMax1[1]:minMax2[1];
			count3++;
			minMax[1]=(minMax[1]>minMax3[1])?minMax[1]:minMax3[1];
			count3++;
		}
		return minMax;
	}
}