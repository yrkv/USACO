/*
ID: yekuz201
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

public class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        String l1 = st.nextToken();
        String[] a1 = l1.split("");

        int p1 = 1;
        for (String a:a1) {
            p1 *= (int) a.charAt(0) - 64;
        }

        st = new StringTokenizer(f.readLine());

        l1 = st.nextToken();
        a1 = l1.split("");

        int p2 = 1;
        for (String a:a1) {
            p2 *= (int) a.charAt(0) - 64;
        }

        out.println(p1 % 47 == p2 % 47 ? "GO" : "STAY");
        out.close();
    }
}
