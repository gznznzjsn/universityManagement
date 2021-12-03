package by.bsu.tools;

import by.bsu.universityStructure.academic.Academic;
import by.bsu.universityStructure.student.Student;
import by.bsu.universityStructure.student.postgraduate.Postgraduate;
import by.bsu.universityStructure.student.undergraduate.Undergraduate;

import java.util.function.Predicate;

public class CoursePredicates {
    public static Predicate<Student> isStudentOf(Academic academic){
        return student -> {
            if (student instanceof Undergraduate) {
                return ((Undergraduate) student).getTutor() == academic;
            }
            if (student instanceof Postgraduate) {
                return ((Postgraduate) student).getSupervisor() == academic;
            }
            return false;
        };
    }
}
