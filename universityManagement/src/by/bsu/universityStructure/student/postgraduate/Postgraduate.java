package by.bsu.universityStructure.student.postgraduate;

import by.bsu.universityStructure.academic.Academic;
import by.bsu.universityStructure.student.Student;

public class Postgraduate extends Student {
    private Academic supervisor;


    public Postgraduate(String name, String login, Academic supervisor) {
        super(name, login);
        this.supervisor = supervisor;
    }

    public Academic getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Academic supervisor) {
        this.supervisor = supervisor;
    }

}
