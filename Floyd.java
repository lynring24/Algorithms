import java.util.Scanner;

public class Floyd {

	int[][] d;
	int[][] w;
	int[][] p;
	int n;
	String[] args;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Floyd main = new Floyd();
		main.getInput();
		main.parseInput();
		main.floyd();
		main.printPath();
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input = input.replace(" ", "");
		input = input.replace("\"", "");
		args = input.split(",");
	}

	private void parseInput() {
		int end = args.length;
		int k = 0;
		n = Integer.parseInt(args[k++]);
		w = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(args[k++]);
			}
		}
	}

	private void floyd() {
		initialize();
		calculateAllNode();
	}

	private void initialize() {
		d = new int[n][n];
		p = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				d[i][j] = w[i][j];
	}

	private void calculateAllNode() {
		/* from src to des, add kth vertex for minimum weight edge */
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					if (needUpdate(k, i, j)) {
						if (d[i][k] != -1 && d[k][j] != -1) {
							d[i][j] = d[i][k] + d[k][j];
							p[i][j] = k+1;
						}
					}
				}
	}

	private boolean needUpdate(int k, int i, int j) {
		boolean isUndirected = d[i][j] == -1;
		boolean isNotSelf = i != j;
		boolean isSmaller = d[i][j] > d[i][k] + d[k][j];
		return (isSmaller || isUndirected) && isNotSelf;
	}

	private void printPath() {
		printD();
		printP();
		int src = Integer.parseInt(args[args.length - 2]) -1;
		System.out.print((src+1)+"-");
		int des = Integer.parseInt(args[args.length - 1]) -1;
		path(src, des);
		System.out.print(des+1);
	}

	private void printD() {
		System.out.println("D");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%3d", d[i][j]));
			System.out.println();
		}
		System.out.println();
	}

	private void printP() {
		System.out.println("P");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
					System.out.print(String.format("%3d", p[i][j]));
			System.out.println();
		}
		System.out.println();
	}

	private void path(int q, int r) {
		if (p[q][r] != 0) {
			path(q, p[q][r]-1);
			System.out.print(p[q][r]+"-");
			path(p[q][r]-1, r);
		}
	}

}
