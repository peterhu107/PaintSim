import javax.swing.*;
import java.awt.*;


/**
 * Created by Peter Hu on 2016-02-15.
 */
public class ColorPanel extends JPanel {
    private ButtonGroup buttons;
    private Color currentColor;
    private PaintFrame frame;

    public ColorPanel(PaintFrame frame) {
        super(new GridLayout(1,0,20,0));
        setPreferredSize(new Dimension(400,30));
        setFrame(frame);
        add(new JLabel("Colours"));

        buttons = new ButtonGroup();

        ColorButton black = new ColorButton("black", this);

        ColorButton red = new ColorButton("red", this);
        // Update ColorButton enumeration method to add more colours

        buttons.add(black);
        buttons.add(red);
        add(black);
        add(red);
        setColor(black.getColor());
        black.doClick();  // Toggle black as default colour

    }

    public void setFrame(PaintFrame frame) {
        this.frame = frame;
    }

    public Color getColor() {
        return currentColor;
    }

    public void setColor(Color currentColor) {
        this.currentColor = currentColor;
        frame.setColor(currentColor);
    }


}
