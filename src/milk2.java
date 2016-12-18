/*
ID: yekuz201
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

public class milk2 {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        
        int times = Integer.parseInt(f.readLine());

        int[][] arr = new int[times + 1][2];

        arr[times] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int i = 0; i < times; i++) {
            String nLine = f.readLine();
            StringTokenizer st = new StringTokenizer(nLine);
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] key = new int[2];
        for (int i = 1; i < times; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arr[j][0] < arr[j-1][0]){
                    key[0] = arr[j][0];
                    key[1] = arr[j][1];
                    arr[j][0] = arr[j-1][0];
                    arr[j][1] = arr[j-1][1];
                    arr[j-1][0] = key[0];
                    arr[j-1][1] = key[1];
                }
            }
        }
        int newKey;
        for (int i = 1; i < times; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arr[j][1] < arr[j-1][1]){
                    newKey = arr[j][1];
                    arr[j][1] = arr[j-1][1];
                    arr[j-1][1] = newKey;
                }
            }
        }
        int longestMilking = 0;
        int longestNot = 0;

        for (int i = 0; i < times; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            while (arr[i][1] >= arr[i+1][0]) {
                end = (arr[i+1][1] > end) ? arr[i+1][1] : end;
                i++;
            }
            if (end - start > longestMilking) longestMilking = end - start;
        }



        for (int i = 0; i < times - 1; i++) {
            int start = arr[i][1];
            int end = arr[i+1][0];
            if (end - start > longestNot) longestNot = end - start;
        }

        out.println(longestMilking + " " + longestNot);
        out.close();
    }
}
