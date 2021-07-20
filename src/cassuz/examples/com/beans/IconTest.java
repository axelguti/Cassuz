package cassuz.examples.com.beans;

import javax.swing.*;
import java.awt.*;

public class IconTest implements Icon {
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image image=new ImageIcon(getClass().getResource("../img/alerttt.png")).getImage();
        g.drawImage(image,x,y,c);
    }

    @Override
    public int getIconWidth() {
        return 50;
    }

    @Override
    public int getIconHeight() {
        return 50;
    }
}
