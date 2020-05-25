package hw2;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Command {
  //the command class will need an instance of PointsRepository in order
  //to access the shapes list; the executeCommand method will be
  //implemented in the Undo, Redo and Clear classes
  //executeCommand(Shapes e) is implemented in AddShape class
  PointsRepository pRepo = new PointsRepository();
  public void executeCommand (){};
  public void executeCommand(Shapes s){};
}
