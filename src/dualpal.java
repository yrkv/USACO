/*
ID: yekuz201
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

public class dualpal {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int printed = 0;
        for (int i = S + 1; printed < N; i++) {
            int count = 0;
            for (int j = 2; j < 11; j++) {
                if (isPal(toBase(i, j))) {
                    count++;
                }
            }
            if (count >= 2) {
                out.println(i);
                printed++;
            }
        }

        out.close();
    }

    private static boolean isPal(String in) {
        boolean isPal = true;
        for (int i = 0; i < in.length() / 2; i++) {
            if (!in.substring(i, i+1).equals(in.substring(in.length() - i - 1, in.length() - i)))
                isPal = false;
        }
        return isPal;
    }

    private static String toBase(int n, int b) {
        String out = "";
        int a = (int) Math.floor(Math.log(n) / Math.log(b)) + 1;
        int[] val = new int[a];
        while (n > 0) {
            int p = (int) (Math.log(n) / Math.log(b));
            n -= Math.pow(b, p);
            val[p]++;
        }
        for (int i = val.length - 1; i >= 0; i--) {
            out += toString(val[i]);
        }
        return out;
    }

    private static String toString(int number) {
        if (number < 10) return number + "";
        else {
            return Character.toString((char) (number + 55));
        }
    }
}
