/*
ID: yekuz201
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class transform {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        
        int n = Integer.parseInt(f.readLine());

        int[][] image = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = f.readLine();
            for (int j = 0; j < n; j++) {
                if (line.substring(j, j+1).equals("@"))
                    image[i][j] = 1;
                else
                    image[i][j] = 0;
            }
        }

        int[][] transformedImage = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = f.readLine();
            for (int j = 0; j < n; j++) {
                if (line.substring(j, j+1).equals("@"))
                    transformedImage[i][j] = 1;
                else
                    transformedImage[i][j] = 0;
            }
        }

        out.println(compare(image, transformedImage, n));
        out.close();
    }

    private static int compare(int[][] image1, int[][] image2, int n) {
        if (Arrays.deepEquals(rotate(image1, 90, n), image2)) {
            return 1;
        }
        if (Arrays.deepEquals(rotate(image1, 180, n), image2)) {
            return 2;
        }
        if (Arrays.deepEquals(rotate(image1, 270, n), image2)) {
            return 3;
        }
        if (Arrays.deepEquals(reflect(image1, n), image2)) {
            return 4;
        }
        if (Arrays.deepEquals(reflect(rotate(image1, 90, n), n), image2)) {
            return 5;
        }
        if (Arrays.deepEquals(reflect(rotate(image1, 180, n), n), image2)) {
            return 5;
        }
        if (Arrays.deepEquals(reflect(rotate(image1, 270, n), n), image2)) {
            return 5;
        }
        if (Arrays.deepEquals(image1, image2)) return 6;
        return 7;
    }

    private static int[][] reflect(int[][] input, int n) {
        int[][] out = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int y = n - j - 1;
                out[i][y] = input[i][j];
            }
        }

        return out;
    }

    private static int[][] rotate(int[][] input, int degrees, int n) {
        int x;
        int y;
        int[][] out = new int[n][n];
        if (degrees == 270) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    x = n - j - 1;
                    out[x][i] = input[i][j];
                }
            }
        }
        if (degrees == 180) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    x = n - i - 1;
                    y = n - j -1;
                    out[x][y] = input[i][j];
                }
            }
        }
        if (degrees == 90) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    y = n - i -1;
                    out[j][y] = input[i][j];
                }
            }
        }

        return out;
    }
}
