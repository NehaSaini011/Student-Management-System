package service;


import exception.StudentNotFoundException;
import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService{

    private List<Student> students;
    public StudentService(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getAllStudents(){
        return students;
    }
    public Student findById(int id) throws StudentNotFoundException{
        for (Student s: students){
            if(s.getId() == id){
                return s;
            }
        }
        throw new StudentNotFoundException("Student with ID "+ id + " not found");
    }
    public void deleteStudent(int id) throws StudentNotFoundException{
        Student s = findById(id);
        students.remove(s);
    }

    public void updateStudent(int id, String name, int age, String course, double marks) throws StudentNotFoundException{
        Student s = findById(id);
        s.setName(name);
        s.setAge(age);
        s.setCourse(course);
        s.setMarks(marks);
    }


}