import java.io.*;
import java.util.StringTokenizer;

public class hps_gold {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hps_gold.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps_gold.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] actions = new int[N];

		for (int i = 0; i < N; i++) {
			String character = f.readLine();
			if (character.equals("H")) {actions[i] = 0;}
			if (character.equals("P")) {actions[i] = 1;}
			if (character.equals("S")) {actions[i] = 2;}
		}


		int most = 0;

		int[] selections = new int[K + 1];
		int[] c = new int[K + 1];

		for (int i = 0; i < N; i++) {
			if (actions[i] == selections[0]) c[0]++;
		}
		if (c[0] > most) most = c[0];

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2--;
			if (actions[i] == start) c1++;
			if (c2 + c1 > most) most = c2 + c1;
		}

		out.println(most);
		out.close();
	}

	private static int[][] split(int[] arr, int k) {
		if (k == 0) return new int[][] {arr};
		int most = 0, splitPos = 0;

		int start = 0, end = 1, c1 = 0, c2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2--;
			if (arr[i] == start) c1++;
			if (c2 + c1 > most) {
				most = c2 + c1;
				splitPos = i;
			}
		}


		start = 0;
		end = 2;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2--;
			if (arr[i] == start) c1++;
			if (c2 + c1 > most) {
				most = c2 + c1;
				splitPos = i;
			}
		}



		start = 1;
		end = 0;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2--;
			if (arr[i] == start) c1++;
			if (c2 + c1 > most) {
				most = c2 + c1;
				splitPos = i;
			}
		}




		start = 1;
		end = 2;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2--;
			if (arr[i] == start) c1++;
			if (c2 + c1 > most) {
				most = c2 + c1;
				splitPos = i;
			}
		}





		start = 2;
		end = 0;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2--;
			if (arr[i] == start) c1++;
			if (c2 + c1 > most) {
				most = c2 + c1;
				splitPos = i;
			}
		}





		start = 2;
		end = 1;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == end) c2--;
			if (arr[i] == start) c1++;
			if (c2 + c1 > most) {
				most = c2 + c1;
				splitPos = i;
			}
		}

		return new int[][] {split(subArray(arr, 0, splitPos), k - 1), split(subArray(arr, splitPos, 0), k - 1)};
	}

	private static int count(int arr[], int target) {
		int c = 0;
		for (int x: arr)
			if (x == target) c++;

		return c;
	}

	private static int[] subArray(int[] arr, int start, int end) {
		int[] newArr = new int[end - start];

		System.arraycopy(arr, start, newArr, 0, end - start);

		return newArr;
	}
}
