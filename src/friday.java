/*
ID: yekuz201
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class friday {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int input = Integer.parseInt(f.readLine());

        int[] week = new int[7];

        int day = 4;

        for (int year = 1900; year <= 1899 + input; year++) {
            day = (day + 31) % 7;
            week[day]++;
            day = (day + 31) % 7;
            week[day]++;
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
                day = (day + 29) % 7;
            week[day]++;
            day = (day + 31) % 7;
            week[day]++;
            day = (day + 30) % 7;
            week[day]++;
            day = (day + 31) % 7;
            week[day]++;
            day = (day + 30) % 7;
            week[day]++;
            day = (day + 31) % 7;
            week[day]++;
            day = (day + 31) % 7;
            week[day]++;
            day = (day + 30) % 7;
            week[day]++;
            day = (day + 31) % 7;
            week[day]++;
            day = (day + 30) % 7;
            week[day]++;
        }

        for (int i = 0; i < 6; i++)
            out.print(week[i] + " ");
        out.println(week[6]);
        out.close();
    }
}
