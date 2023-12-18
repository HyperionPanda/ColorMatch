import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


import javax.swing.*;


public class ConverterGUI {
    int difficulty;

    private JFrame frame;

    public ConverterGUI(int difficulty) {this.difficulty = difficulty; initializeFrame();}

    private void initializeFrame() {
        frame = new JFrame("Vision Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UI();

        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(900, 510));
        frame.pack();
        frame.setVisible(true);
    }

    private void UI() {
        Map<Map<JButton, Color>, List<JButton>> pattern = null;
        Set<Map<JButton,Color>> keys = null;
        List<JButton> order;
        BlinkTimer blink_button;
        boolean game = false;

        JButton topLeft = new JButton("TL");
        topLeft.setBorderPainted(false);
        topLeft.setOpaque(true);
        topLeft.setLocation(100,100);
        topLeft.setBounds(0,0,450,250);
        topLeft.setEnabled(false);

        JButton topRight = new JButton("TR");
        topRight.setBorderPainted(false);
        topRight.setOpaque(true);
        topRight.setLocation(0,200);
        topRight.setBounds(450,0,450,250);
        topRight.setEnabled(false);

        JButton bottomLeft = new JButton("BL");
        bottomLeft.setBorderPainted(false);
        bottomLeft.setOpaque(true);
        bottomLeft.setLocation(0,250);
        bottomLeft.setBounds(0,250,450,250);
        bottomLeft.setEnabled(false);

        JButton bottomRight = new JButton("BR");
        bottomRight.setBorderPainted(false);
        bottomRight.setOpaque(true);
        bottomRight.setLocation(450,250);
        bottomRight.setBounds(450,250,450,250);
        bottomRight.setEnabled(false);


        GameMaster gm = new GameMaster(topLeft,topRight,bottomLeft,bottomRight);
        blink_button = new BlinkTimer(gm);

        topLeft.setBackground(gm.chooseButtonColor());
        topRight.setBackground(gm.chooseButtonColor());
        bottomLeft.setBackground(gm.chooseButtonColor());
        bottomRight.setBackground(gm.chooseButtonColor());

        //Add the frames using frame.add(frameName);
        frame.add(topLeft);
        frame.add(topRight);
        frame.add(bottomLeft);
        frame.add(bottomRight);

        //Under here for old action listener

        try {

            pattern = gm.playGame(1);
            keys = pattern.keySet();
            game = true;




        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }

        order = pattern.get(keys.iterator().next());
        blink_button.setOrder(order);

        if(game){

            Map<JButton,Color> colors = new HashMap<>();
            for(int c = 0; c< order.size();c++){
                colors.put(order.get(c),order.get(c).getBackground());
            }
            blink_button.setColors(colors);
            blink_button.gameBlink();

        }



        ActionListener newListener = new ActionListener() {
            int actionClick = 0;
            int correct = 0;
            int wrong = 0;
            final int overload = order.size();
            @Override
            public void actionPerformed(ActionEvent event) {
                if(actionClick == overload){
                    System.out.println("Done");

                    topLeft.setEnabled(false);
                    topRight.setEnabled(false);
                    bottomLeft.setEnabled(false);
                    bottomRight.setEnabled(false);
                    new EndPage(correct,wrong);
                    frame.dispose();

                }else {
                    JButton button = order.get(actionClick);
                    JButton changed_button = (JButton)event.getSource();

                    if (button.getActionCommand().equals(event.getActionCommand())) {
                        correct++;
                        System.out.println("True");

                        blink_button.clickBlink(changed_button,true);

                    } else {
                        wrong++;
                        System.out.println("False");
                        blink_button.clickBlink(changed_button,false);
                    }

                    actionClick++;
                }
            }
        };


        // add ActionListener() to the button
        topLeft.addActionListener(newListener);
        topRight.addActionListener(newListener);
        bottomLeft.addActionListener(newListener);
        bottomRight.addActionListener(newListener);

    }
}
