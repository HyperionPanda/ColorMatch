import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.Timer;

public class BlinkTimer {

    List<JButton> order;
    Map<JButton, Color> colors;
    GameMaster gm;

    public BlinkTimer(GameMaster gm){
        this.gm = gm;
    }

    public void setOrder (List<JButton> order){
        this.order = order;
    }
    public void setColors (Map<JButton, Color> colors){
        this.colors = colors;
    }

    public void gameBlink() {


        Timer firstTimer = new Timer(2000, new ActionListener() {
            private int initialCounter = 0;

            int numberOfLights = order.size();

            @Override
            public void actionPerformed(ActionEvent e) {


                JButton lightButton = order.get(initialCounter);
                //lightButton.setBackground( colors.get(lightButton) );
                lightButton.setBackground(Color.BLACK);
                Timer blinkingTimer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //lightButton.setBackground(Color.BLACK);
                        lightButton.setBackground(colors.get(lightButton));
                    }
                });
                blinkingTimer.setRepeats(false);
                blinkingTimer.start();

                initialCounter++;
                if (initialCounter == numberOfLights) {
                    ((Timer) e.getSource()).stop();
                    gm.buttonOne.setEnabled(true);
                    gm.buttonTwo.setEnabled(true);
                    gm.buttonThree.setEnabled(true);
                    gm.buttonFour.setEnabled(true);


                }
            }
        });
        firstTimer.setRepeats(true);
        firstTimer.start();

    }
    public void clickBlink(JButton button, boolean answer) {
        Color finalColor;
        if(answer){
            finalColor = Color.GREEN;
        }else{
            finalColor = Color.RED;
        }
        Timer firstTimer = new Timer(250, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //lightButton.setBackground( colors.get(lightButton) );
                button.setBackground(finalColor);
                Timer blinkingTimer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.setBackground(colors.get(button));
                    }
                });
                blinkingTimer.setRepeats(false);
                blinkingTimer.start();


                ((Timer) e.getSource()).stop();

                //putting button enableds here gets them re-enabled as the red flashes, not after
            }
        });
        firstTimer.setRepeats(true);
        firstTimer.start();




    }



}
