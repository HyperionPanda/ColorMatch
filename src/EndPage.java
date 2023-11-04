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

        JLabel correct_label = new JLabel("Correct answers");
        correct_label.setText(correct_score.toString());
        //correct_label.setOpaque(true);
        correct_label.setLocation(100,100);
        correct_label.setBounds(0,125,450,250);


        JLabel incorrect_label = new JLabel("Incorrect answers");
        incorrect_label.setText(incorrect_score.toString());
        //correct_label.setOpaque(true);
        incorrect_label.setLocation(100,100);
        incorrect_label.setBounds(450,125,450,250);

        frame.add(correct_label);
        frame.add(incorrect_label);


    }
}
