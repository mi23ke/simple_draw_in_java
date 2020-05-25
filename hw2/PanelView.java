package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class PanelView extends JPanel {
  PointsRepository pRepo = new PointsRepository();
  @Override
  public void paintComponent (Graphics g) {
    //use the shapes copy list to print the shapes
    ArrayList<Shapes> shapes = pRepo.getCopy();
    super.paintComponent(g);
    //each Shape object type, Square,Circle and Text each implement thier own
    //version of paintComponent
    for(Shapes shape:shapes){
      shape.paintComponent(g, shape);
    }
  }
}
