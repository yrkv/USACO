/*
ID: yekuz201
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

public class crypt1 {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        
        int N = Integer.parseInt(f.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(f.readLine());

        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());


        int cases = 0;

        for (int i = 100; i < 1000; i++) {
            if (!usesDigits(i, nums)) continue;
            for (int j = 10; j < 100; j++) {
                if (!usesDigits(j, nums)) continue;
                if (!usesDigits(((j % 10) * i), nums)) continue;
                if (!usesDigits(((j / 10) * i), nums)) continue;
                if (!usesDigits((j * i), nums)) continue;
                if ((((j%10) * i) + "").length() != 3) continue;
                if ((((j/10) * i) + "").length() != 3) continue;
                if (((j * i) + "").length() != 4) continue;
                cases++;
            }
        }
        
        out.println(cases);
        out.close();
    }

    private static boolean usesDigits(int num, int[] nums) {
        while (num > 0) {
            int rem = num % 10;
            num /= 10;
            boolean digitUsed = false;
            for (int number:nums) {
                if (number == rem) digitUsed = true;
            }

            if (!digitUsed) return false;
        }
        return true;
    }
}
