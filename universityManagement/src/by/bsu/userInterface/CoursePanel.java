package by.bsu.userInterface;

import by.bsu.universityStructure.Course;
import by.bsu.universityStructure.academic.Academic;
import by.bsu.universityStructure.student.postgraduate.Postgraduate;
import by.bsu.universityStructure.student.undergraduate.Undergraduate;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CoursePanel extends JPanel {
    private final Course course = new Course("Java",new TreeSet<>());
    private final JLabel labelTitle = new JLabel(course.getName());
    private final JList<Object> listStudents = new JList<>();
    private JScrollPane scrollPanelStudents = new JScrollPane(listStudents);
    private final JPanel panelButtons = new JPanel();


    public CoursePanel(){
        fillCourse();
        setPreferredSize(new Dimension(800,600));
        setLayout(new BorderLayout());
        setLabelTitle();
        setPanelStudents();
        setPanelButtons();
        add(labelTitle,BorderLayout.NORTH);
        add(scrollPanelStudents,BorderLayout.CENTER);
        add(panelButtons,BorderLayout.SOUTH);

    }

    private void setLabelTitle(){
        labelTitle.setBorder(BorderFactory.createTitledBorder(""));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void setPanelStudents(){
    listStudents.setListData(course.getStudents().toArray());
    listStudents.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    }
    public void setPanelButtons(){
        JComboBox<String> comboBoxStage= new JComboBox<>(new String[]{"all","postgraduates","undergraduates"});
        panelButtons.add(comboBoxStage);
        JComboBox<String> comboBoxAcademic= new JComboBox<>(new String[]{"all","Horstmann","Deitel"});
        panelButtons.add(comboBoxAcademic);
        JButton buttonShow = new JButton("show");
        buttonShow.addActionListener(e->{
            int stageIndex = comboBoxStage.getSelectedIndex();
            if(stageIndex == 0){
                    listStudents.setListData(course.getStudents().toArray());
            }
            if(stageIndex == 1){
                listStudents.setListData(course.getPostgraduates().toArray());
            }
            if(stageIndex == 2){
                listStudents.setListData(course.getUndergraduates().toArray());
            }
                });
        panelButtons.add(buttonShow);
    }

    private void fillCourse(){
        Academic deitel = new Academic("Paul Deitel");
        Academic horstmann = new Academic("Cay Horstmann");
        course.addStudent(new Undergraduate("Slim Shady XS","gg4", deitel));
        course.addStudent(new Undergraduate("Slim Shady S","pr3", horstmann));
        course.addStudent(new Postgraduate("Slim Shady M","te2",deitel));
        course.addStudent(new Postgraduate("Slim Shady L","yj34", horstmann));
        course.addStudent(new Postgraduate("Slim Shady XL","jj8",horstmann));
    }
}
