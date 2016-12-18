/*
ID: yekuz201
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

public class combo {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        
        int N = Integer.parseInt(f.readLine());

        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] combo1 = new int[3];
        combo1[0] = Integer.parseInt(st.nextToken());
        combo1[1] = Integer.parseInt(st.nextToken());
        combo1[2] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        int[] combo2 = new int[3];
        combo2[0] = Integer.parseInt(st.nextToken());
        combo2[1] = Integer.parseInt(st.nextToken());
        combo2[2] = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!matches(combo1[0], i, N) && !matches(combo2[0], i, N)) continue;
            for (int j = 1; j <= N; j++) {
                if (!matches(combo1[1], j, N) && !matches(combo2[1], j, N)) continue;
                for (int k = 1; k <= N; k++) {
                    if (!matches(combo1[2], k, N) && !matches(combo2[2], k, N)) continue;
                    if (matches(combo1, new int[] {i, j, k}, N) || matches(combo2, new int[] {i, j, k}, N))
                        count++;
                }
            }
        }
        
        out.println(count);
        out.close();
    }

    private static boolean matches(int combo, int guess, int N) {
        if (Math.abs(combo - guess) <= 2) return true;
        if (Math.abs(combo - (guess + N)) <= 2) return true;
        if (Math.abs(combo + N - guess) <= 2) return true;
        return  false;
    }

    private static boolean matches(int[] combo, int[] guess, int N) {
        return (matches(combo[0], guess[0], N) && matches(combo[1], guess[1], N) && matches(combo[2], guess[2], N));
    }
}
