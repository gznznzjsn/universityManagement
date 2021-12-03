package by.bsu.tools;

import by.bsu.universityStructure.student.Student;

import java.util.Set;
import java.util.TreeSet;

public class Notifier {
    private final Set<Student> notifiables;

    public Notifier(Set<Student> notifiables) {
        this.notifiables = new TreeSet<>(notifiables);
    }

    public void doNotifyAll(){
        notifiables.forEach(Student::notifyHim);
    }
}
