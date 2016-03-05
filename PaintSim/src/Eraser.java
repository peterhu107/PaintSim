import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Peter Hu on 2016-02-17.
 */
public class Eraser extends Tool {

    public Eraser(String name, Color color, EditPanel editingPanel, ToolPanel toolPanel) {
        super(name);
        this.editingPanel = editingPanel;
        this.color = color;
        this.toolPanel = toolPanel;
        setPreferredSize(new Dimension(25,25));
        addActionListener(new EraserListener());
    }

    public void draw(Point p) {
        BufferedImage img = editingPanel.getImage();
        Graphics2D img2 = img.createGraphics();
        img2.setPaint(editingPanel.getBackground());
        img2.fillRect(Math.max(0,p.x-5),Math.max(0,p.y-5),10,10);
    }

    private class EraserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            toolPanel.setSelected(Eraser.this);
        }
    }
}
