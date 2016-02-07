import java.util.Scanner;

class CuttingRob{

	static int y;
	static int z;

	int Modified_Memoized_Cut_Rod(int p[], int n) throws Exception {
		if (n >= p.length) {
			throw new Exception(
					"rod of length can not grater than the price array length");
		}
		int r[] = new int[n + 1];
		int s[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		return Modified_Memoized_Cut_Rod_Aux(p, n, r, s);
	}

	int Modified_Memoized_Cut_Rod_Aux(int p[], int n, int r[], int s[])
			throws Exception {
		if (n >= p.length) {
			throw new Exception(
					"rod of length can not grater than the price array length");
		}
		int q;
		if (r[n] >= 0) {
			return r[n];
		}
		if (n == 0) {
			q = 0;
		} else {
			q = Integer.MIN_VALUE;
			for (int j = 1; j <= n; j++) {
				if (q < p[j] + Modified_Memoized_Cut_Rod_Aux(p, n - j, r, s)) {
					q = p[j] + Modified_Memoized_Cut_Rod_Aux(p, n - j, r, s);
					s[n] = j;
					j = n - s[n];
					System.out.println(" From Prices = " + q + " Cuts = "
							+ s[n] + " + " + j);
				}
			}
			r[n] = q;
		}
		y = s[n];
		z = n - s[n];
		return q;
	}

	public static void main(String args[]) throws Exception {

		// 1 2 3 4 5 6 7 8 9 10 //
		int[] p = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		System.out.print("Enter the value of rod of length n = ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if (n >= p.length || n <= 0) {
			throw new Exception(
					"rod of length can not grater than the price array length OR n <= 0");
		}
		System.out.println("[Modified_Memoized_Cut_Rod] Rod of Lenghth = " + n
				+ " Solution are ");
		CuttingRob cd = new CuttingRob();
		int x = cd.Modified_Memoized_Cut_Rod(p, n);
		System.out.println("Final Answer Prices = " + x);
		System.out.println("Final Answer Cutting Slices = " + y + " + " + z);
	}
}

