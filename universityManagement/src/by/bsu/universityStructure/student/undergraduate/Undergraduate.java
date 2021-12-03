package by.bsu.universityStructure.student.undergraduate;

import by.bsu.universityStructure.academic.Academic;
import by.bsu.universityStructure.student.Student;

public class Undergraduate extends Student {
    private Academic tutor;

    public Undergraduate(String name, String login, Academic tutor) {
        super(name, login);
        this.tutor = tutor;
    }

    public Academic getTutor() {
        return tutor;
    }

    public void setTutor(Academic tutor) {
        this.tutor = tutor;
    }
}
