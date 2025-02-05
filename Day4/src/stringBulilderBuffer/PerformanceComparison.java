package stringBulilderBuffer;

public class PerformanceComparison {
    public static void main(String[] args) {
        // 1 million iterations
        int iterations = 1000000;
        String text = "hello";

        // Measuring time for StringBuffer
        long startTime1 = System.nanoTime();

        //initializing stringBuffer to create object
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTime1 = System.nanoTime();
        long stringBufferTime = endTime1 - startTime1;

        // Measuring time for StringBuilder
        long startTime2 = System.nanoTime();

        //initializing stringBuilder to create object
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTime2 = System.nanoTime();
        long stringBuilderTime = endTime2 - startTime2;

        // Result
        System.out.println("Time taken by StringBuffer: " + stringBufferTime / 1000000 + " ms");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime / 1000000 + " ms");
    }
}
