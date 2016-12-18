/*
ID: yekuz201
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

public class beads {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        
        int beadsCount = Integer.parseInt(f.readLine());

        String input = f.readLine();

        input = input + input;

        int most = 0;

        for (int j = 0; j < beadsCount; j++) {
            int mostRed = 0;
            int mostBlue = 0;
            int currColor = 0; // red = 1, blue = -1
            for (int i = j; i < beadsCount + j; i++) {
                String bead = input.substring(i, i + 1);

                if (bead.equals("w")) {
                    if (currColor == 1) mostRed++;
                    if (currColor == -1) mostBlue++;
                }
                if (bead.equals("r")) {
                    if (currColor != 1) {
                        mostRed = 0;
                        currColor = 1;
                    }
                    mostRed++;
                }
                if (bead.equals("b")) {
                    if (currColor != -1) {
                        mostBlue = 0;
                        currColor = -1;
                    }
                    mostBlue++;
                }

                int tempMost = mostBlue + mostRed;
                for (int a = i - tempMost; a > j - 1 && input.substring(a, a + 1).equals("w"); a--)
                    tempMost++;
                if (tempMost > most)
                    most = tempMost;
            }
        }
        
        out.println(most);
        out.close();
    }
}
