import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Peter Hu on 2016-02-17.
 */
public class EditPanel extends JPanel {
    protected Tool selected;
    private boolean activated; // Whether the tool should "work"
    private static final int IMG_WIDTH = 1920;
    private static final int IMG_HEIGHT = 1080;
    private BufferedImage image = new BufferedImage(IMG_WIDTH,IMG_HEIGHT,BufferedImage.TYPE_INT_ARGB);
    protected Point start; // Extrapolates for speed issues with MouseDragged

    public EditPanel() {
        super();
        setBackground(Color.ORANGE);
        MouseHandler mouse = new MouseHandler();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        activated = false;
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        setUpImage();
        repaint();
    }

    public void setActiveTool(Tool t) {
        selected = t;
    }

    public BufferedImage getImage() {
        return image;
    }

    private void setUpImage() {
        Graphics2D g = image.createGraphics();
        g.setPaint(getBackground());
        g.fillRect(0,0,1920,1080);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,null);
    }

    private class MouseHandler extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            activated = true;
            selected.draw(e.getPoint());
            repaint(e.getX(),e.getY(),1,1);
        }

        public void mouseReleased(MouseEvent e) {
            activated = false;
        }

        public void mouseDragged(MouseEvent e) {
            if (activated) {
                selected.draw(e.getPoint());
                repaint(e.getX(),e.getY(),50,50);
                // extrapolate with a saved Point and draw a line in between
            }
        }

    }


}
