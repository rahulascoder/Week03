package Day1.Level1;

class Task {
    //attributes
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    //constructor
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
//class Task schedular
class TaskScheduler {
    //fixing head and current task
    private Task head;
    private Task current;

    // creating method to adding a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            // Circular link
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    // creating method to adding a task at the  end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head; // Circular link
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (prev == null) { // Removing head
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head.next == head) {
                        head = null; // Only one node was present
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // View current task and move to the next task
    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task: " + current.taskName + " | Priority: " + current.priority + " | Due Date: " + current.dueDate);
            current = current.next;
        }
    }

    // Display all tasks starting from head
    public void displayAllTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.taskId + " | " + temp.taskName + " | " + temp.priority + " | " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search task by Priority
    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskId + " | " + temp.taskName + " | Due Date: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding some tasks
        scheduler.addTaskAtEnd(1, "Submit Assignment", 2, "2025-02-10");
        scheduler.addTaskAtBeginning(2, "Prepare Presentation", 1, "2025-02-08");
        scheduler.addTaskAtEnd(3, "Team Meeting", 3, "2025-02-12");
        scheduler.addTaskAtBeginning(4, "Project Deadline", 1, "2025-02-05");

        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearching Tasks with Priority 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nRemoving Task ID 2 and displaying list:");
        scheduler.removeTask(2);
        scheduler.displayAllTasks();
    }
}