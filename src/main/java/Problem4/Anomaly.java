package Problem4;

import java.io.*;

public class Anomaly {
    public static void main(String[] args) throws IOException {

        // Q4 (a)
        fileReaderConsoleOutput();
        // Q4 (b)
        missingID();
        // Q4 (c)
        writeMissingIDtoFile();

    }

    // prints to the console line by line the data in log.txt
    public static void fileReaderConsoleOutput() throws IOException {
        BufferedReader inputStream = null;
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            inputStream = new BufferedReader(new FileReader(dir + "/log.txt"));
            String l;
            // read and print each line
            while ((l = inputStream.readLine()) != null) {
                System.out.println(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    // prints the missing ID entries to the console
    public static void missingID() throws IOException {
        BufferedReader inputStream = null;
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            inputStream = new BufferedReader(new FileReader(dir + "/log.txt"));
            String l;
            while ((l = inputStream.readLine()) != null) {
                // check if the id is missing at first character of string
                if (l.charAt(0) == ',') {
                    System.out.println(l);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    // Writes the missing id entries to an anomalies.txt
    public static void writeMissingIDtoFile() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            inputStream = new BufferedReader(new FileReader(dir + "/log.txt"));
            outputStream = new PrintWriter(new FileWriter(dir + "/anomalies.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                if (l.charAt(0) == ',') {
                    // write to the printwriter
                    outputStream.println(l);
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
