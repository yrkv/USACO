/*
ID: yekuz201
LANG: JAVA
TASK: citystate
*/
import java.io.*;
import java.util.*;

public class citystate {

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        
        int N = Integer.parseInt(f.readLine());

        String[] cities = new String[N];
        String[] states = new String[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            cities[i] = st.nextToken().substring(0, 2);
            states[i] = st.nextToken();

        }

        int found = 0;

        for (int i = 0; i < N; i++) {
            String code = states[i];
            String city = cities[i];
            for (int j = 0; j < N; j++) {
                if (code.equals(cities[j]) && city.equals(states[j]) && !code.equals(states[j])) {
                    found++;
                }
            }
        }
        
        out.println(found);
        out.close();
    }
}
