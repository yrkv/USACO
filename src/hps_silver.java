import java.io.*;
import java.util.StringTokenizer;

public class hps_silver {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hps_silver.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps_silver.out")));

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

		int start = 0, end = 1, c1 = 0, c2 = 0;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2--;
			if (actions[i] == start) c1++;
			if (c2 + c1 > most) most = c2 + c1;
		}


		start = 0;
		end = 2;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2--;
			if (actions[i] == start) c1++;
			if (c2 + c1 > most) most = c2 + c1;
		}



		start = 1;
		end = 0;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2--;
			if (actions[i] == start) c1++;
			if (c2 + c1 > most) most = c2 + c1;
		}




		start = 1;
		end = 2;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2--;
			if (actions[i] == start) c1++;
			if (c2 + c1 > most) most = c2 + c1;
		}





		start = 2;
		end = 0;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2--;
			if (actions[i] == start) c1++;
			if (c2 + c1 > most) most = c2 + c1;
		}





		start = 2;
		end = 1;
		c1 = 0;
		c2 = 0;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2++;
		}
		if (c2 > most) most = c2;

		for (int i = 0; i < N; i++) {
			if (actions[i] == end) c2--;
			if (actions[i] == start) c1++;
			if (c2 + c1 > most) most = c2 + c1;
		}



		out.println(most);
		out.close();
	}
}
