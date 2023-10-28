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

        frame.add(start);
        frame.add(exit);

        ActionListener newListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                try {
                    String text = event.getActionCommand();

                    //String unit = outputUnit.getSelectedItem().toString();
                    String value = text;
                    if (value.equals("Exit")){
                        frame.dispose();
                    }else if (value.equals("Start")){
                        ConverterGUI cg = new ConverterGUI();
                        frame.dispose();
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