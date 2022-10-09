import java.io.*;
import java.util.Arrays;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Main {
    public static void main(final String[] args) {
        // Creating new folder
        File file = new File("NewFolder");
        file.mkdir();

        // Creating text file
        File txtFile = new File("NewFolder/names.txt");
        try {
            txtFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Reading from created file
        try (Reader reader = new InputStreamReader(new FileInputStream(txtFile))) {
            reader.read();
            char[] array = new char[128];
            StringBuilder result = new StringBuilder();
            int count = reader.read(array);

            while (count > 0) {
                result.append(new String(array, 0, count));
                count = reader.read(array);
            }

            // Converting string to string array
            String[] names = result.toString().split(" ");

            // Converting array to stream, filtering, printing data
            Arrays.stream(names)
                    .filter(s -> s.startsWith("A"))
                    .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
