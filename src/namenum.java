/*
ID: yekuz201
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

public class namenum {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));

        String[] names = new String[4617];
        for (int i = 0; i < 4617; i++) {
            names[i] = dict.readLine();
        }
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        
        String input = f.readLine();

        String[][] chars = new String[8][];

        chars[0] = new String[] {"A", "B", "C"};
        chars[1] = new String[] {"D", "E", "F"};
        chars[2] = new String[] {"G", "H", "I"};
        chars[3] = new String[] {"J", "K", "L"};
        chars[4] = new String[] {"M", "N", "O"};
        chars[5] = new String[] {"P", "R", "S"};
        chars[6] = new String[] {"T", "U", "V"};
        chars[7] = new String[] {"W", "X", "Y"};

        boolean found = false;

        for (int i = 0; i < 4617; i++) {
            boolean match = true;
            if (names[i].length() == input.length()) {
                for (int j = 0; j < names[i].length(); j++) {
                    int num = Integer.parseInt(input.substring(j, j+1)) - 2;
                    String c = names[i].substring(j, j+1);
                    if (!(c.equals(chars[num][0]) || c.equals(chars[num][1]) || c.equals(chars[num][2]))) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    out.println(names[i]);
                    found = true;
                }
            }
        }

        if (!found) out.println("NONE");
        out.close();
    }

    public boolean search(String[] array, String key)
    {
        int low = 0;
        int high = array.length - 1;

        while(high >= low) {
            int middle = (low + high) / 2;
            if(array[middle].equals(key))
                return true;
            if(array[middle].compareTo(key) < 0)
                low = middle + 1;
            if(array[middle].compareTo(key) > 0)
                high = middle - 1;
        }
        return false;
    }
}
