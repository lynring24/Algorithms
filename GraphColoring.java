import java.util.Scanner;

public class GraphColoring {
	int[] x;
	int[] a;
	int set;
	int size;
	int[][] edge;
	final int NONE = -1;
	int visit = 0;

	void run() {
		initialize();
		backTracking();
		printOutput();
	}

	void initialize() {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		edge = new int[size][size];
		x = new int[size];

		for (int i = 0; i < size; i++) {
			x[i] = NONE;
			for (int j = 0; j < size; j++) {
				edge[i][j] = scan.nextInt();
			}
		}

		set = scan.nextInt();
		scan.close();

		a = new int[set];
		for (int i = 0; i < set; i++)
			a[i] = i + 1;

	}

	void backTracking() {
		int k = 0;
		// initialize;

		while (k < size && k > NONE) {
			getNext(k);

			if (x[k] == NONE)
				k--;
			else {
				if (k == size - 1)
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
			++visit;
			if (bound(k))
				return;
		}
		if (i == set - 1)
			x[k] = -1;
	}

	int getPosition(int x) {
		int i = -1;
		while (x != NONE && i < set) {
			if (x == a[++i])
				break;
		}
		return i;
	}

	void printOutput() {
		if (visit == 0)
			System.out.println("none");
		else {
			double total = 0;
			for (int i = 0; i <= size; i++)
				total += Math.pow(set, i);
			System.out.println(total + ", " + visit + ", " + (visit / total) * 100);
		}
	}

	void print() {
		for (int i = 0; i < size; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}

	boolean bound(int k) {
		for (int i = 0; i < k; i++) {
			if (edge[k][i] == 1 && x[i] == x[k])
				return false;
		}
		return true;
	}
}
