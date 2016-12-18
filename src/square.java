/*
ID: yekuz201
LANG: JAVA
TASK: square
*/
import java.io.*;
import java.util.*;

public class square {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        StringTokenizer st2 = new StringTokenizer(f.readLine());

        int x1 = Integer.parseInt(st1.nextToken());
        int y1 = Integer.parseInt(st1.nextToken());
        int x2 = Integer.parseInt(st1.nextToken());
        int y2 = Integer.parseInt(st1.nextToken());

        int x3 = Integer.parseInt(st2.nextToken());
        int y3 = Integer.parseInt(st2.nextToken());
        int x4 = Integer.parseInt(st2.nextToken());
        int y4 = Integer.parseInt(st2.nextToken());

        int dx1 = Math.abs(x1 - x4);
        int dx2 = Math.abs(x2 - x3);
        int dx3 = x2 - x1;
        int dx4 = x4 - x3;

        int dx5 = dx1 > dx2 ? dx1 : dx2;
        int dx6 = dx3 > dx4 ? dx3 : dx4;

        int dx = (dx5 > dx6 ? dx5 : dx6);

        int dy1 = Math.abs(y1 - y4);
        int dy2 = Math.abs(y2 - y3);
        int dy3 = y2 - y1;
        int dy4 = y4 - y3;

        int dy5 = dy1 > dy2 ? dy1 : dy2;
        int dy6 = dy3 > dy4 ? dy3 : dy4;

        int dy = (dy5 > dy6 ? dy5 : dy6);

        int d = dy > dx ? dy : dx;

        int dd = d*d;


        out.print(dd);
        out.close();
    }
}
