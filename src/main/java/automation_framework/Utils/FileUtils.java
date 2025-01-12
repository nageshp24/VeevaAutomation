package automation_framework.Utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void writeToFile( String content) {
        try (FileWriter writer = new FileWriter("src/Output/ProductDetailsFile.txt", true)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToCSVFile( String content) {
        try (FileWriter writer = new FileWriter("src/Output/DP2_LinksFile.csv", true)) { // Use try-with-resources for auto-closing
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean copyFile(File sourceFilePath, File destinationFilePath) {

        // Copy the file using Apache Commons IO
        FileUtils.copyFile(sourceFilePath, destinationFilePath);
        System.out.println("File copied successfully from " + sourceFilePath + " to " + destinationFilePath);
        return true;
    }

}


