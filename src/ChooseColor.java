import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.random.RandomGenerator;

public class ChooseColor {

    public Color chooseButtonColor (JButton button){
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
