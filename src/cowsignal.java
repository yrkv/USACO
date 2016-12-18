/*
ID: yekuz201
LANG: JAVA
TASK: cowsignal
*/
import java.io.*;
import java.util.*;

public class cowsignal {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowsignal.in")); // initialize file reader
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out"))); // initialize file writer
        
        StringTokenizer st = new StringTokenizer(f.readLine()); // get information
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String output = "";

        for (int i = 0; i < M; i ++) {
            String line = f.readLine();
            String newLine = "";
            for (int j = 0; j < N; j++) {
                String c = line.substring(j, j+1);
                for (int k = 0; k < K; k++) {
                    newLine += c;
                }
            }
            for (int k = 0; k < K; k++) {
                output += newLine + "\n";
            }
        }

        out.print(output);
        out.close();
    }
}
