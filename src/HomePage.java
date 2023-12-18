import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


public class HomePage {

    private JFrame frame;

    public HomePage() {
        initializeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame("Homepage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UI();

        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(900, 510));
        frame.pack();
        frame.setVisible(true);
    }

    private void UI() {

        JButton start = new JButton("Start");
        start.setBorderPainted(false);
        start.setOpaque(true);
        start.setLocation(100,100);
        start.setBounds(0,125,450,250);


        JButton exit = new JButton("Exit");
        exit.setBorderPainted(false);
        exit.setOpaque(true);
        exit.setLocation(100,100);
        exit.setBounds(450,125,450,250);


        JLabel label_difficulty = new JLabel("Difficulty");
        label_difficulty.setBounds(413, 375, 200, 50);

        //Create non-editable text field
        JTextField difficulty = new JTextField(15);
        difficulty.setEditable(true);
        difficulty.setBounds(350, 425, 200, 30);
        difficulty.setText("0");

        frame.add(difficulty);
        frame.add(label_difficulty);
        frame.add(start);
        frame.add(exit);

        ActionListener newListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                try {
                    String value = event.getActionCommand();

                    switch(value){
                        case "Exit":
                            frame.dispose();
                            break;
                        case "Start":
                            int difficult = Integer.parseInt(difficulty.getText());
                            new ConverterGUI(difficult);
                            frame.dispose();
                            break;
                    }

                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println(e.getMessage());
                }
            }
        };
        // add ActionListener() to the button
        start.addActionListener(newListener);
        exit.addActionListener(newListener);

    }
}