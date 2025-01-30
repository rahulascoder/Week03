import java.util.Stack;

public class StockSpan {

    // Method to calculate the span of stock prices
    public static int[] calculateSpan(int[] prices) {
        // Geting the length of the prices array
        int n = prices.length;
        // Creating an array to store spans
        int[] spans = new int[n];
        // Use a stack to store indices of prices
        Stack<Integer> stack = new Stack<>();

        // Iterate over each price in the array
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and the top element is less than or equal to the current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            spans[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            // Pushing the current index onto the stack
            stack.push(i);
        }

        return spans;
    }

    // Main method to test the calculateSpan method
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Calculating the spans for the sample prices
        int[] spans = calculateSpan(prices);

        // Printing the prices
        System.out.println("Price: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();

        // Printing the calculated spans
        System.out.println("Span: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
