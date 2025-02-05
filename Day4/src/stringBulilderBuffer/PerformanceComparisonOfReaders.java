package stringBulilderBuffer;

import java.io.*;

class PerformanceComparisonOfReaders {

    //creating compareStringBuilderAndBuffer method
    private static void compareStringBuilderAndBuffer() {
        // one million iterations
        int iterations = 1000000;

        String text = "hello";

        // Using StringBuilder
        //starting time of process by stringbuilder
        long startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        //end time of process by stringbuilder
        long endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) / 1000000 + " ms");

        // Using StringBuffer
        //starting time of process by stringbuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) / 1000000 + " ms");
    }

    private static void compareFileReaderAndInputStreamReader(String filePath) {
        try {

            // checking time taken by  FileReader
            long startTime = System.nanoTime();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            long wordCount = countWords(br);
            long endTime = System.nanoTime();
            System.out.println("Word count using FileReader: " + wordCount);
            System.out.println("Time taken by FileReader: " + (endTime - startTime) / 1000000 + " ms");
            br.close();
            fileReader.close();

            // Checking time taken by InputStreamReader
            startTime = System.nanoTime();
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
            br = new BufferedReader(isr);
            wordCount = countWords(br);
            endTime = System.nanoTime();
            System.out.println("Word count using InputStreamReader: " + wordCount);
            System.out.println("Time taken by InputStreamReader: " + (endTime - startTime) / 1000000 + " ms");
            br.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //declaring method to throw exception if any occurs
    private static long countWords(BufferedReader br) throws IOException {
        long wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        return wordCount;
    }

    //main method
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReaderAndInputStreamReader( "C:\\Users\\Hp\\Desktop\\Java Training\\Week03\\Day4\\src\\stringBulilderBuffer/sample.txt");
    }
}
