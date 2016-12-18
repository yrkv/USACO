/*
ID: yekuz201
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

public class barn1 {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        int MaxBoards = Integer.parseInt(st.nextToken());
        int Stalls = Integer.parseInt(st.nextToken());
        int Cows = Integer.parseInt(st.nextToken());

        int[] stalls = new int[Cows];

        for (int i = 0; i < Cows; i++)
            stalls[i] = Integer.parseInt(f.readLine());

        int p, k, key;
        for (p = 1; p < stalls.length; p++)
        {
            key = stalls[p];
            for(k = p - 1; (k >= 0) && (stalls[k] > key); k--)
            {
                stalls[k+1] = stalls[k];
            }
            stalls[k+1] = key;
        }

        int total = stalls[Cows - 1] - stalls[0] + 1;

        int[] gaps = new int[Cows - 1];

        for (int i = 0; i < Cows - 1; i++)
            gaps[i] = stalls[i+1] - stalls[i] - 1;


        for (p = 1; p < gaps.length; p++)
        {
            key = gaps[p];
            for(k = p - 1; (k >= 0) && (gaps[k] < key); k--)
            {
                gaps[k+1] = gaps[k];
            }
            gaps[k+1] = key;
        }


        for (int i = 0; i < MaxBoards - 1 && i < gaps.length; i++) {
            total -= gaps[i];
        }

        out.println(total);
        out.close();
    }
}
