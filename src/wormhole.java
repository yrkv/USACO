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

        int[][] wormholes = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            wormholes[i][0] = Integer.parseInt(st.nextToken());
            wormholes[i][1] = Integer.parseInt(st.nextToken());
        }

        int p, k;
        int[] key = new int[2];
        for (p = 1; p < wormholes.length; p++)
        {
            key[0] = wormholes[p][0];
            key[1] = wormholes[p][1];
            for(k = p - 1; (k >= 0) && (wormholes[k][0] > key[0]); k--)
            {
                wormholes[k+1][0] = wormholes[k][0];
                wormholes[k+1][1] = wormholes[k][1];
            }
            wormholes[k+1][0] = key[0];
            wormholes[k+1][1] = key[1];
        }

        int combos = calculate(N);

        int[] temp = new int[N];
        for (int i = 0; i < N; i++)
            temp[i] = -1;

        int[][] paths = createPaths(temp);

        int count = 0;

        for (int[] path: paths) {
            if (testPath(path, wormholes))
                count++;
        }

        out.println(count);
        out.close();
    }

    private static boolean testPath(int[] path, int[][] wormholes) {
        int N = wormholes.length;
        for (int start = 0; start < N; start++) {
            int location = start + 1;

            int lastY = wormholes[start][1];
            int lastX = wormholes[start][0];

            while (location < N) {
                if (wormholes[location][1] == lastY && wormholes[location][0] > lastX) {
                    location = path[location];
                    lastY = wormholes[location][1];
                    lastX = wormholes[location][0];

                }
                if (location == start)
                    return true;
                while (location < N && (wormholes[location][0] == lastX || wormholes[location][1] != lastY)) {
                    location++;
                }
            }
        }
        return false;
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