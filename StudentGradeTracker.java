import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Student Grade Tracker ===");
        
        while (true) {
            System.out.print("\nEnter student name (or type 'exit' to finish): ");
            String name = scanner.nextLine().trim();
            
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
                continue;
            }

            double grade = -1;
            while (true) {
                System.out.print("Enter grade for " + name + " (0 - 100): ");
                try {
                    grade = Double.parseDouble(scanner.nextLine());
                    if (grade >= 0 && grade <= 100) {
                        break;
                    } else {
                        System.out.println("Invalid input. Grade must be between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid numerical grade.");
                }
            }

            students.add(new Student(name, grade));
        }

        // Generate summary report if data exists
        if (students.isEmpty()) {
            System.out.println("\nNo student data entered. Exiting program.");
        } else {
            displaySummaryReport(students);
        }
        
        scanner.close();
    }

    private static void displaySummaryReport(ArrayList<Student> students) {
        double total = 0;
        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();
        
        String highestStudent = students.get(0).getName();
        String lowestStudent = students.get(0).getName();

        System.out.println("\n=================================");
        System.out.println("         SUMMARY REPORT          ");
        System.out.println("=================================");
        System.out.printf("%-20s | %-10s\n", "Student Name", "Grade");
        System.out.println("---------------------------------");

        for (Student s : students) {
            System.out.printf("%-20s | %-10.2f\n", s.getName(), s.getGrade());
            total += s.getGrade();

            if (s.getGrade() > highest) {
                highest = s.getGrade();
                highestStudent = s.getName();
            }
            if (s.getGrade() < lowest) {
                lowest = s.getGrade();
                lowestStudent = s.getName();
            }
        }

        double average = total / students.size();

        System.out.println("---------------------------------");
        System.out.printf("Total Students : %d\n", students.size());
        System.out.printf("Average Grade  : %.2f\n", average);
        System.out.printf("Highest Grade  : %.2f (%s)\n", highest, highestStudent);
        System.out.printf("Lowest Grade   : %.2f (%s)\n", lowest, lowestStudent);
        System.out.println("=================================");
    }
}