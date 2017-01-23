/*
ID: yekuz201
LANG: JAVA
TASK: cowcode
*/
import java.io.*;
import java.util.*;

public class cowcode {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());

		String text = st.nextToken();
		long N = Long.parseLong(st.nextToken());

		long location = N;
		System.out.println(location);

		while (location > text.length()) {
			double n = (location - 1.0) / text.length();
			if ((Math.log(n) / Math.log(2)) % 1 == 0) {
				location--;
				System.out.println(location);
				continue;
			}

			long subtract = (long) Math.pow(2, (long) (Math.log(n) / Math.log(2))) * text.length();

			location -= subtract + 1;
			System.out.println(location);
		}

		out.println(text.charAt((int) location - 1));
		out.close();
	}
}
