import java.util.Scanner;

public class HamiltonianCycle{
	int[] x;
	int[] a;
	int set;
	int size;
	int [][] edge;
	boolean notExisted = true;
	final int NONE = -1;

	void run() {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		edge = new int[size][size];
		x = new int[size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				edge[i][j] = scan.nextInt();
			}
		}
		x[0]= 1;
		for (int i=1;i<size;i++)
			x[i]=NONE;
		
		set = size;
		a = new int[set];

		for (int i = 0; i < set; i++)
			a[i] = i + 1;

		backTracking();
		if (notExisted)
			System.out.println("There is no HC");
	}
	
	
	void backTracking() {
		int k = 1;
		// initialize;

		while (k < size && k > 0) {
			getNext(k);

			if (x[k] == NONE)
				k--;
			else {
				if (k == size - 1 && edge[x[k]-1][x[0]-1] == 1)
					print();
				else
					k++;
			}
		}
	}
	
	void getNext(int k) {
		int i = getPosition(x[k]);
		while (i < set - 1) {
			x[k] = a[++i];
			if (bound(k))
				return;
		}
		if (i == set - 1)
			x[k] = NONE;
	}
	
	int getPosition(int x) {
		int i = -1;
		while (x != NONE && i < set) {
			if (x == a[++i])
				break;
		}
		return i;
	}
	
	boolean bound(int k) {
		for (int i = 0; i < k; i++) {
			if (x[i] == x[k])
				return false;
		}
		if (edge[x[k]-1][x[k - 1]-1] == 1)
			return true;
		else
			return false;
	}


	void print() {
		notExisted = false;
		for (int i = 0; i < size; i++)
			System.out.print(x[i] + "-");
		System.out.println("1");
	}

}
