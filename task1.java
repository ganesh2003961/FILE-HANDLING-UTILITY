import java.io.*;
import java.nio.file.*;
import java.util.List;

public class task1 {
    private static final String FILE_PATH = "sample.txt";

    // Method to write to a file
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to read from a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify a file (replacing a word in the text)
    public static void modifyFile(String oldWord, String newWord) {
        try {
            Path path = Paths.get(FILE_PATH);
            List<String> lines = Files.readAllLines(path);
            
            for (int i = 0; i < lines.size(); i++) {
                lines.set(i, lines.get(i).replace(oldWord, newWord));
            }
            
            Files.write(path, lines);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Writing content to the file
        writeFile("Hello, this is a sample file.\nWelcome to CodTech Internship!");
        
        // Reading the file content
        readFile();
        
        // Modifying the file (replacing "CodTech" with "TechCod")
        modifyFile("CodTech", "TechCod");
        
        // Reading the modified content
        readFile();
    }
}

