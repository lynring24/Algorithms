import java.util.Scanner;

public class Floyd {

	int[][] d;
	int[][] w;
	int[][] p;
	int n, src, des;
	String input;
	String[] args;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Floyd main = new Floyd();
		main.getInput();
		main.parseInput();
		main.printparse();
		// main.floyd();
		// main.printPath();
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		input = input.replace(" ", "");
		input = input.replace("\"", "");
		System.out.println(input);
		args = input.split(",");
	}

	private void printInput() {
		System.out.println("printInput()");
		for (int i = 0; i < args.length; i++)
			System.out.println(args[i]);
	}

	private void parseInput() {
		int end = args.length;

		n = Integer.parseInt(args[0]);

		w = new int[n][n];
		for (int i = 0,k = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(args[k++]);
			}
		}
		src = Integer.parseInt(args[end - 2]);
		des = Integer.parseInt(args[end - 1]);
	}
	
	private void printparse() {
		System.out.println("printparse()");
		System.out.println(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(w[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(src);
		System.out.println(des);
	}

	private void floyd() {
		initialize();
		calculateAllNode();
	}

	private void initialize() {
		d = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				d[i][j] = w[i][j];
	}

	private void calculateAllNode() {
		/* from src to des, add kth vertex for minimum weight edge */
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					if (needsUpdate(k, i, j)) {
						d[i][j] = d[i][k] + d[k][j];
						p[i][j] = k;
					}
				}
	}

	private boolean needsUpdate(int k, int i, int j) {
		return (d[i][j] > d[i][k] + d[k][j]) || (d[i][j] == -1);
	}

	private void printPath() {
		printD();
		printP();
		path(src, des);
	}

	private void printD() {
		System.out.println("D");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(d[i][j]);
		}
		System.out.println();
	}

	private void printP() {
		System.out.println("P");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(p[i][j]);
		}
		System.out.println();
	}

	private void path(int src, int des) {
		if (p[src][des] != 0) {
			path(src, p[src][des]);
			System.out.print(" " + p[src][des]);
			path(p[src][des], des);
		}
	}

}
