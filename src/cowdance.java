/*
ID: yekuz201
LANG: JAVA
TASK: cowdance
*/
import java.io.*;
import java.util.*;

public class cowdance {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[] cows = new int[N];

		for (int i = 0; i < N; i++)
			cows[i] = Integer.parseInt(f.readLine());


		int high = N;
		int low = 0;
		int mid;
		while (true) {
			mid = (high + low) / 2;
			if (timeToFinish(mid, cows) > T)
				low = mid + 1;
			else if (timeToFinish(mid, cows) <= T) {
				if (timeToFinish(mid - 1, cows) < T)
					high = mid - 1;
				else break;
			}
		}

//		for (int i = 1; i <= N; i++) {
//			if (timeToFinish(i, cows) <= T) {
//				out.println(i);
//				break;
//			}
//		}

		out.println(mid);
		out.close();
	}

	private static int timeToFinish(int K, int[] cows) {
		if (K == 0) return Integer.MAX_VALUE;
		int t = 0;
		int cowsIndex = K;

		int[] dancing = new int[K];
		System.arraycopy(cows, 0, dancing, 0, K);

		sort(dancing);

		while (dancing[K - 1] > 0) {
			t += dancing[0];
			subtractAll(dancing, dancing[0]);
			while (dancing[0] == 0) {
				if (cowsIndex < cows.length) {
					dancing[0] = cows[cowsIndex];
					cowsIndex++;
					sort(dancing);
				} else {
					t += dancing[K - 1];
					subtractAll(dancing, dancing[K - 1]);
					break;
				}
			}
		}

		return t;
	}

	private static void sort(int[] arr) {
		int p, k, key;
		for (p = 1; p < arr.length; p++)
		{
			key = arr[p];
			for(k = p - 1; (k >= 0) && (arr[k] > key); k--)
			{
				arr[k+1] = arr[k];
			}
			arr[k+1] = key;
		}
	}

	private static void subtractAll(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++)
			arr[i] -= n;
	}
}
