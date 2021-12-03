package by.bsu.universityStructure.student;

import by.bsu.universityStructure.Person;

public class Student extends Person implements Notifiable, Comparable<Student> {
    private String login;
    private String email;


    protected Student(String name, String login) {
        super(name);
        this.login = login;
        this.email = login + "@bsu.by";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void notifyHim() {
        System.out.println("Listen here, you little "+this.getName());
    }

    @Override
    public int compareTo(Student s) {
        return login.compareTo(s.login);
    }

    @Override
    public String toString(){
        return this.getLogin()+" "+this.getName();
    }
}

interface Notifiable {
    void notifyHim();
}