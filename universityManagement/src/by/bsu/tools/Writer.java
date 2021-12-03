package by.bsu.tools;

import by.bsu.universityStructure.Course;
import by.bsu.universityStructure.student.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Writer {
    public static void writeCourse(String fileName, Course course){
        try(FileWriter fileWriter= new FileWriter(new File(fileName))){
            fileWriter.write("Course \""+course.getName()+"\"\nStudents:\n");
            Iterator<Student> iterator = course.iterator();
            while (iterator.hasNext()){
                fileWriter.append(iterator.next().toString()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
