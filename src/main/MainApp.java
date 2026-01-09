package main;

import exception.StudentNotFoundException;
import model.Student;
import service.StudentService;
import util.FileUtil;


import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String args[]){

        // 1. Initialization
        StudentService service  = new StudentService();
        Scanner sc = new Scanner(System.in);

        // 2. Load data from file(if exists)
        List<Student> savedStudents = FileUtil.loadFromFIle();
        if(savedStudents != null){
            for(Student s : savedStudents){
                service.addStudent(s);
            }
        }

        // 3. Menu loop
        while(true){
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try{
                switch(choice){
                    case 1:
                        // Add Student
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Course: ");
                        String course = sc.nextLine();

                        System.out.print("Marks: ");
                        double marks = sc.nextDouble();

                        service.addStudent(
                            new Student(id, name, age, course, marks)
                        );
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        // View Students
                        for(Student s : service.getAllStudents()){
                            System.out.println(s);
                        }
                        break;

                    case 3:
                        // update Student
                        System.out.print("Enter ID to update: ");
                        int updatedId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("New Age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("New Marks: ");
                        double newMarks = sc.nextDouble();

                        service.updateStudent(updatedId, newName, newAge, newCourse, newMarks);
                        System.out.println("Student updated successfully.");
                        break;

                    case 4:
                        // Delete Student
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();
                        service.deleteStudent(deleteId);
                        System.out.println("Student deletedd successfully.");
                        break;
                    case 5:
                        // Exit
                        FileUtil.saveTOFIle(service.getAllStudents());
                        System.out.println("Data saved. Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }
            }catch(StudentNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
