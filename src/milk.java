/*
ID: yekuz201
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

public class milk {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] farmer = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            farmer[i][0] = Integer.parseInt(st.nextToken());
            farmer[i][1] = Integer.parseInt(st.nextToken());
        }

        int p, k, key1, key2;
        for (p = 1; p < farmer.length; p++)
        {
            key1 = farmer[p][0];
            key2 = farmer[p][1];
            for(k = p - 1; (k >= 0) && (farmer[k][0] > key1); k--)
            {
                farmer[k+1][0] = farmer[k][0];
                farmer[k+1][1] = farmer[k][1];
            }
            farmer[k+1][0] = key1;
            farmer[k+1][1] = key2;
        }

        int farmerIndex = 0;
        int cost = 0;

        while (N > 0 && farmerIndex < M) {
            if (N >= farmer[farmerIndex][1]) {
                N -= farmer[farmerIndex][1];
                cost += farmer[farmerIndex][1] * farmer[farmerIndex][0];
                farmerIndex++;
            }
            else if (N < farmer[farmerIndex][1]) {
                cost += N * farmer[farmerIndex][0];
                N = 0;
            }
        }
        
        out.println(cost);
        out.close();
    }
}
