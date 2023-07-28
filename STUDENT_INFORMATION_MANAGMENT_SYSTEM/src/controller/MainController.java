package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.AdminDao;
import dao.StudentDao;
import model.AdminModel;
import model.StudentModel;
import service.AdminService;
import service.StudentDetails;


public class MainController {

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Information Management System");

        // Admin authentication
        AdminDao adminDao = new AdminDao();
        AdminService adminservice = new AdminService();
        System.out.print("Admin Username: ");
        String adminUsername = sc.nextLine();
        System.out.print("Admin Password: ");
        String adminPassword = sc.nextLine();
        boolean isAuthenticated = adminservice.authenticateAdmin(adminUsername, adminPassword);

        if (!isAuthenticated) {
            System.out.println("Authentication failed. Exiting the program.");
            sc.close();
            return;
        }

        StudentDetails studentService = new StudentDetails();
        StudentDao studentDao = new StudentDao();

        while (true) {
            System.out.println("1) Add Student\n2) View Students\n3) Update Student by ID\n4) Delete Student by ID\n5) Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                	addStudent(sc, studentService);
                    break;
                case 2:
                    viewStudents(studentDao);
                    break;
                case 3:
                    updateStudent(sc, studentService);
                    break;
                case 4:
                    deleteStudent(sc, studentService);
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent(Scanner sc, StudentDetails studentService) {
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student Class: ");
        String studentClass = sc.nextLine();

        System.out.print("Enter Student Course: ");
        String studentCourse = sc.nextLine();

        System.out.print("Enter Student Date of Birth (DOB): ");
        String studentDateOfBirth = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int studentAge = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter Student Address: ");
        String studentAddress = sc.nextLine();

        System.out.print("Enter Student CGPA: ");
        double studentCgpa = sc.nextDouble();
        sc.nextLine(); // Consume the newline character

        StudentModel student = new StudentModel(studentId, studentName, studentClass, studentCourse, studentDateOfBirth,
                studentAge, studentAddress, studentCgpa);

        studentService.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void viewStudents(StudentDao studentDao) {
        ArrayList<StudentModel> students = studentDao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
        	 System.out.println("+------+----------------------+--------------+----------------------+-----+---------------------+");
             System.out.printf("| %-4s | %-10s | %-10s | %-10s | %-10s | %-4s | %-20s | %-4s |%n", "ID", "Name", "Class", "Course", "DOB", "Age", "Address", "CGPA");
             
             for (StudentModel student : students) {
            	 System.out.println("+-----------------------------------------------------------------------------------------------");
                 System.out.printf("| %-4d | %-10s | %-10s | %-10s | %-10s | %-4d | %-20s | %-4s|%n",
                         student.getStudentId(), student.getStudentName(), student.getStudentClass(), student.getStudentCourse(),
                         student.getStudentDateOfBirth(), student.getStudentAge(), student.getStudentAddress(), student.getStudentCgpa());
             }
             System.out.println("+------+----------------------+--------------+----------------------+-----+---------------------+");
            }
        }
    

    private static void updateStudent(Scanner sc, StudentDetails studentService) {
        System.out.print("Enter Student ID to update: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        StudentModel existingStudent = studentService.getStudentById(studentId);
        if (existingStudent == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        System.out.print("Enter new Student Name (Leave empty to keep current): ");
        String studentName = sc.nextLine();
        if (!studentName.isEmpty()) {
            existingStudent.setStudentName(studentName);
        }

        System.out.print("Enter new Student Class (Leave empty to keep current): ");
        String studentClass = sc.nextLine();
        if (!studentClass.isEmpty()) {
            existingStudent.setStudentClass(studentClass);
        }

        System.out.print("Enter new Student Course (Leave empty to keep current): ");
        String studentCourse = sc.nextLine();
        if (!studentCourse.isEmpty()) {
            existingStudent.setStudentCourse(studentCourse);
        }

        System.out.print("Enter new Student Date of Birth (DOB) (Leave empty to keep current): ");
        String studentDateOfBirth = sc.nextLine();
        if (!studentDateOfBirth.isEmpty()) {
            existingStudent.setStudentDateOfBirth(studentDateOfBirth);
        }

        System.out.print("Enter new Student Age (Enter -1 to keep current): ");
        int studentAge = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        if (studentAge != -1) {
            existingStudent.setStudentAge(studentAge);
        }

        System.out.print("Enter new Student Address (Leave empty to keep current): ");
        String studentAddress = sc.nextLine();
        if (!studentAddress.isEmpty()) {
            existingStudent.setStudentAddress(studentAddress);
        }

        System.out.print("Enter new Student CGPA (Enter -1 to keep current): ");
        double studentCgpa = sc.nextDouble();
        sc.nextLine(); // Consume the newline character
        if (studentCgpa != -1) {
            existingStudent.setStudentCgpa(studentCgpa);
        }

        studentService.updateStudent(existingStudent);
        System.out.println("Student with ID " + studentId + " updated successfully.");
    }

    private static void deleteStudent(Scanner sc, StudentDetails studentService) {
        System.out.print("Enter Student ID to delete: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        StudentModel existingStudent = studentService.getStudentById(studentId);
        if (existingStudent == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        studentService.deleteStudent(studentId);
        System.out.println("Student with ID " + studentId + " deleted successfully.");
    }
}
