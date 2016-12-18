/*
ID: yekuz201
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {
    private static String[] names;

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        
        int NP = Integer.parseInt(f.readLine());

        names = new String[NP];

        int[] cash = new int[NP];

        for (int i = 0; i < NP; i++) {
            names[i] = f.readLine();
        }

        for (int i = 0; i < NP; i++) {
            String person = f.readLine();
            String header = f.readLine();
            StringTokenizer st = new StringTokenizer(header);
            int amount = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for (int j = 0; j < people; j++) {
                cash[nameToInt(f.readLine())] += amount / people;
            }
            if (people > 0)
                cash[nameToInt(person)] += amount % people - amount;
        }

        for (int i = 0; i < NP; i++) {
            out.println(names[i] + " " + cash[i]);
        }
        out.close();
    }

    private static int nameToInt(String name) {
        for (int i = 0; i < names.length; i++) {
            if (name.equals(names[i])) return i;
        }
        return 0; // only for compiler, never actually reached.
    }
}
