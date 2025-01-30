import java.util.Stack;

public class SortStackRecursily {
    // Function to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Removing the top element
            int top = stack.pop();

            // Recursively sort the remaining stack
            sortStack(stack);

            // Insert the top element back in sorted order
            insertInSortedOrder(stack, top);
        }
    }

    // method to insert an element into a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            // Insert element if stack is empty or correct position is found
            stack.push(element);
        } else {
            // Removing top element
            int top = stack.pop();
            // Recursively inserting the element
            insertInSortedOrder(stack, element);
            // Putting the top element back
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

