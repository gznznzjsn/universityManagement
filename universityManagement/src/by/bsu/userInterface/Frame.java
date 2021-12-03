package by.bsu.userInterface;

import javax.swing.*;

public class Frame {
    private JFrame frame = new JFrame("University Management");
    private final CoursePanel coursePanel = new CoursePanel();

    public Frame(){

        frame.add(coursePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
