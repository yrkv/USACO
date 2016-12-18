/*
ID: yekuz201
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

public class palsquare {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        
        int B = Integer.parseInt(f.readLine());

        for (int n = 1; n <= 300; n++) {
            if (isPal(toBase(n * n, B))) {
                out.println(toBase(n, B) + " " + toBase(n * n, B));
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
