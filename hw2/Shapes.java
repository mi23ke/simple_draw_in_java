package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

//shapes contain only a point to be painted and a paintComponent
//function to paint a particular object; square, circle or text
public class Shapes {
  Point point;
  //each paintComponent function recieves a graphic object and a shape object
  //from PanelView; each shape type implements its own version of this method
  public void paintComponent (Graphics g, Shapes shape){};
}
