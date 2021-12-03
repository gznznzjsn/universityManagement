package by.bsu;

import by.bsu.tools.CoursePredicates;
import by.bsu.tools.Writer;
import by.bsu.universityStructure.Course;
import by.bsu.tools.Notifier;
import by.bsu.universityStructure.academic.Academic;
import by.bsu.universityStructure.student.Student;
import by.bsu.universityStructure.student.postgraduate.Postgraduate;
import by.bsu.universityStructure.student.undergraduate.Undergraduate;
import by.bsu.userInterface.Frame;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ProgrammingTest{

    public static void main(String[] args) {
        Academic deitel = new Academic("Paul Deitel");
        Academic horstmann = new Academic("Cay Horstmann");
        Set<Student> listOfStudents = new TreeSet<>();
        listOfStudents.add(new Undergraduate("Slim Shady XS","gg4", deitel));
        listOfStudents.add(new Undergraduate("Slim Shady S","pr3", horstmann));
        listOfStudents.add(new Postgraduate("Slim Shady M","te2",deitel));
        listOfStudents.add(new Postgraduate("Slim Shady L","yj34", horstmann));
        listOfStudents.add(new Postgraduate("Slim Shady XL","jj8",horstmann));
        Course course = new Course("java", listOfStudents);
        System.out.println(course.getPostgraduates(horstmann));
        Notifier notifier = new Notifier(listOfStudents);
        notifier.doNotifyAll();
        course.addStudent(new Postgraduate("Slim Shady XXL","sg5",horstmann));
        System.out.println(course.getPostgraduates(horstmann));
        Iterator<Student> iterator = course.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(course.getAppropriate(CoursePredicates.isStudentOf(horstmann)));
        Writer.writeCourse("output.txt",course);
        Frame frame = new Frame();
    }
}
