package FileIO;

import java.io.FileInputStream;
import java.io.IOException;

public class FirstFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        if (args.length != 1) {
            System.out.print("Usage: File Open");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            do {
                i = fin.read();
                if (i != -1)
                    System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Error reading file");
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}