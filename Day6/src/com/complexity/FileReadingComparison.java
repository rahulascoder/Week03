package com.complexity;
import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        // Path to a 500mb  file
        String filePath = "C:\\Users\\Hp\\Desktop\\Java Training\\Week03\\Day6\\src\\com/500MBFile.txt";

        // Measuring time taken by FileReader
        long startFileReader = System.nanoTime();
        readUsingFileReader(filePath);
        long endFileReader = System.nanoTime();
        System.out.println("FileReader Time: " + (endFileReader - startFileReader) / 1e6 + " ms");

        // Measuring time taken by InputStreamReader
        long startInputStreamReader = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long endInputStreamReader = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endInputStreamReader - startInputStreamReader) / 1e6 + " ms");
    }

    // Method to reading file using FileReader
    public static void readUsingFileReader(String filePath) {
        try (FileReader fr = new FileReader(filePath)) {
            int ch;
            while ((ch = fr.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to reading file using InputStreamReader
    public static void readUsingInputStreamReader(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            int ch;
            while ((ch = isr.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
