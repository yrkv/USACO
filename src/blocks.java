/*
ID: yekuz201
LANG: JAVA
TASK: blocks
*/
import java.io.*;
import java.util.*;

public class blocks {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        
        int N = Integer.parseInt(f.readLine());

        int[] totalLetters = new int[26];

        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            int[] letters1 = new int[26];
            int[] letters2 = new int[26];

            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);

            String w1 = st.nextToken();
            String w2 = st.nextToken();

            for (int j = 0; j < w1.length(); j++)  letters1[(int) w1.charAt(j)-97]++;
            for (int j = 0; j < w2.length(); j++)  letters2[(int) w2.charAt(j)-97]++;

            for (int j = 0; j < 26; j++) {
                totalLetters[j] += letters1[j] > letters2[j] ? letters1[j] : letters2[j];
            }
        }
        
        for (int i = 0; i < 26; i++) {
            out.println(totalLetters[i]);
        }

        out.close();
    }
}
