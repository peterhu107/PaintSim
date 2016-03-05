import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Peter Hu on 2016-02-16.
 */
public class Pencil extends Tool {

    public Pencil(String name, Color color, EditPanel editingPanel, ToolPanel toolPanel) {
        super(name);
        this.editingPanel = editingPanel;
        this.color = color;
        this.toolPanel = toolPanel;
        setPreferredSize(new Dimension(25,25));
        addActionListener(new PencilListener());
    }

    public void draw(Point p) {
        BufferedImage img = editingPanel.getImage();
        img.setRGB(p.x,p.y,this.color.getRGB());
    }

    private class PencilListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            toolPanel.setSelected(Pencil.this);
        }
    }
}
