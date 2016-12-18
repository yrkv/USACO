/*
ID: yekuz201
LANG: JAVA
TASK: haybales
*/
import java.io.*;
import java.util.*;

public class haybales {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        Integer[] bales = new Integer[N];

        for (int i = 0; i < N; i++) {
            bales[i] = Integer.parseInt(st.nextToken());
        }


        int p, k, key;
        for (p = 1; p < bales.length; p++)
        {
            key = bales[p];
            for(k = p - 1; (k >= 0) && (bales[k] > key); k--)
            {
                bales[k+1] = bales[k];
            }
            bales[k+1] = key;
        }

        String output = "";

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            output += thing(bales, start, end, N) + "\n";
        }

        out.print(output);
        out.close();
    }

    private static int thing(Integer[] bales, int start, int end, int N) {
        int c = 0;

        int low = 0;
        int high = N - 1;
        int mid = 0;

        while (high >= low) {
            mid = (low + high) / 2;
            if (high - low > 1)
                if (bales[mid] > start) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            else break;
        }
        for (int j = mid; j < bales.length && bales[j] <= end; j++) {
            if (bales[j] >= start) c++;
        }
        return c;
    }
}
