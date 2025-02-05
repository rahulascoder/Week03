package stringBulilderBuffer;

import java.io.*;

public class ReadFileExample {
    public static void main(String[] args) {
        // Path to the file
        String filePath = "C:\\Users\\Hp\\Desktop\\Java Training\\Week03\\Day4\\src\\stringBulilderBuffer/sample.txt";

        try {
            // Creating a FileReader object
            FileReader fileReader = new FileReader(filePath);

            // Wraping FileReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            // printing each line until the end of the file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Closing the resources
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
