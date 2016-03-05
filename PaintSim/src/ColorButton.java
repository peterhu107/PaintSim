import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Peter Hu on 2016-02-16.
 */
public class ColorButton extends JToggleButton {
    private final Color buttonColor;
    private ColorPanel panel;

    public ColorButton(String value, ColorPanel panel) {
        super(new ImageIcon(ColorButton.class.getResource("/resources/" + value + ".jpg")));
        this.panel = panel;
        buttonColor = parseColor(value);
        addActionListener(new ButtonListener());
    }

    private Color parseColor(String name) {
        if (name.equals("black")) {
            return Color.black;
        }
        else if (name.equals("red")) {
            return Color.red;
        }
        else return Color.black;
    }

    public Color getColor() {
        return buttonColor;
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setColor(buttonColor);
        }
    }
}
