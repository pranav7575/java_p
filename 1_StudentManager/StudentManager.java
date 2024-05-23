import java.util.*;
  class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    
    public String toString() {
        return "Student{name='" + name + "', rollNumber=" + rollNumber + ", grade='" + grade + "'}";
    }
}


 class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int rollNumber, String grade) {
        students.add(new Student(name, rollNumber, grade));
    }

    public void removeStudent(int rollNumber) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber() == rollNumber) {
                iterator.remove();
                System.out.println("Student with roll number " + rollNumber + " removed.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void replaceGrade(int rollNumber, String newGrade) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setGrade(newGrade);
                System.out.println("Grade updated for student with roll number " + rollNumber + ".");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Display all students");
            System.out.println("4. Replace grade of a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    manager.addStudent(name, rollNumber, grade);
                    break;
                case 2:
                    System.out.print("Enter roll number of the student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    manager.removeStudent(rollToRemove);
                    break;
                case 3:
                    manager.displayStudents();
                    break;
                case 4:
                    System.out.print("Enter roll number of the student to replace grade: ");
                    int rollToReplace = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    manager.replaceGrade(rollToReplace, newGrade);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
