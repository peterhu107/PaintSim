import javax.swing.*;
import java.awt.*;

/**
 * Created by Peter Hu on 2016-02-15.
 */
public abstract class Tool extends JToggleButton {
    protected EditPanel editingPanel;
    protected Color color;
    protected ToolPanel toolPanel;

    public Tool(String imgPath) {
        super(new ImageIcon(Tool.class.getResource("/resources/"+ imgPath + ".jpg")));
    }
    public abstract void draw(Point p);

    public void setColor(Color c) {
        color = c;
    }
}
