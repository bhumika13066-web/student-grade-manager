import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentGradeManagerGUI extends JFrame {

    JTextField nameField, gradeField;
    JTextArea reportArea;

    ArrayList<String> names = new ArrayList<>();
    ArrayList<Double> grades = new ArrayList<>();

    public StudentGradeManagerGUI() {

        setTitle("Student Grade Manager");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Grade:"));
        gradeField = new JTextField(15);
        add(gradeField);

        JButton addButton = new JButton("Add Student");
        JButton reportButton = new JButton("Generate Report");

        add(addButton);
        add(reportButton);

        reportArea = new JTextArea(15, 40);
        reportArea.setEditable(false);
        add(new JScrollPane(reportArea));

        addButton.addActionListener(e -> {

            names.add(nameField.getText());
            grades.add(Double.parseDouble(gradeField.getText()));

            nameField.setText("");
            gradeField.setText("");
        });

        reportButton.addActionListener(e -> {

            double total = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            String report = "===== STUDENT REPORT =====\n\n";

            for (int i = 0; i < names.size(); i++) {

                report += names.get(i) + " : " + grades.get(i) + "\n";

                total += grades.get(i);

                if (grades.get(i) > highest)
                    highest = grades.get(i);

                if (grades.get(i) < lowest)
                    lowest = grades.get(i);
            }

            double average = total / grades.size();

            report += "\nAverage Score: " + average;
            report += "\nHighest Score: " + highest;
            report += "\nLowest Score: " + lowest;

            reportArea.setText(report);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentGradeManagerGUI();
    }
}