//  Implement a Student class with attributes such as ID, name, age, gender, grade, and contact information using ArrayList 
//  .Create a menu-driven program with an administrator login feature that allows authorized users to:
//Add a new student to the database.
//B.	Remove a student from the database by their ID.
//Update student information (name, age, grade, etc.).
// Display all student information.
// Search for a student by their ID, name, grade, or any other criteria.
// F.	Implement error handling and validation for user inputs, such as invalid IDs, duplicate entries, etc. 
//program
import java.util.ArrayList;
import java.util.Scanner;

// Student class with attributes ID, name, age, gender, grade, and contact information
class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String grade;
    private String contactInfo;

    public Student(int id, String name, int age, String gender, String grade, String contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.contactInfo = contactInfo;
    }

    // Getters and setters for Student attributes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

// Main class for the program
public class W_Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Administrator login credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public static void main(String[] args) {
        if (adminLogin()) {
            while (true) {
                System.out.println("1. Add a new student");
                System.out.println("2. Remove a student by ID");
                System.out.println("3. Update student information");
                System.out.println("4. Display all students");
                System.out.println("5. Search for a student");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        displayAllStudents();
                        break;
                    case 5:
                        searchStudent();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    private static boolean adminLogin() {
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Check for duplicate ID
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student ID already exists. Try again.");
                return;
            }
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter student gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter student contact info: ");
        String contactInfo = scanner.nextLine();

        students.add(new Student(id, name, age, gender, grade, contactInfo));
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        boolean removed = students.removeIf(student -> student.getId() == id);

        if (removed) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new age: ");
                student.setAge(scanner.nextInt());
                scanner.nextLine();  // Consume newline
                System.out.print("Enter new gender: ");
                student.setGender(scanner.nextLine());
                System.out.print("Enter new grade: ");
                student.setGrade(scanner.nextLine());
                System.out.print("Enter new contact info: ");
                student.setContactInfo(scanner.nextLine());

                System.out.println("Student information updated successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println("ID: " + student.getId() +
                                   ", Name: " + student.getName() +
                                   ", Age: " + student.getAge() +
                                   ", Gender: " + student.getGender() +
                                   ", Grade: " + student.getGrade() +
                                   ", Contact Info: " + student.getContactInfo());
            }
        }
    }

    private static void searchStudent() {
        System.out.println("Search by:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Grade");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                for (Student student : students) {
                    if (student.getId() == id) {
                        System.out.println("ID: " + student.getId() +
                                           ", Name: " + student.getName() +
                                           ", Age: " + student.getAge() +
                                           ", Gender: " + student.getGender() +
                                           ", Grade: " + student.getGrade() +
                                           ", Contact Info: " + student.getContactInfo());
                        return;
                    }
                }
                System.out.println("Student ID not found.");
                break;
            case 2:
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                for (Student student : students) {
                    if (student.getName().equalsIgnoreCase(name)) {
                        System.out.println("ID: " + student.getId() +
                                           ", Name: " + student.getName() +
                                           ", Age: " + student.getAge() +
                                           ", Gender: " + student.getGender() +
                                           ", Grade: " + student.getGrade() +
                                           ", Contact Info: " + student.getContactInfo());
                        return;
                    }
                }
                System.out.println("Student name not found.");
                break;
            case 3:
                System.out.print("Enter grade: ");
                String grade = scanner.nextLine();
                for (Student student : students) {
                    if (student.getGrade().equalsIgnoreCase(grade)) {
                        System.out.println("ID: " + student.getId() +
                                           ", Name: " + student.getName() +
                                           ", Age: " + student.getAge() +
                                           ", Gender: " + student.getGender() +
                                           ", Grade: " + student.getGrade() +
                                           ", Contact Info: " + student.getContactInfo());
                        return;
                    }
                }
                System.out.println("Student grade not found.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}