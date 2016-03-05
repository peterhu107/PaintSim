import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Peter Hu on 2016-02-15.
 */
public class ToolPanel extends JPanel {
    private Tool selected;    // Current selected tool
    private PaintFrame frame; // frame that this panel is a part of
    private ButtonGroup buttons; // group buttons together

    public ToolPanel(PaintFrame frame) {
        super(new GridLayout(0,1,0,0));
        setFrame(frame);
        buttons = new ButtonGroup();
        JLabel label = new JLabel("Tools");
        add(label);
    }

    public Tool getSelected() {
        return selected;
    }

    public void setSelected(Tool selected) {
        this.selected = selected;
        frame.setTool(selected);
    }

    public void setFrame(PaintFrame frame) {
        this.frame = frame;
    }
    public PaintFrame getFrame() {
        return frame;
    }

    public ArrayList<Tool> addTools() {
        ArrayList<Tool> tools = new ArrayList<Tool>();
        Pencil pencil = new Pencil("pencil",frame.currentColor,frame.editingArea, this);
        add(pencil);
        tools.add(pencil);
        Eraser eraser = new Eraser("eraser",frame.currentColor,frame.editingArea, this);
        add(eraser);
        tools.add(eraser);

        buttons.add(pencil);
        buttons.add(eraser);

        setSelected(pencil);
        pencil.doClick();
        return tools;
    }
}
