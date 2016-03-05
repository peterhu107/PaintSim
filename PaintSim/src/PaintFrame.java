import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Created by Peter Hu on 2016-02-16.
 */
public class PaintFrame extends JFrame {
    protected Tool currentTool;   // Current tool that is selected
    protected Color currentColor; // Current color being used
    protected EditPanel editingArea; // Panel for drawing content
    protected ArrayList<Tool> tools;  // List of all tools usable

    public PaintFrame() {
        super("Paint Sim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800,600));
        tools = new ArrayList<Tool>();

        //JMenuBar menu = new JMenuBar(); // Menu bar
        //setJMenuBar(menu);

        editingArea = new EditPanel();
        add(editingArea);

        ToolPanel toolPanel = new ToolPanel(this);
        toolPanel.setFrame(this);
        tools = toolPanel.addTools(); // has affect of setting the frame's selected as well
        editingArea.setActiveTool(currentTool);

        ColorPanel colorPanel = new ColorPanel(this);
        colorPanel.setFrame(this);

        add(colorPanel,BorderLayout.NORTH);
        add(toolPanel,BorderLayout.WEST);
        setColor(colorPanel.getColor());

        pack();
        setVisible(true);

    }

    public void setTool(Tool tool) {
        currentTool = tool;
        editingArea.selected = tool;
    }

    public void setColor (Color c) {
        currentColor = c;
        currentTool.setColor(c);
    }


}
