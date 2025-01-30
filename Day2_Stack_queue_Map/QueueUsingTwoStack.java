import java.util.Stack;

public class QueueUsingTwoStack {
    // Stack for enqueue operations
    private Stack<Integer> stack1;
    // Stack for dequeue operations
    private Stack<Integer> stack2;

    //constructor
    public QueueUsingTwoStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Pushing element onto stack1 enqueue
    public void enqueue(int data) {
        stack1.push(data);
    }

    //Removing element from front of the queue
    public int dequeue() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2 only if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.pop();
    }

    // Peek operation: Get front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingTwoStack queue = new QueueUsingTwoStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("dequeue : "+queue.dequeue());
        queue.enqueue(4);
        System.out.println("dequeue : "+ queue.dequeue());
        System.out.println("Peek : "+queue.peek());
        System.out.println("dequeue : "+queue.dequeue());
        System.out.println("dequeue : "+queue.dequeue());
        System.out.println("Is queue is Empty : " +queue.isEmpty());
    }
}
