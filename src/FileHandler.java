import java.io.*;
import java.util.*;

public class FileHandler {

    // Ensures the file exists
    private static void ensureFileExists(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    // Reads all lines from a file and returns as List<String>
    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            ensureFileExists(filename);
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return lines;
    }

    // Appends a line to a file
    public static void appendToFile(String filename, String content) {
        try {
            ensureFileExists(filename);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(content);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
        }
    }

    // Overwrites a file with a list of lines
    public static void overwriteFile(String filename, List<String> lines) {
        try {
            ensureFileExists(filename);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error overwriting file: " + filename);
        }
    }
}
