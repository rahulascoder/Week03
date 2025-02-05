package stringBulilderBuffer;

import java.io.*;

public class ByteToCharStream {
    public static void main(String[] args) {
        // Specifying the file path containing text data
        String fileName = "C:\\Users\\Hp\\Desktop\\Java Training\\Week03\\Day4\\src\\stringBulilderBuffer/sample.txt";

        // Using try-catch block for error handing
        try (
                //  FileInputStream to read the file as a byte stream
                FileInputStream fileInputStream = new FileInputStream(fileName);

                //  Wraping FileInputStream in an InputStreamReader to convert bytes to characters
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

                //  Wraping InputStreamReader in a BufferedReader for efficient reading
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            // Variable to store each line read from the file
            String line;

            // Reading file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Printing the line to the console
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
            // when file is not available
            System.err.println("File not found: " + e.getMessage());
        }
        catch (IOException e) {
            // Handle general I/O errors
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
