package stringBulilderBuffer;

import java.io.*;

public class ReadAndWriteToFile {
    public static void main(String[] args) {
        // File name for storing in file
        String fileName = "user_input.txt";

        // try catch block for better handling of error and exceptions
        try (
                //creating InputStreamReader to read from the console
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);

                // Creating FileWriter to write to the file
                FileWriter fw = new FileWriter(fileName)
        ) {
            System.out.println("Enter text to write to the file and type exit to stop :");
            String input;

            // Reading input line by line
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                // Writing input to file with a newline
                fw.write(input + "\n");
            }

            System.out.println("User input has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
