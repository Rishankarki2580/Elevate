import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordManagement {

    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n -- Student Management system:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.println("Enter Your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Existing ... Thank You!!!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }


    // Add Student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        // Check if ID already exists
        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.println("Student with this ID already exists!");
                return;
            }
        }

        sc.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student newStudent = new Student(id, name, marks);
        studentList.add(newStudent);
        System.out.println("Student added successfully.");
    }

    // View Students
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : studentList) {
            s.display();
        }
    }

    // Update Student
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); // Consume newline
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();

                System.out.print("Enter new Marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);

                System.out.println("Student record updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Delete Student
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                System.out.println("Student record deleted successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

}

