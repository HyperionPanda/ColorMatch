import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GameMaster {

    JButton buttonOne;
    JButton buttonTwo;
    JButton buttonThree;
    JButton buttonFour;

    List<JButton> buttonList = new ArrayList<>();



    public GameMaster(JButton one,JButton two,JButton three,JButton four){
        this.buttonOne = one;
        this.buttonTwo = two;
        this.buttonThree = three;
        this.buttonFour = four;
        buttonList.add(buttonOne);
        buttonList.add(buttonTwo);
        buttonList.add(buttonThree);
        buttonList.add(buttonFour);
    }


    public Map<Map<JButton, Color>, List<JButton>> playGame(int difficulty) throws InterruptedException {

        Map<Integer, Map<JButton, Color>> pattern_with_index = new HashMap<>();

        Map<Map<JButton, Color>, List<JButton>> pattern_Connection = new HashMap<>();

        int counter = 0;

        //create all patterns (number based on difficulty)
        for (int i = 0; i < difficulty; i++) {
            Map<JButton, Color> pattern_to_color = new HashMap<>();
            //For each button in a pattern, give them a color

            for (int j = 0; j < buttonList.size(); j++) {
                pattern_to_color.put(buttonList.get(j), buttonList.get(j).getBackground());
            }

            //Create a random order pattern of buttons for each color pattern
            List<JButton> patterned = new ArrayList<>();
            for (int d = 0; d < 10; d++) {
                int randomNum = 0 + (int) (Math.random() * ((3 - 0) + 1));
                JButton button = buttonList.get(randomNum);
                patterned.add(button);
            }

            pattern_Connection.put(pattern_to_color, patterned);
            //all_patterns.put(pattern_to_color,buttonList.get(randomNum));
            pattern_with_index.put(counter, pattern_to_color);
            counter++;
        }

        return pattern_Connection;

        /*
        //Testing inside double pattern what happens to buttons
        for (int current = 0; current < pattern_with_index.size(); current++) {

            Map<JButton, Color> current_Pattern = pattern_with_index.get(current);

            List<JButton> byPattern = pattern_Connection.get(current_Pattern);


            for (int g = 0; g < byPattern.size(); g++) {

                JButton chosenButton = byPattern.get(g);
                Color color = chosenButton.getBackground();
                System.out.println(color.toString());
                //ISSUE
                //Timer fires but for loop continues, meaning old variables get overriden
                //Have method return to ConverterGui with pattern_connection(?) and work next part from GUI
                System.out.println("1");
                Timer t = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("2");
                        //((Timer)e.getSource()).stop();
                        //chosenButton.setBackground(color);
                        //this.notify();

                    }
                });
                t.setInitialDelay(0);
                t.setRepeats(false);
                t.start();
                synchronized (t){
                    while(t.isRunning()){
                        Thread.sleep(1500);
                    }

                }

                //chosenButton.setBackground(Color.BLACK);
                //System.out.println("2");
                //while(t.isRunning()){this.wait();}
                //chosenButton.setBackground(color);
                System.out.println("3");


                //ISSUE
                //Timer fires but rest of the program continues without, meaning color gets overwritten and it never gets changed



            }

        }

         */
    }

    public void resetButton(JButton button,Color color){}

    public Color chooseButtonColor (){
        List<Color> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.GREEN);

        int min = 0;
        int max = colors.size()-1;
        int randomNum = min + (int)(Math.random() * ((max - min) + 1));

        Color chosenColor = colors.get(randomNum);

        return chosenColor;

    }

}
