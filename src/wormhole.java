/*
ID: yekuz201
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;

public class wormhole {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        
        int N = Integer.parseInt(f.readLine());

        int[] wormholes = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            st.nextToken();
            wormholes[i] = Integer.parseInt(st.nextToken());
        }

        int p, k, key;
        for (p = 1; p < wormholes.length; p++)
        {
            key = wormholes[p];
            for(k = p - 1; (k >= 0) && (wormholes[k] > key); k--)
            {
                wormholes[k+1] = wormholes[k];
            }
            wormholes[k+1] = key;
        }

        int wormholeTypes = 1;

        for (int i = 1; i < N; i++) {
            if (wormholes[i] != wormholes[i - 1]) wormholeTypes++;
        }

        int[] wormholeCounts = new int[wormholeTypes];

        int sum = 0;

        for (int i = 1; i < N; i++) {
            if (wormholes[i] == wormholes[i - 1]) {
                sum += nCr(N / 2, 2);
            }
        }

        
        out.println(sum);
        out.close();
    }

    private static int nCr(int a, int b) {
        return (f(a) / f(a - b)) / f(b);
    }

    private static int f(int a) {
        if (a <= 1) return 1;
        else return a * f(a-1);
    }
}