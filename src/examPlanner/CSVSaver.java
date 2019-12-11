package examPlanner;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVSaver {
    public static void CSVRead(String pathname) throws Exception {
        File file = new File(pathname);
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            String line = in.nextLine();      // Read a line
            String[] token = line.split(","); // Split the line into an array
            /*String txt = token[0].trim();
            int x = Integer.parseInt(token[1].trim());
            System.out.println(txt + " - " + x ); //print out all 3 entries*/
        }
        in.close();
    }

    public static void CSVSave(String pathname, String[] text) throws Exception {
        File file = new File(pathname);
        PrintWriter out = new PrintWriter(file);

        for (int i = 0; i < text.length; i++) {
            out.println(text[i]);
            out.flush();
        }
        out.close();
    }
}
