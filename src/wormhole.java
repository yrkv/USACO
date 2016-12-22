/*
ID: yekuz201
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;

public class wormhole {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));

        int N = Integer.parseInt(f.readLine());

        int[] wormholes = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            st.nextToken();
            wormholes[i] = Integer.parseInt(st.nextToken());
        }

        int combos = calculate(N);

        int[] temp = new int[N];
        for (int i = 0; i < N; i++)
            temp[i] = -1;

        int[][] paths = createPaths(temp);



        out.close();
    }


    private static int calculate(int n) {
        if (n <= 2) return 1;
        else return ((n - 1) * calculate(n - 2));
    }

    private static int[][] createPaths(int[] path) {
        int notFull = 0;
        for (int x: path)
            if (x == -1) notFull++;

        int N = path.length;

        int first = 0;
        for (;first < N - 1; first++)
            if (path[first] == -1)
                break;

        if (notFull > 2) {
            int[] lasts = new int[notFull - 1];

            int last = first + 1;
            for (; last < N; last++) {
                if (path[last] == -1) {
                    lasts[0] = last;
                    break;
                }
            }

            for (int i = 1; i < lasts.length; i++) {
                last = lasts[i - 1] + 1;
                for (; last < N; last++) {
                    if (path[last] == -1) {
                        lasts[i] = last;
                        break;
                    }
                }
            }


            int[][] paths = new int[lasts.length][N];

            for (int i = 0; i < lasts.length; i++) {
                paths[i] = path.clone();

                paths[i][lasts[i]] = first;
                paths[i][first] = lasts[i];
            }

            int[][] newPaths = new int[calculate(notFull)][N];


            for (int i = 0; i < lasts.length; i++) {
                int[][] aaa = createPaths(paths[i]);

                int n = calculate(notFull - 2);

                for (int j = i * n; j < i * n + n; j++) {
                    int[] arr = aaa[j - i * n];
                    newPaths[j] = arr.clone();
                }
            }

            return newPaths;
        } else {
            int[][] newPath = new int[1][path.length];
            newPath[0] = path.clone();

            int f = 0;
            for (;f < N - 1; f++)
                if (path[f] == -1)
                    break;

            int l = f + 1;
            for (;l < N - 1; l++)
                if (path[l] == -1)
                    break;

            newPath[0][l] = f;
            newPath[0][f] = l;

            return  newPath;
        }
    }
}