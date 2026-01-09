package util;

import model.Student;

import java.io.*;
import java.util.List;

public class FileUtil {
    private static final String FILE_NAME = "students.dat";

    // save list of students to file
    public static void saveTOFIle(List<Student> students){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(students);
        }catch(IOException e){
            System.out.println("Error saving data to file.");
        }
    }
    
    // Load list of students from file
    @SuppressWarnings("unchecked")
    public static List<Student> loadFromFIle(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            return (List<Student>) ois.readObject();
        }
        catch (FileNotFoundException e) {
            // First run: file doesn't exist yet
            return null;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from file.");
            return null;
        }
    }
}
