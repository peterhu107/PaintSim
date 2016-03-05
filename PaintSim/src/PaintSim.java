import javax.swing.*;
import java.awt.*;

/**
 * Created by Peter Hu on 2016-02-13.
 */
public class PaintSim {

    private static void setUp() {
        JFrame frame = new PaintFrame();
    }
    public static void main(String ... args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setUp();
            }
        });
    }
}
