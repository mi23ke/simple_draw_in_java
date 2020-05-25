package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Text extends Shapes {
    Point point;
    @Override
    public void paintComponent (Graphics g, Shapes shape) {
      int x = (int)shape.point.getX();
      int y = (int)shape.point.getY();
      g.drawString("Hello, World!",x,y);
    }
}
