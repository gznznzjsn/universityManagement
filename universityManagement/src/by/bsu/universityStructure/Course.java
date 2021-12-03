package by.bsu.universityStructure;

import by.bsu.universityStructure.academic.Academic;
import by.bsu.universityStructure.student.Student;
import by.bsu.universityStructure.student.postgraduate.Postgraduate;
import by.bsu.universityStructure.student.undergraduate.Undergraduate;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Course implements Iterable<Student>{
    private String name;
    private final Set<Student> students;


    public Course(String name, Set<Student> students) {
        this.name = name;
        this.students = new TreeSet<>(students);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<Student> getStudents(Academic academic) {
        Set<Student> result = new TreeSet<>();
        students.forEach(student -> {
            if(student.getClass()==Postgraduate.class &&
                    ((Postgraduate) student).getSupervisor()== academic){
                result.add(student);
            }
            if(student.getClass()==Undergraduate.class &&
                    ((Undergraduate) student).getTutor()== academic){
                result.add(student);
            }
        });
        return result;
    }

    public Set<Postgraduate> getPostgraduates(Academic supervisor){
        Set<Postgraduate> postgraduates = new TreeSet<>();
        students.forEach(student -> {
            if(student.getClass()==Postgraduate.class &&
                    ((Postgraduate) student).getSupervisor() == supervisor){
                postgraduates.add((Postgraduate) student);
            }
        });
        return postgraduates;
    }
    public Set<Postgraduate> getPostgraduates(){
        Set<Postgraduate> postgraduates = new TreeSet<>();
        students.forEach(student -> {
            if(student.getClass()==Postgraduate.class){
                postgraduates.add((Postgraduate) student);
            }
        });
        return postgraduates;
    }

    public Set<Undergraduate> getUndergraduates(){
        Set<Undergraduate> undergraduates = new TreeSet<>();
        students.forEach(student -> {
            if(student.getClass()==Undergraduate.class){
                undergraduates.add((Undergraduate) student);
            }
        });
        return undergraduates;
    }

    public void addStudent(Student s){
        students.add(s);
    }


    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public Set<Student> getAppropriate(Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.<Student>toSet());
    }
}
