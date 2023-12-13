import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndPage {

    private JFrame frame;
    Integer correct_score;
    Integer incorrect_score;

    public EndPage(int correct, int incorrect) {
        this.correct_score = correct;
        this.incorrect_score = incorrect;

        initializeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame("End");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UI();

        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(900, 510));
        frame.pack();
        frame.setVisible(true);
    }

    private void UI() {

        JLabel correct_label_name = new JLabel("Correct Name");
        correct_label_name.setText("Correct Answers");
        correct_label_name.setBounds(225,175,250,100);


        JLabel incorrect_label_name = new JLabel("Incorrect Name");
        incorrect_label_name.setText("Incorrect Answers");
        incorrect_label_name.setBounds(525,175,250,100);

        JLabel correct_label = new JLabel("Correct answers");
        correct_label.setText(correct_score.toString());
        //correct_label.setOpaque(true);
        correct_label.setBounds(275,225,100,100);


        JLabel incorrect_label = new JLabel("Incorrect answers");
        incorrect_label.setText(incorrect_score.toString());
        //correct_label.setOpaque(true);
        incorrect_label.setBounds(575,225,100,100);



        frame.add(correct_label);
        frame.add(incorrect_label);
        frame.add(correct_label_name);
        frame.add(incorrect_label_name);


    }
}
