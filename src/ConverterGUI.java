import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.Timer;


import javax.swing.*;


public class ConverterGUI {

    private JFrame frame;

    public ConverterGUI() {
        initializeFrame();
    }

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
        String buttonPressed = "";
        Boolean blinking_done = false;
        //under here for new before listener stuff
        Map<Map<JButton, Color>, List<JButton>> pattern = null;
        Set<Map<JButton,Color>> keys = null;
        List<JButton> order;
        Boolean game = false;




        //Create and manage title

        /*
        JLabel title = new JLabel("Vision test");
        title.setBounds(60, 10, 400, 30);
        */


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


        //Create non-editable text field
        JTextField changeIt = new JTextField(15);
        changeIt.setEditable(false);
        changeIt.setLocation(10, 200);
        changeIt.setBounds(600, 450, 200, 30);

        GameMaster gm = new GameMaster(topLeft,topRight,bottomLeft,bottomRight);

        topLeft.setBackground(gm.chooseButtonColor());
        topRight.setBackground(gm.chooseButtonColor());
        bottomLeft.setBackground(gm.chooseButtonColor());
        bottomRight.setBackground(gm.chooseButtonColor());

        //Add the frames using frame.add(framename);
        frame.add(changeIt);
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
            changeIt.setText("Invalid Input");
        }

        order = pattern.get(keys.iterator().next());

        if(game){

            Map<JButton,Color> colors = new HashMap<>();
            for(int c = 0; c< order.size();c++){
                colors.put(order.get(c),order.get(c).getBackground());
            }

            Timer firstTimer = new Timer( 2000, new ActionListener(){
                private int initialCounter = 0;

                int numberOfLights = order.size();
                @Override
                public void actionPerformed(ActionEvent e){
                    switch( initialCounter ){
                        default:
                            JButton lightButton = order.get(initialCounter);
                            //lightButton.setBackground( colors.get(lightButton) );
                            lightButton.setBackground(Color.BLACK);
                            Timer blinkingTimer = new Timer( 1000, new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e){
                                    //lightButton.setBackground(Color.BLACK);
                                    lightButton.setBackground( colors.get(lightButton) );
                                }
                            });
                            blinkingTimer.setRepeats( false );
                            blinkingTimer.start();


                    }
                    initialCounter++;
                    if ( initialCounter == numberOfLights ){
                        ((Timer)e.getSource()).stop();
                        topLeft.setEnabled(true);
                        topRight.setEnabled(true);
                        bottomLeft.setEnabled(true);
                        bottomRight.setEnabled(true);

                    }
                }
            } );
            firstTimer.setRepeats( true );
            firstTimer.start();



        }


        ActionListener newListener = new ActionListener() {
            int actionClick = 0;
            int overload = order.size();
            @Override
            public void actionPerformed(ActionEvent event) {
                if(actionClick == overload){
                    System.out.println("Done");
                    topLeft.setEnabled(false);
                    topRight.setEnabled(false);
                    bottomLeft.setEnabled(false);
                    bottomRight.setEnabled(false);

                }else {
                    JButton button = order.get(actionClick);
                    if (button.getActionCommand().equals(event.getActionCommand())) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                        System.out.println(button.getActionCommand());
                        System.out.println(event.getActionCommand());
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

        /*
        //Create listener for doing stuff
        ActionListener newListener = new ActionListener() {
            Map<Map<JButton, Color>, List<JButton>> pattern;
            Set<Map<JButton,Color>> keys;
            List<JButton> order;
            Boolean game = false;

            @Override
            public void actionPerformed(ActionEvent event) {

                try {
                    String text = event.getActionCommand();

                    //String unit = outputUnit.getSelectedItem().toString();
                    String value = text;
                    changeIt.setText(value);
                    if(value.equals("BR")){
                        pattern = gm.playGame(1);
                        keys = pattern.keySet();
                        game = true;

                    }


                } catch (Exception e) {
                    changeIt.setText("Invalid Input");
                }
                if(game){

                    order = pattern.get(keys.iterator().next());
                    Map<JButton,Color> colors = new HashMap<>();
                    for(int c = 0; c< order.size();c++){
                        colors.put(order.get(c),order.get(c).getBackground());
                    }

                    Timer firstTimer = new Timer( 2000, new ActionListener(){
                        private int initialCounter = 0;
                        int numberOfLights = order.size();
                        @Override
                        public void actionPerformed(ActionEvent e){
                            switch( initialCounter ){
                                default:
                                    JButton lightButton = order.get(initialCounter);
                                    //lightButton.setBackground( colors.get(lightButton) );
                                    lightButton.setBackground(Color.BLACK);
                                    Timer blinkingTimer = new Timer( 1000, new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent e){
                                            //lightButton.setBackground(Color.BLACK);
                                            lightButton.setBackground( colors.get(lightButton) );
                                        }
                                    });
                                    blinkingTimer.setRepeats( false );
                                    blinkingTimer.start();

                            }
                            initialCounter++;
                            if ( initialCounter == numberOfLights ){
                                ((Timer)e.getSource()).stop();

                            }
                        }
                    } );
                    firstTimer.setRepeats( true );
                    firstTimer.start();


                }



            }
        };
         */


    }
}
