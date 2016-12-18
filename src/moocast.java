/*
ID: yekuz201
LANG: JAVA
TASK: moocast
*/
import java.io.*;
import java.util.*;

public class moocast {
    private static boolean[] skip;

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        
        int N = Integer.parseInt(f.readLine());

        int[][] cows = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());

            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
            cows[i][2] = Integer.parseInt(st.nextToken());
        }

        int mostReached = 0;

        for (int i = 0; i < N; i++) {
            skip = new boolean[N];
            int reach = getReached(N, cows, i);
            if (reach > mostReached) mostReached = reach;
        }
        
        
        out.println(mostReached);
        out.close();
    }

    private static boolean reach(int x1, int y1, int x2, int y2, int p) {
        return !(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) > p * p);
    }

    private static int getReached(int N, int[][] cows, int cow) {
        skip[cow] = true;
        int out = 1;
        for (int i = 0; i < N; i++) {
            if (skip[i]) continue;

            if (reach(cows[cow][0], cows[cow][1], cows[i][0], cows[i][1], cows[cow][2])) {
                out += getReached(N, cows, i);
            }
        }
        return out;
    }
}
