import javax.swing.*;
import java.awt.Color;
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


    public Map<Map<JButton, Color>, List<JButton>> playGame(int difficulty){


        Map<Map<JButton, Color>, List<JButton>> pattern_Connection = new HashMap<>();

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
                int randomNum = (int) (Math.random() * ((3) + 1));
                JButton button = buttonList.get(randomNum);
                patterned.add(button);
            }

            pattern_Connection.put(pattern_to_color, patterned);

        }

        return pattern_Connection;

    }

    public Color chooseButtonColor (){
        List<Color> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.GREEN);

        int min = 0;
        int max = colors.size()-1;
        int randomNum = min + (int)(Math.random() * ((max - min) + 1));

        return colors.get(randomNum);

    }

}
