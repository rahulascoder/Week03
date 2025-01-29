package Day1.Level1;

class Student {
    //attribiutes
    int rollNumber;
    String name;
    int age;
    char grade;

    // Pointer to the next node in the list
    Student next;

    // Constructor to initialize student details
    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;

        // Initially, next is set to null
        this.next = null;
    }
}
//StudentRecordManagement class
public class StudentRecordManagement {
    // Head of the linked list
    private Student head;

    // Adding a new student at the beginning of the list
    public void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {

        Student newStudent = new Student(rollNumber, name, age, grade);
        // New student's next points to the current head
        newStudent.next = head;

        // Updating head to the new student
        head = newStudent;
    }

    // Adding a new student at the end of the list
    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        //creatinhg object of newStdent of class student
        Student newStudent = new Student(rollNumber, name, age, grade);
        // If the list is empty
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        // Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }
        // Link the last node to the new student
        temp.next = newStudent;
    }

    // Adding a new student at a specific position
    public void addStudentAtPosition(int position, int rollNumber, String name, int age, char grade) {

        Student newStudent = new Student(rollNumber, name, age, grade);
        // If position is the first node
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            // Traverse to the node before the desired position
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        // Linking new node to the next node
        newStudent.next = temp.next;
        // Linking previous node to the new node
        temp.next = newStudent;
    }

    // Deleting a student by Roll Number
    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            // Traversing to the node before the one to delete
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found");
            return;
        }
        // Skiping the node to delete
        temp.next = temp.next.next;
    }

    // Search for a student by Roll Number
    public void searchStudentByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Displaying all student records
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No records to display");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Updating a student's grade based on Roll Number
    public void updateStudentGrade(int rollNumber, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public static void main(String[] args) {
        StudentRecordManagement srm = new StudentRecordManagement();

        // Adding students
        srm.addStudentAtBeginning(1, "Rahul Kumar", 20, 'A');
        srm.addStudentAtEnd(2, "Bhuvan", 21, 'B');
        srm.addStudentAtPosition(2, 3, "Vishnu", 22, 'C');

        // Displaying all students
        System.out.println("All Students:");
        srm.displayAllStudents();

        // Searching for a student
        srm.searchStudentByRollNumber(2);

        // Updating a student's grade
        srm.updateStudentGrade(3, 'A');

        // Deleting a student
        srm.deleteStudentByRollNumber(1);

        // Displaying all students after deletion
        System.out.println("All Students after deletion:");
        srm.displayAllStudents();
    }
}
